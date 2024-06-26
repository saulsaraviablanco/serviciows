package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.model.CuentaModel;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaModel,Integer> {
}
