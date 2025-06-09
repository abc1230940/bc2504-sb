package com.bootcamp.demo.demo_sb_restful.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;

// After Spring boot 3: actually dont need to add @Repository
@Repository
public interface CatRepository extends JpaRepository<CatEntity, Long> {
  // select * from cats where name = ?
  // JPA Query Method -> 寫喺Reository裡面 -> 額外再加上去的methods，可以隨時自己再加上去
  List <CatEntity> findByName(String name); // 錯咗個名都唔俾用

  List<CatEntity> findByAgeGreaterThanEqual(Integer age);


  // Hibernate (JobsDB)
  // ! mvn compile -> Hibernate helps generate a class that implements this interfacec

  // Hibernate generated findAll(). You can call findAll() directly in service layer
  // select * from

  // Hibernate generated save(), You can call save() directly in service layer
  // insert into cats (1L, "John", 13)
  
}
