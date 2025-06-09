package com.bootcamp.demo.demo_sb_helloworld;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody

public class DatabaseController {
  
  // ! RESTful API
  // Create a new resource
  // In this case, resource -> integers

  // http://localhost:8080/integer/1
  @PostMapping(value = "/integer/{x}")
  public boolean addInteger(@PathVariable Integer x) {
    return Database.add(x);
  }

  // 撞path -> 2個動作不同，相同path都唔算撞

  // http://localhost:8080/integer/2
  @GetMapping(value = "/integer/{idx}")
  public Integer getInteger(@PathVariable Integer idx) {
    return Database.getInteger(idx);
  }

  @GetMapping(value = "/integers")
  public List<Integer> getIntegers() {
    return Database.integers;
  }

  @PostMapping(value = "/person1")
  public boolean addPerson(@RequestParam (value = "id") Long id, @RequestParam (value = "name") String name , @RequestParam (value = "age") Integer age) {
    return Database.add(id, name, age);
  }

  @GetMapping(value = "/person1")
  public Person getPerson(@RequestParam (value = "name") String name) {
    return Database.getPerson(name);
  }
  
  @GetMapping(value = "/persons1")
  public List<Person> getPersons() {
    return Database.persons;
  }

  // ! Update the resource (replace the whole resource by a new resource)
  // 要接收id
  // update其中一個資料，都會將成個object replace去舊object
  @PutMapping(value = "/person1/id/{id}") // 一般用pathVariable -> 搵到資源個位置
  public Person updatePerson(@RequestBody Person newPerson) {
    for (int i = 0; i < Database.persons.size(); i++) {
      if (Database.persons.get(i).getId() == newPerson.getId()) {
        Database.persons.set(i, newPerson);
        return newPerson;
      }
    }
    return null;
  }
  
}
