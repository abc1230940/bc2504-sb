package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;

public interface ZooService {
  
  ZooEntity create(ZooEntity zooEntity);
  List<ZooEntity> findAll();
  Optional<ZooEntity> findById(Long id);
  void deleteById(Long id);
}
