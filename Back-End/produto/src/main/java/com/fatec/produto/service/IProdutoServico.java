package com.fatec.produto.service;

import java.util.List;
import java.util.Optional;
import com.fatec.produto.model.Produto;

public interface IProdutoServico {
    public List<Produto> consultaCatalogo();

    public List<Produto> consultaPorDescricao();

    public Optional<Produto> cadastrar(Produto produto);

    public Optional<Produto> consultarPorId(String id);

    public Optional<Produto> atualizar(Long id, Produto produto);

    public void excluir(Long id);
}