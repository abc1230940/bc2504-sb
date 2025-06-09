package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

public interface CatService {
  
  CatEntity save(Long zooId, Cat cat);
  Optional<CatEntity> findById(Long id);
  List<CatEntity> findAll();
  void deleteById(Long id);
  CatEntity updateById(Cat cat, Long id);
  List<CatEntity> findByName(String name);
  List<CatEntity> findByNameAndAge(String name, Integer age);
}
