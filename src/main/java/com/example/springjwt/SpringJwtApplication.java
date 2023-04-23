package com.example.springjwt;

import com.example.springjwt.entity.User;
import com.example.springjwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringJwtApplication {


    private final UserRepository userRepository;

    @PostConstruct
    public  void createUsers() {
        List<User> users = Stream.of(
                new User(1, "baxish" , "password", "baxish@gmail.com"),
                new User(2, "user1" , "password1", "user1@gmail.com"),
                new User(3, "user2" , "password2", "user2@gmail.com"),
                new User(4, "user3" , "password3", "user3@gmail.com")).toList();

        userRepository.saveAll(users);


    }



    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
    }

}
