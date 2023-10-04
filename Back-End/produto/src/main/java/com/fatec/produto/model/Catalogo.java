package com.fatec.produto.model;

public class Catalogo {
    private Long id;
    private String descricao;
    private String categoria;
    private int quantidadeU;
    private double valUnitario;
    private double valTotal;
    private byte[] imagem;

    public Catalogo(Long id, String descricao, String categoria, int quant, double valUnitario, double valTotal, byte[] imagem) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidadeU = quant;
        this.valUnitario = valUnitario;
        this.valTotal = valTotal;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeU() {
        return quantidadeU;
    }

    public double getValUnitario() {
        return valUnitario;
    }

    public double getValTotal() {
        return valTotal;
    }

    public byte[] getImagem() {
        return imagem;
    }
}
