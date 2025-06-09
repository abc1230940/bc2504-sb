package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_restful.model.Staff;

public interface StaffOperator {
  
  @PostMapping(value = "/staff")
  public StaffEntity create(@RequestBody Staff staff);

  @GetMapping(value = "/staffs")
  public List<StaffEntity> getAll();

  @GetMapping(value = "/staff/{id}")
  public StaffEntity getById(@PathVariable Long id);

  @DeleteMapping(value = "staff/{id}")
  public void deleteById(@PathVariable Long id);

  @PutMapping(value = "/staff/{id}")
  public StaffEntity update(@RequestBody Staff staff, Long id);


}
