package br.com.wsilva.granja.service;

import br.com.wsilva.granja.model.EmpresaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class EmpresaServiceIntegrationTest {

    @Autowired
    private EmpresaService empresaService;

    public void findAll() {
    }

    @Test
    public void save() {
        // Create a new Empresa
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCodigoFilial("T1");
        entity.setNomeFantasia("Test1");
        entity.setRazaoSocial("Test1");

        // Test adding new Empresa
        var empresa =  empresaService.save(entity);

        // Verify
        assertNotNull(empresa.getCodigoFilial());
        assertNotNull(empresa.getId());
        assertEquals("Test1", empresa.getNomeFantasia());
    }

    public void findById() {
    }

    public void deleteById() {
    }
}