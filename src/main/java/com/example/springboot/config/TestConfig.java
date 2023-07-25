package com.example.springboot.config;

import com.example.springboot.entities.Order;
import com.example.springboot.entities.User;
import com.example.springboot.repositories.OrderRepository;
import com.example.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Douglas", "Douglas@gmail.com", "Douglas10", "4004-8922");
        User u2 = new User(null, "David", "David@gmail.com", "David10", "4004-8922");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order order1 = new Order(null, Instant.parse("2023-07-25T09:57:29Z"), u1);
        Order order2 = new Order(null, Instant.parse("2023-07-25T13:30:20Z"), u2);
        orderRepository.saveAll(Arrays.asList(order1, order2));

    }
}
