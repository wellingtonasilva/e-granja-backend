package br.com.wsilva.granja.service;

import br.com.wsilva.granja.model.EmpresaEntity;
import br.com.wsilva.granja.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaEntity> findAll() {
        return this.empresaRepository.findAll();
    }

    public EmpresaEntity save(EmpresaEntity entity) {
        return this.empresaRepository.save(entity);
    }

    public EmpresaEntity findById(BigInteger id) {
        return this.empresaRepository.findById(id).orElseGet(EmpresaEntity::new);
    }

    public void deleteById(BigInteger id) {
        this.empresaRepository.deleteById(id);
    }
}
