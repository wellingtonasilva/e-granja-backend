package br.com.wsilva.granja.service;

import br.com.wsilva.granja.model.EmpresaEntity;
import br.com.wsilva.granja.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    @Test
    void save() {
        // Create a new Empresa
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCodigoFilial("T1");
        entity.setNomeFantasia("Test1");
        entity.setRazaoSocial("Test1");

        when(empresaRepository.save(any(EmpresaEntity.class))).thenReturn(entity);

        // Test adding new Empresa
        var empresa =  empresaService.save(new EmpresaEntity());

        // Verify
        assertNotNull(empresa.getCodigoFilial());
        assertEquals("Test1", empresa.getNomeFantasia());
    }
}