package com.test.accounts.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Account {
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="account_number")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name="branch_address")
    private String branchAddress;
    @Column(name="create_dt")
    private LocalDate createDt;

}
