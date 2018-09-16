package com.example.demo.message;

import com.example.demo.customer.Customer;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.TopicExchangeParser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSender {
    @Autowired
    private TopicExchange topic;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(Customer customer) {
        String key = "email.customer";
        rabbitTemplate.convertAndSend(topic.getName(), key, customer);
    }

}
