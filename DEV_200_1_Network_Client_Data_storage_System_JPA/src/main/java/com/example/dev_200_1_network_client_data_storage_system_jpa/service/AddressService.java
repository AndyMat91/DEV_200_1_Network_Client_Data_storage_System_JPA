package com.example.dev_200_1_network_client_data_storage_system_jpa.service;

import com.example.dev_200_1_network_client_data_storage_system_jpa.dto.AddressDto;
import com.example.dev_200_1_network_client_data_storage_system_jpa.dto.ClientDto;
import com.example.dev_200_1_network_client_data_storage_system_jpa.entity.AddressEntity;
import com.example.dev_200_1_network_client_data_storage_system_jpa.repository.AddressRepository;
import com.example.dev_200_1_network_client_data_storage_system_jpa.repository.ClientRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

@Stateless
public class AddressService {
    @EJB
    private AddressRepository addressRepository;

    public AddressDto findByAddressMac(String mac) {
        return AddressDto.getAddressDtoByEntity(addressRepository.findByAddressMac(mac));
    }

}
