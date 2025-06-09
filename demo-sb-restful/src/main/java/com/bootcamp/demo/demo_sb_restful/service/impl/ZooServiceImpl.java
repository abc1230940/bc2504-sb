package com.bootcamp.demo.demo_sb_restful.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.repository.ZooRepository;
import com.bootcamp.demo.demo_sb_restful.service.ZooService;

@Service
public class ZooServiceImpl implements ZooService {
  @Autowired
  private ZooRepository zooRepository;

  @Override
  public ZooEntity create(ZooEntity zooEntity) {
    return this.zooRepository.save(zooEntity);
  }

  @Override
  public List<ZooEntity> findAll() {
    return this.zooRepository.findAll();
  }

  @Override
  public Optional<ZooEntity> findById(Long id) {
    return this.zooRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    this.zooRepository.deleteById(id);
  }
}
