package com.bootcamp.demo.demo_sb_restful.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_restful.model.Staff;
import com.bootcamp.demo.demo_sb_restful.repository.StaffRepository;
import com.bootcamp.demo.demo_sb_restful.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
  @Autowired
  private StaffRepository staffRepository;

  @Override
  public StaffEntity save(Staff staff) {
    StaffEntity staffEntity = StaffEntity.builder()
                              .name(staff.getName())
                              .age(staff.getAge())
                              .build();
    return this.staffRepository.save(staffEntity);
  }

  @Override
  public List<StaffEntity> findAll() {
    return this.staffRepository.findAll();
  }

  @Override
  public Optional<StaffEntity> findById(Long id) {
    return this.staffRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    this.staffRepository.deleteById(id);
  }

  @Override
  public StaffEntity updateById(Staff staff, Long id) {
    if (this.staffRepository.findById(id).isPresent()) {
      StaffEntity staffEntity = StaffEntity.builder()
                                .id(staff.getId())
                                .name(staff.getName())
                                .age(staff.getAge()).build();
      return this.staffRepository.save(staffEntity);
    }
    return null;
  }

}
