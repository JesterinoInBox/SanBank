package com.BankSan.CRUD_Bank.Repository;

import com.BankSan.CRUD_Bank.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

//Переопределяем интерфейс для запросов
public interface ClientRepository extends JpaRepository<Client, Long> {
}
