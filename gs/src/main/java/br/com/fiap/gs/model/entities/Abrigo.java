package br.com.fiap.gs.model.entities;

import br.com.fiap.gs.dto.abrigo.AbrigoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "TAB_ABRIGO")
@SequenceGenerator(name = "abrigo", sequenceName = "SQ_TAB_ABRIGO", allocationSize = 1)
public class Abrigo {

    @Id @Column(name = "id_abrigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abrigo")
    private Long id;

    private String nome;

    private String endereco;

    private Integer capacidadeMaxima;

    private String cidade;
    private String estado;
    private String cep;


    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Desabrigado> desabrigados;
    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL)
    private List<Necessidade> necessidades;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Administrador> administradores;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estoque> estoque;


    public Abrigo() {
    }

    public Abrigo(Long id, String nome, String endereco, Integer capacidadeMaxima, String cidade, String estado, String cep, List<Desabrigado> desabrigados, List<Necessidade> necessidades, List<Administrador> administradores, List<Estoque> estoque) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.desabrigados = desabrigados;
        this.necessidades = necessidades;
        this.administradores = administradores;
        this.estoque = estoque;
    }

    public Abrigo(AbrigoDto dto) {
        this.nome = dto.nome();
        this.endereco = dto.endereco();
        this.capacidadeMaxima = dto.capacidadeMaxima();
        this.cidade = dto.cidade();
        this.estado = dto.estado();
        this.cep = dto.cep();
        this.estoque = dto.estoque();
        this.necessidades = dto.necessidades();
        this.desabrigados = dto.desabrigados();
        this.administradores = dto.adm();

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }


    public List<Necessidade> getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(List<Necessidade> necessidades) {
        this.necessidades = necessidades;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Desabrigado> getDesabrigados() {
        return desabrigados;
    }

    public void setDesabrigados(List<Desabrigado> desabrigados) {
        this.desabrigados = desabrigados;
    }

    public List<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        this.estoque = estoque;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
