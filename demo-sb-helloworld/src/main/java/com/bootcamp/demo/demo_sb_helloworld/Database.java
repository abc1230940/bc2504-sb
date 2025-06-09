package com.bootcamp.demo.demo_sb_helloworld;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public static List<Integer> integers = new ArrayList<>(); // 好像database
  public static List<Person> persons = new ArrayList<>();
  
  public static boolean add(Integer integer) {
    return integers.add(integer);
    
  }

  public static Integer getInteger(int index) {
    return integers.get(index);
  }

  public static boolean add(Long id, String name, Integer age) {
    return persons.add(new Person(id, name, age));

  }

  // API return出去不能要Optional
  // .findAny() -> 只是搵中間其中一個
  // 如果想搵晒所有 -> 用.collect
  public static Person getPerson(String name) {
    return persons.stream()
            .filter(person -> person.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("Person not found: " + name));
  }
}
