package com.demo.bootcamp.bc_mtr_station.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, Long> {
  List<StationEntity> findByLineEntity(LineEntity lineEntity);
  List<StationEntity> findByLineEntityId(Long id);
}
