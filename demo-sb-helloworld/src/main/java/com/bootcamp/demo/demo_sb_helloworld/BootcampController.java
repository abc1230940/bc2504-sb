package com.bootcamp.demo.demo_sb_helloworld;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootcampController {
  @GetMapping(value = "/bootcamp/hello")
  public Customer getCustomer() {
    return Customer.builder().id(1L).orders(List.of(Order.builder().id(10L).build()))
        .build();
  }

  @GetMapping(value = "/bootcamp/goodbye")
  public Person getPerson() {
    return Person.builder().age(17).name("John").build();
  }
}
