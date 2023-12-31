package com.example.springboot.config;

import com.example.springboot.entities.Category;
import com.example.springboot.entities.Order;
import com.example.springboot.entities.User;
import com.example.springboot.entities.enums.StatusOrder;
import com.example.springboot.repositories.CategoryRepository;
import com.example.springboot.repositories.OrderRepository;
import com.example.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Douglas", "Douglas@gmail.com", "Douglas10", "4004-8922");
        User u2 = new User(null, "David", "David@gmail.com", "David10", "4004-8922");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Eletrodomésticos");
        categoryRepository.saveAll(Arrays.asList(category1, category2));

        Order order1 = new Order(null, Instant.parse("2023-07-25T09:57:29Z"), StatusOrder.CANCELED, u1);
        Order order2 = new Order(null, Instant.parse("2023-07-25T13:30:20Z"), StatusOrder.WAITING_PAYMENT, u2);
        orderRepository.saveAll(Arrays.asList(order1, order2));

    }
}
