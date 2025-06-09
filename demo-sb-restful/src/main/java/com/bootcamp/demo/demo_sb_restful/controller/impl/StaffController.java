package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.StaffOperator;
import com.bootcamp.demo.demo_sb_restful.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_restful.model.Staff;
import com.bootcamp.demo.demo_sb_restful.service.StaffService;

@RestController
public class StaffController implements StaffOperator {
  @Autowired
  private StaffService staffService;

  @Override
  public StaffEntity create(Staff staff) {
    return this.staffService.save(staff);
  }

  @Override
  public List<StaffEntity> getAll() {
    return staffService.findAll();
  }

  @Override
  public StaffEntity getById(Long id) {
    if (this.staffService.findById(id).isPresent()) {
      return this.staffService.findById(id).get();
    }
    return null;
  }

  @Override
  public StaffEntity update(Staff staff, Long id) {
    return this.staffService.updateById(staff, id);
  }

  @Override
  public void deleteById(Long id) {
    this.staffService.deleteById(id);
  }
}
  

