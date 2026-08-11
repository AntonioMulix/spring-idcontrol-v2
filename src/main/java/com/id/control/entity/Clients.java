package com.id.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "api_key_hash")
    private String apiKeyHash;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Clients() {
    }

    public Clients(Long idClient, String clientName, String apiKeyHash, Boolean enabled, LocalDateTime createdAt) {
        this.idClient = idClient;
        this.clientName = clientName;
        this.apiKeyHash = apiKeyHash;
        this.enabled = enabled;
        this.createdAt = createdAt;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getApiKeyHash() {
        return apiKeyHash;
    }

    public void setApiKeyHash(String apiKeyHash) {
        this.apiKeyHash = apiKeyHash;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
