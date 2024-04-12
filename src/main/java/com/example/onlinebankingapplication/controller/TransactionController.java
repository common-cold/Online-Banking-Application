package com.example.onlinebankingapplication.controller;

import com.example.onlinebankingapplication.entity.Transaction;
import com.example.onlinebankingapplication.service.CustomerService;
import com.example.onlinebankingapplication.service.CustomerServiceImpl;
import com.example.onlinebankingapplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer/{iD}/account")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public String createTransactionForm(Model model){
        model.addAttribute("transaction", new Transaction());
        return "TransactionForm";
    }
    @PostMapping("/transaction")
    public @ResponseBody Transaction createTransaction(@PathVariable String iD, @ModelAttribute Transaction transaction){
        Long customerId = Long.valueOf(iD);
        return transactionService.createTransaction(customerId,transaction);
    }
}
