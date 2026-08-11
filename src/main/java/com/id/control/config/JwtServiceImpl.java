package com.id.control.config;

import com.id.control.entity.Usuario;
import com.id.control.entity.UsuarioSeguridad;
import com.id.control.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Slf4j //LOGGER
@Service
public class JwtServiceImpl implements JwtService {

    //Variables de properties
    @Value("${security.api.secret}")
    private String secretSign;

    //Service that returns the username, to complete the code of JWT
    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Extract the sintgle claim
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateTokenUser(Usuario usuarios) {
        return generateToken(new HashMap<>(), usuarios);
    }

    //Generate token
    private String generateToken(Map<String, Object> extraClaims, Usuario usuarios) {

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(usuarios.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(signInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    //Method that validate a token
    @Override
    public boolean isTokenValid(String token, UsuarioSeguridad usuarios) {
        final String username = extractUsername(token);
        return (username.equals(usuarios.getUsuario().getUsername()) && !isTokenExpired(token));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //Method that tell if the token is expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Claims extractAllClaims(String token) {
        log.info("Claims o cuerpo de JWT: " + Jwts.parser()
                .setSigningKey(signInKey())
                .build()
                .parseClaimsJws(token)
                .getBody());
        return Jwts.parser()
                .setSigningKey(signInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key signInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretSign);
        return Keys.hmacShaKeyFor(keyBytes);

    }

}
