package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

public interface CatOperation {
  @PostMapping(value = "/zoo/{id}/cat")
  CatEntity create(@PathVariable (value = "id") Long zooId, @RequestBody Cat cat);

  @GetMapping(value = "/zoo/{id}/cats")
  List<CatEntity> getAll(@PathVariable (value = "id") Long zooId);

  @PutMapping(value = "/cat/{id}")
  CatEntity update(@RequestBody Cat cat, @PathVariable Long id);

  @GetMapping(value = "/cat/{id}")
  CatEntity getById(@PathVariable Long id);

  @DeleteMapping(value = "/cat/{id}")
  void deleteById(@PathVariable Long id);

  @GetMapping(value = "/cat/name/{name}") // "/cat/{name}" -> 撞名
  List<CatEntity> findByName(@PathVariable String name);
}
