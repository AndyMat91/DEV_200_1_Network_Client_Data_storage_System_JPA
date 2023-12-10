package com.example.dev_200_1_network_client_data_storage_system_jpa.entity;

import com.example.dev_200_1_network_client_data_storage_system_jpa.dto.AddressDto;
import com.example.dev_200_1_network_client_data_storage_system_jpa.dto.ClientDto;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "clients", schema = "client_db")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "client_name", length = 100)
    private String clientName;

    @Column(name = "client_type", length = 20)
    private String type;

    @Column(name = "datereg")
    private Instant added;

    @OneToMany(mappedBy = "client")
    private Set<AddressEntity> addresses = new LinkedHashSet<>();

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getAdded() {
        return added;
    }

    public void setAdded(Instant added) {
        this.added = added;
    }

    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public static ClientEntity getClientEntityByDto(ClientDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        if (clientDto != null) {
            clientEntity.clientName = clientDto.getClientName();
            clientEntity.type = clientDto.getType();
            clientEntity.added = clientDto.getAdded();
        } else clientEntity = null;
        return clientEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity client = (ClientEntity) o;
        return Objects.equals(clientId, client.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", type='" + type + '\'' +
                ", added=" + added +
                ", addresses=" + addresses +
                '}';
    }
}