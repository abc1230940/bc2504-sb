package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.ZooOperation;
import com.bootcamp.demo.demo_sb_restful.dto.ZooReqDTO;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.service.ZooService;

@RestController
public class ZooController implements ZooOperation {
  @Autowired
  private ZooService zooService;

  @Override
  public ZooEntity create(@RequestBody ZooReqDTO dto) {
    // !!! convert dto to entity -> 這是controller的工作 -> 著重一個客人，因應唔同客人要求而變，手機，電腦，電視...都是唔同的client
    // !! service用來寫business logic -> 自己果邊，主張固定
    // !! Entity都係
    // !! Model用來做運算
    ZooEntity zooEntity = ZooEntity.builder().name(dto.getName()).build();
    return this.zooService.create(zooEntity);
  }

  @Override
  public List<ZooReqDTO> getAll() {
    List<ZooEntity> zooEntities = this.zooService.findAll();
    List<ZooReqDTO> dto = zooEntities.stream().map(e -> new ZooReqDTO(e.getName())).collect(Collectors.toList());
    return dto;
  }

  @Override
  public ZooReqDTO getById(Long id) {
    Optional<ZooEntity> zooEntity = this.zooService.findById(id);
    if (!zooEntity.isPresent()) {
      return null;
      
    }
    ZooEntity zooEntity2 = zooEntity.get();
    ZooReqDTO dto = ZooReqDTO.builder().name(zooEntity2.getName()).build();
    return dto;
  }

  @Override
  public void delete(Long id) {
    this.zooService.deleteById(id);
  }


}
