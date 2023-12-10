package com.example.dev_200_1_network_client_data_storage_system_jpa.dto;

import com.example.dev_200_1_network_client_data_storage_system_jpa.entity.AddressEntity;
import com.example.dev_200_1_network_client_data_storage_system_jpa.entity.ClientEntity;

import java.util.Objects;

public class AddressDto {
    private String mac;
    private String ip;
    private String model;
    private String address;
    private ClientDto client;

    public AddressDto(String mac, String ip, String model, String address, ClientDto client) {
        this.mac = mac;
        this.ip = ip;
        this.model = model;
        this.address = address;
        this.client = client;
    }

    public AddressDto(String mac, String ip, String model, String address) {
        this.mac = mac;
        this.ip = ip;
        this.model = model;
        this.address = address;
    }

    public AddressDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(mac, that.mac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mac);
    }

    public static AddressDto getAddressDtoByEntity(AddressEntity addressEntity) {
        AddressDto addressDto = new AddressDto();
        if (addressEntity != null) {
            addressDto.mac = addressEntity.getMac();
            addressDto.ip = addressEntity.getIp();
            addressDto.model = addressEntity.getModel();
            addressDto.address = addressEntity.getAddress();
        } else addressDto = null;
        return addressDto;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
