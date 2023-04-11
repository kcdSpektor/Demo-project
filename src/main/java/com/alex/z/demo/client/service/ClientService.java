package com.alex.z.demo.client.service;

import com.alex.z.demo.client.dto.ClientRequest;
import com.alex.z.demo.client.dto.ClientResponse;
import com.alex.z.demo.client.model.Client;
import com.alex.z.demo.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientResponse> findAll(){
        return clientRepository.findAll().stream().map(this::toDto).toList();
    }

    private ClientResponse toDto(Client client){
        return ClientResponse.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build();
    }

    private Client fromDto(ClientRequest request){
        return new Client(request.getFirstName(), request.getLastName());
    }

}
