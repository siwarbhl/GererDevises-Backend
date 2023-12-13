package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Client;
import soa.entities.Devise;

import java.util.List;

public interface DeviseRepository extends JpaRepository<Devise, Long>  {
    Devise findByCode(String code);

    List<Devise> findAll();


}
