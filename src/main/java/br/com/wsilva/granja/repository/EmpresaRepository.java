package br.com.wsilva.granja.repository;

import br.com.wsilva.granja.model.EmpresaEntity;
import br.com.wsilva.granja.service.EmpresaService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<EmpresaEntity, BigInteger> {

    List<EmpresaEntity> findAll();
}
