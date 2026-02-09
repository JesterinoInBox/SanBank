package com.BankSan.CRUD_Bank.Controller;

import com.BankSan.CRUD_Bank.Model.Client;
import com.BankSan.CRUD_Bank.Service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String findAll(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client, Model model) {
        model.addAttribute("client", client);
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        try {
            clientService.saveClient(client);
            log.info("Сохранение клиента");
        } catch (Exception e) {
            log.info("Ошибка при создании");
            throw new RuntimeException(e);
        }

        return "redirect:/clients";
    }

    @GetMapping("/client-delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        try {
            clientService.deleteById(id);
            log.info("Клиент удалён");
        } catch (Exception e) {
            log.info("Ошибка при удалении");
            throw new RuntimeException(e);
        }
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{id}")
    public String updateClientForm(@PathVariable("id") Long id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client) {
        try {
            clientService.saveClient(client);
            log.info("Клиент обновлён");
        } catch (Exception e) {
            log.info("Ошибка при обновлении");
            throw new RuntimeException(e);
        }
        return "redirect:/clients";
    }
}
