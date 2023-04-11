package com.alex.z.demo.account.model;

import com.alex.z.demo.client.model.Client;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "account_number_uk", columnNames = "accountNumber")})
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    @NonNull
    private String accountNumber;

    @Column(nullable = false)
    @NonNull
    private BigDecimal balance;

    @Column(nullable = false)
    @NonNull
    private String currency;

    @Column(nullable = false)
    @NonNull
    private LocalDateTime lastOperation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @NonNull
    private Client client;
}
