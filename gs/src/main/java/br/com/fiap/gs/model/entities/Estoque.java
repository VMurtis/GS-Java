package br.com.fiap.gs.model.entities;

import br.com.fiap.gs.dto.estoque.EstoqueDto;
import br.com.fiap.gs.model.enums.TipoItem;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "TAB_ESTOQUE")
@SequenceGenerator(name = "estoque", sequenceName = "SQ_TAB_ESTOQUE", allocationSize = 1)
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoItem estoqueAtual;

    @Column(nullable = false)
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    public Estoque() {}



    public Estoque(TipoItem estoqueAtual, Integer quantidade, Abrigo abrigo) {
        this.estoqueAtual = estoqueAtual;
        this.quantidade = quantidade;
        this.abrigo = abrigo;
    }


    public Estoque(EstoqueDto dto, Abrigo abrigo) {
        this.estoqueAtual = dto.estoqueAtual();
        this.quantidade = dto.quantidade();
        this.abrigo = abrigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoItem getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(TipoItem estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }




}
