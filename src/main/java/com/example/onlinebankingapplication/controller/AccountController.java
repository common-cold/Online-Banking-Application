package com.example.onlinebankingapplication.controller;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Address;
import com.example.onlinebankingapplication.entity.Contact;
import com.example.onlinebankingapplication.entity.Transaction;
import com.example.onlinebankingapplication.service.AccountService;
import com.example.onlinebankingapplication.service.AddressService;
import com.example.onlinebankingapplication.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer/{iD}")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/create-account")
    public String createAccountForm(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("contact", new Contact());
        model.addAttribute("address", new Address());
        return "AccountForm";
    }

    @PostMapping("/create-account")
    public @ResponseBody Account createAccount(@PathVariable String iD,
                                               @ModelAttribute Account account,
                                               @ModelAttribute Contact contact,
                                               @ModelAttribute Address address){
        Long customerId = Long.valueOf(iD);
        contactService.saveContact(customerId,contact);
        addressService.saveAddress(customerId,address);
        return accountService.createAccount(customerId, account);
    }

    @GetMapping("/account/balance")
    public @ResponseBody Long checkBalance(@PathVariable String iD){
        Long customerId = Long.valueOf(iD);
        return accountService.checkBalance(customerId);
    }

    @GetMapping("/account/transaction-history")
    public @ResponseBody List<Transaction> showTransactions(@PathVariable String iD){
        Long customerId = Long.valueOf(iD);
        return accountService.showTransactions(customerId);
    }
}
