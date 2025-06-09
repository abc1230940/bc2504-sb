package com.bootcamp.demo.demo_sb_helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class HelloworldController {

  // ! Spring Boot default is 8080
  // http://127.0.0.1:8080/helloworld
  // Browser (Client) -> Spring boot app (Server)
  // Step 1: Compile java Project (Spring boot)
  // Step 2: Generate Jar 
  // Step 3: Start Server

  // API
  @GetMapping(value = "/helloworld") // connect browser and server method
  public String helloworld() {
    return "Hello World, welcome to Spring Boot."; // 根據人數，potentially可以有一億個objectss
  }

  // create a new spring boot project
  // "http://localhost:8080/person"
  // create a API to return a person (Person.class) -> John, 18
  @GetMapping(value = "/person") // 不能同名 -> connect to browser
  public Person getPerson() {
    return new Person(1, "John", 18);
  }

  // persons
  @GetMapping(value = "/persons")
  public List<Person> getPersons() {
    return new ArrayList<>(Arrays.asList(new Person(1,"John", 20), new Person(2, "Mary", 18)));
  }

  // Customer and order
  @GetMapping(value = "/customers") 
  public List<Customer> getCustomers() {
    Customer c1 = Customer.builder()
                  .name("John")
                  .orders(new ArrayList<>(Arrays.asList(new Order(1, 500), new Order(2, 600))))
                  .build();
    Customer c2 = Customer.builder()
                  .name("Mary")
                  .orders(new ArrayList<>(Arrays.asList(new Order(3, 400), new Order(4, 700))))
                  .build();

    List<Customer> customers = new ArrayList<>(Arrays.asList(c1, c2));
    System.out.println(customers); // ! ~0.001 sec (1ms)! for debug only, 正常應該一行寫
    return customers;
  }

  @GetMapping(value = "/orders")
  public List<Order> getOrders() {
    return new ArrayList<>(Arrays.asList(new Order(1, 200), new Order(2, 300), new Order(3,400)));
  }

  }

