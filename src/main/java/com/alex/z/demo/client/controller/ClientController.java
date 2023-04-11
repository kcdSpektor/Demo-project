package com.alex.z.demo.client.controller;

import com.alex.z.demo.client.dto.ClientResponse;
import com.alex.z.demo.client.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @Operation(
            tags = {"Clients"},
            summary = "Fetches all Clients"
    )
    @GetMapping
    public List<ClientResponse> getAll() {
        return clientService.findAll();
    }
}