package com.example.dev_200_1_network_client_data_storage_system_jpa.dto;

import com.example.dev_200_1_network_client_data_storage_system_jpa.entity.ClientEntity;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDto {
    private Integer clientId;
    private String clientName;
    private String type;
    private Instant added;
    private Set<AddressDto> addresses = new LinkedHashSet<>();

    public ClientDto(Integer clientId, String clientName, String type, Instant added, Set<AddressDto> addresses) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.type = type;
        this.added = added;
        this.addresses = addresses;
    }

    public ClientDto(Integer clientId, String clientName, String type, Instant added) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.type = type;
        this.added = added;
    }

    public ClientDto(String clientName, String type, Instant added) {
        this.clientName = clientName;
        this.type = type;
        this.added = added;
    }

    public ClientDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(clientId, clientDto.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    public static ClientDto getClientDtoByEntity(ClientEntity clientEntity) {
        ClientDto clientDto = new ClientDto();
        if (clientEntity != null) {
            clientDto.clientId = clientEntity.getClientId();
            clientDto.clientName = clientEntity.getClientName();
            clientDto.type = clientEntity.getType();
            clientDto.added = clientEntity.getAdded();
            clientDto.addresses = clientEntity.getAddresses()
                    .stream()
                    .map(AddressDto::getAddressDtoByEntity)
                    .collect(Collectors.toSet());
        } else clientDto = null;
        return clientDto;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
