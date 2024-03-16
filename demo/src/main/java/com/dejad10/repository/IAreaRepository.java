package com.dejad10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dejad10.domain.Area;

@Repository
public interface IAreaRepository extends JpaRepository <Area, Long>{

}
