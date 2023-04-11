package com.alex.z.demo.client.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

}
