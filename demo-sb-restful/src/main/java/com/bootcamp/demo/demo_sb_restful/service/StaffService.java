package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_sb_restful.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_restful.model.Staff;

public interface StaffService {
  
  StaffEntity save(Staff staff);
  List<StaffEntity> findAll();
  Optional<StaffEntity> findById(Long id);
  void deleteById(Long id);
  StaffEntity updateById(Staff staff, Long id);
  
}
