package com.id.control.config;

import com.id.control.entity.Usuario;
import com.id.control.entity.UsuarioSeguridad;
import com.id.control.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.api.secret}")
    private String secretSign;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateTokenUser(Usuario usuarios) {
        return generateToken(new HashMap<>(), usuarios);
    }

    private String generateToken(
            Map<String, Object> extraClaims,
            Usuario usuarios) {

        return Jwts.builder()
                .claims(extraClaims)
                .subject(usuarios.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + 1000L * 60 * 24))
                .signWith(signInKey())
                .compact();
    }

    @Override
    public boolean isTokenValid(
            String token,
            UsuarioSeguridad usuarios) {

        final String username = extractUsername(token);

        return username.equals(usuarios.getUsuario().getUsername())
                && !isTokenExpired(token);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Claims extractAllClaims(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(signInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        log.info("Claims o cuerpo de JWT: {}", claims);

        return claims;
    }

    private SecretKey signInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretSign);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
