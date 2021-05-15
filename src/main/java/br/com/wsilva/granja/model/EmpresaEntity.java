package br.com.wsilva.granja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "EMPRESAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaEntity {

    @Id
    @Column(name = "EMP_CODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "EMP_CODIGOFILIAL")
    private String codigoFilial;

    @Column(name = "EMP_NOMEFANTASIA")
    private String nomeFantasia;

    @Column(name = "EMP_RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "EMP_TELEFONE")
    private String telefone;

    @Column(name = "EMP_CGC")
    private String cnpj;

    @Column(name = "EMP_ENDERECO")
    private String endereco;

    @Column(name = "EMP_COMPLENDERECO")
    private String complemento;

    @Column(name = "EMP_BAIRRO")
    private String bairro;

    @Column(name = "EMP_CIDADE")
    private String cidade;

    @Column(name = "EMP_ESTADO")
    private String estado;

    @Column(name = "EMP_CEP")
    private String cep;

    @Column(name = "EMP_VLR_UNITARIOOVO")
    private Float valorUnitarioOvo;
}
