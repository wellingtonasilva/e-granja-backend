package br.com.wsilva.granja.controller;

import br.com.wsilva.granja.model.EmpresaEntity;
import br.com.wsilva.granja.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<EmpresaEntity>> findAll() {
        return ResponseEntity.ok(this.empresaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaEntity> findById(@PathVariable("id") BigInteger id) {
        return ResponseEntity.ok(this.empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaEntity> save(@RequestBody EmpresaEntity entity) {
        return ResponseEntity.ok(empresaService.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") BigInteger id) {
        empresaService.deleteById(id);
    }
}
