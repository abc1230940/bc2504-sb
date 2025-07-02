package com.bootcamp.demo.demo_gov_data.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import java.time.LocalDate;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
  
  // 1. JPA Method (Encapsulation)
  Optional<WeatherEntity> findByDate(LocalDate date);

  // ! 2. JPQL: similar to SQL, select !! Entity class
  @Query(value = "select e from WeatherEntity e where e.date = :date")
  Optional<WeatherEntity> getWeatherJPQL(@Param(value = "date")LocalDate date);

  @Query(value = "select e from WeatherEntity e where e.maxTemp = :maxTemp")
  Optional<WeatherEntity> findByMaxTemp(@Param(value = "maxTemp")Long maxTemp);

  // ! 3. Query (SQL) -> What are the disadvantages?
  // - SQL syntax is per DataBase Product (Oracle)
  @Query(value = "select e.id, e.date, e.max-temp, e.min_temp, e.max_rh, e.min_rh from Weathers e where e.date = :date", nativeQuery = true)
  Optional<WeatherEntity> getWeatherSQL(@Param(value = "date")LocalDate date);
}
