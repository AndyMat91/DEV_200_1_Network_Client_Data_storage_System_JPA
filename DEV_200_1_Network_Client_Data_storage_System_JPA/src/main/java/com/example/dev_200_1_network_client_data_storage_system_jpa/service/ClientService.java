package com.example.dev_200_1_network_client_data_storage_system_jpa.service;

import com.example.dev_200_1_network_client_data_storage_system_jpa.dto.ClientDto;
import com.example.dev_200_1_network_client_data_storage_system_jpa.repository.ClientRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

@Stateless
public class ClientService {
    @EJB
    private ClientRepository clientRepository;

    @Transactional
    public ClientDto findByClientId(int id){
        return ClientDto.getClientDtoByEntity(clientRepository.findByClientId(id));
    }
}
