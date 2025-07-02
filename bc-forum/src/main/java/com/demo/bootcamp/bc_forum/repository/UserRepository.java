package com.demo.bootcamp.bc_forum.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.bootcamp.bc_forum.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // JPA Method
  List<UserEntity> findByZipcode(String zipcode);
  // select * from users where zipcode = ?

  Optional<UserEntity> findByCity(String city);

}
