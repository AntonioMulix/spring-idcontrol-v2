package com.id.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "challenge_passkey")
public class ChallengePasskey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_challenge_passkey")
    private Long idChallengePasskey;
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "challenge")
    private String challenge;

    public ChallengePasskey() {
    }

    public ChallengePasskey(Long idChallengePasskey, Long usuarioId, String challenge) {
        this.idChallengePasskey = idChallengePasskey;
        this.usuarioId = usuarioId;
        this.challenge = challenge;
    }

    public Long getIdChallengePasskey() {
        return idChallengePasskey;
    }

    public void setIdChallengePasskey(Long idChallengePasskey) {
        this.idChallengePasskey = idChallengePasskey;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

}
