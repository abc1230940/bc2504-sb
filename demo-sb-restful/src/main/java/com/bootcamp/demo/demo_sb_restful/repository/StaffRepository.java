package com.bootcamp.demo.demo_sb_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_restful.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository <StaffEntity, Long> {
  
}
