package com.bootcamp.demo.demo_sb_restful.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.repository.CatRepository;
import com.bootcamp.demo.demo_sb_restful.repository.ZooRepository;
import com.bootcamp.demo.demo_sb_restful.service.CatService;

// ! RESTFUL API 我提供所有方法，你自己鍾意用就用，唔用就唔用，我不會再提供後著

@Service
public class CatServiceImpl implements CatService {
  @Autowired
  // ! Hibernate alrady generate a bean for interface CatRepository before server start
  private CatRepository catRepository;
  @Autowired
  private ZooRepository zooRepository;
  
  @Override
  public CatEntity save(Long zooId, Cat cat) {
    // return Cat.cats.add(cat) ? cat : null; -> not database
    // real DB

    // 0. check if zoo found

    if (!this.zooRepository.existsById(zooId)) {
      return null;
    }
    // 1. convert Cat object to CatEntity object
    Optional<ZooEntity> zooEntity = this.zooRepository.findById(zooId);
    if (!zooEntity.isPresent()) {
      return null;
    }
    // 2. insert cat into table (FK)
    CatEntity catEntity = CatEntity.builder()//
        .name(cat.getName()) //
        .age(cat.getAge()) //
        .zooEntity(zooEntity.get()) // set FK
        .build();
    return this.catRepository.save(catEntity);

  }

  @Override
  public Optional<CatEntity> findById(Long id) {
    return this.catRepository.findById(id);
  }

  @Override
  public List<CatEntity> findAll() {
    List<CatEntity> catEntities = this.catRepository.findAll();
    return catEntities;
  }

  @Override
  public void deleteById (Long id) {
    this.catRepository.deleteById(id);
      
  }

  // PUT
  @Override
  public CatEntity updateById(Cat cat, Long id) {
    if (!this.catRepository.existsById(id) || id != cat.getId()) {
      return null;
    }
      // save -> create or replace
      // ! But in PUT api, we check if the resource exists, do nothing if not exists
      CatEntity catEntity = CatEntity.builder()
                          .id(cat.getId()) // ! 在put method都要放返原本個id比人
                          .name(cat.getName())
                          .age(cat.getAge())
                          .build();
      return this.catRepository.save(catEntity);
  }

      @Override
      public List<CatEntity> findByName(String name) {
        return this.catRepository.findByName(name);

      }
      // 可以自己搵返個List係咩class -> instanceof / .getClass() -> 在terminal可以睇到

      // ! findAll() -> stream() -> filter() in Java
      // ! Not a must findBYXXX in JPA -> verrrry time-consuming
      @Override
      public List<CatEntity> findByNameAndAge(String name, Integer age) { // Wrapper class -> 寫返equals會好過 "=="
        return this.catRepository.findAll().stream()
                                            .filter(e -> e.getName().equals(name) && e.getAge().equals(age))
                                            .collect(Collectors.toList());
      }
  
  
}
