package com.example.demo.message;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("customer.topic");
    }

    @Bean
    public MessageSender sender() {
        return new MessageSender();
    }

}
