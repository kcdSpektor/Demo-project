package com.alex.z.demo.client.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientResponse {

    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
