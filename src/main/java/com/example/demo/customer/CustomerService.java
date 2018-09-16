package com.example.demo.customer;

import com.example.demo.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    MessageSender sender;

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        Customer result = customerRepository.save(customer);
        sender.sendEmail(customer);
        return result;
    }

}
