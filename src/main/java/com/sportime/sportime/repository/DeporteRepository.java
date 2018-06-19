package com.sportime.sportime.repository;

import com.sportime.sportime.model.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeporteRepository  extends JpaRepository<Deporte, Long>{


}
