package com.dejad10.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICongregacaoRepository extends JpaRepository<Congregacao, Long>{

}
