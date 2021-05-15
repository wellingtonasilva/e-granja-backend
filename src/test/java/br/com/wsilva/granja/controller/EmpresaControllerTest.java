package br.com.wsilva.granja.controller;

import br.com.wsilva.granja.model.EmpresaEntity;
import br.com.wsilva.granja.service.EmpresaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpresaController.class)
class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void save() throws Exception {
        // Create a new Empresa for return
        EmpresaEntity postReturn = new EmpresaEntity();
        postReturn.setCodigoFilial("T1");
        postReturn.setNomeFantasia("Test1");
        postReturn.setRazaoSocial("Test1");

        when(empresaService.save(any(EmpresaEntity.class))).thenReturn(postReturn);

        // Create a new Empresa for POST
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCodigoFilial("T1");
        entity.setNomeFantasia("Test1");
        entity.setRazaoSocial("Test1");

        // Simulate POST
        mockMvc
                .perform(post("/v1/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(entity)))
                .andExpect(status().isOk())
                .andReturn();
    }
}