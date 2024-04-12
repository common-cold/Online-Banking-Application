package com.example.onlinebankingapplication.controller;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.service.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/save-customer")
    public String saveCustomerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "CustomerForm";
    }

    @PostMapping("/save-customer")
    public @ResponseBody Customer saveCustomer(@ModelAttribute Customer customer){
        return customerService.saveCustomer(customer);
    }

}
