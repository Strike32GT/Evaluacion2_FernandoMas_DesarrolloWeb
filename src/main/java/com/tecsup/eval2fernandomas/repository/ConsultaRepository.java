package com.tecsup.eval2fernandomas.repository;

import com.tecsup.eval2fernandomas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}
