package br.com.wsilva.granja.controller;

import br.com.wsilva.granja.model.EmpresaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmpresaControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmpresaController empresaController;

    @Test
    void save() throws MalformedURLException {
        // Create a new Empresa
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCodigoFilial("T1");
        entity.setNomeFantasia("Test1");
        entity.setRazaoSocial("Test1");

        ResponseEntity<EmpresaEntity> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/v1/empresas").toString(),
                entity, EmpresaEntity.class);

        // Verify
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals("Test1", response.getBody().getNomeFantasia());
    }
}