package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Client;
import soa.entities.FactureDetail;

public interface FactureDetailRepository extends JpaRepository<FactureDetail, Long> {
}
