package com.BankSan.CRUD_Bank.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "clients")
public class Client extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String first_name;
    private String last_name;
    private String country_of_residence;
    private String city_of_residence;
    private String street_of_residence;
    private short year_of_birth;
}
