package com.alex.z.demo.account.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AccountRequest {

    private UUID clientId;
    private String accountNumber;
    private BigDecimal balance;
    private String currency;
    private LocalDateTime lastOperation;

}
