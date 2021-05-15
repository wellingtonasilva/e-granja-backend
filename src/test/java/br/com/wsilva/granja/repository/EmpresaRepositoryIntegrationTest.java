package br.com.wsilva.granja.repository;

import br.com.wsilva.granja.model.EmpresaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmpresaRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Test
    void findAll() {
        // Create a new Empresa for return
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCodigoFilial("T1");
        entity.setNomeFantasia(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        entity.setRazaoSocial("Test1");
        testEntityManager.persist(entity);

        List<EmpresaEntity> list = empresaRepository.findAll();
        assertNotNull(list);
        assertTrue(list.stream().filter(item -> item.getNomeFantasia().equals(entity.getNomeFantasia())).count() > 0);
    }
}