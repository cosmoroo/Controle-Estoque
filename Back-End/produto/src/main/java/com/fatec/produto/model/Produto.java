package com.fatec.produto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // manipula - Lazy loaded properties
@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String descricao;
    private String categoria;
    private int quantidadeU;
    private double valUnitario;
    private double valTotal;

    // Construtores
    // Construtor com todas as opções

    public Produto(String descricao, String categoria, int quantidade, double valUnitario, double valTotal) {
        setDescricao(descricao);
        setCategoria(categoria);
        setQuantidadeU(quantidade);
        setValUnitario(valUnitario);
        setValTotal(valTotal);
    }

    // Construtor sem valTotal

    public Produto(String descricao, String categoria, int quantidade, double valUnitario) {
        setDescricao(descricao);
        setCategoria(categoria);
        setQuantidadeU(quantidade);
        setValUnitario(valUnitario);
    }

    public Produto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("A descrição não deve estar em branco");
        else
            this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank())
            throw new IllegalArgumentException("A categoria não deve estar em branco");
        else
            this.categoria = categoria;
    }

    public int getQuantidadeU() {
        return quantidadeU;
    }

    public void setQuantidadeU(int quantidade) {
        try {
            if (quantidade <= 0)
                throw new IllegalArgumentException("A quantidade deve ser maior que zero");
            else
                this.quantidadeU = quantidade;
        } catch (Exception e) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
    }

    public double getValUnitario() {
        return valUnitario;
    }

    public void setValUnitario(double valUnitario) {
        try{
            if(valUnitario <= 0)
                throw new IllegalArgumentException("O Valor Unitario deve ser maior que zero");
            else
                this.valUnitario = valUnitario;
        }catch (Exception e){
            throw new IllegalArgumentException("O Valor Unitario deve ser maior que zero");
        }
    }

    public double getValTotal() {
        return this.valTotal;
    }

    public void setValTotal(double valTotal) {
        try{
            if(valTotal <= 0)
                throw new IllegalArgumentException("O Valor Total deve ser maior que zero");
            else
                this.valTotal = valTotal;
        }catch (Exception e){
            throw new IllegalArgumentException("O Valor Total deve ser maior que zero");
        }
    }
}
