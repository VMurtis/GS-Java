package br.com.fiap.gs.model.entities;

import br.com.fiap.gs.dto.Desabrigado.DesabrigadoDto;
import jakarta.persistence.*;


@Entity
public class Desabrigado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    private int idade;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_abrigo")
    private Abrigo abrigo;

    public Desabrigado() {
    }

    public Desabrigado(Long id, String nome, String email, String senha, int idade, String telefone, Abrigo abrigo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.telefone = telefone;
        this.abrigo = abrigo;
    }

    public Desabrigado(DesabrigadoDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.email =dto.email();
        this.senha = dto.senha();
        this.idade = dto.idade();
        this.telefone = dto.telefone();
        this.abrigo = dto.abrigo();


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }



}
