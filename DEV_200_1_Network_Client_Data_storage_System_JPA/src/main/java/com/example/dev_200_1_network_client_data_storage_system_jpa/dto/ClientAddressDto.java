package com.example.dev_200_1_network_client_data_storage_system_jpa.dto;

import java.sql.Timestamp;

public class ClientAddressDto {
    private int clientId;
    private String clientName;
    private String type;
    private Timestamp added;
    private String ip;
    private String mac;
    private String model;
    private String address;
    private ClientDto cli;

    public ClientAddressDto(ClientDto client, AddressDto addr) {
        clientId = client.getClientId();
        clientName = client.getClientName();
        type = client.getType();
        added = Timestamp.from(client.getAdded());
        if (addr != null) {
            ip = addr.getIp();
            mac = addr.getMac();
            model = addr.getModel();
            address = addr.getAddress();
            cli = addr.getClient();
        }
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getType() {
        return type;
    }

    public Timestamp getAdded() {
        return added;
    }

    public String getIp() {
        return ip;
    }

    public String getMac() {
        return mac;
    }

    public String getModel() {
        return model;
    }

    public String getAddress() {
        return address;
    }

    public ClientDto getClient() {
        return cli;
    }
}
