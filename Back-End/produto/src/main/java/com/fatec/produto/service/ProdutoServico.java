package com.fatec.produto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Catalogo;
import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IProdutoRepository repositoryP;
    @Autowired
    ImagemServico imagemServico;

    @Override
    public List<Catalogo> consultaCatalogo() {

        Catalogo c = null;
        List<Catalogo> lista = new ArrayList<Catalogo>();
        List<Produto> listaP = repositoryP.findAll();
        List<Imagem> listaI = imagemServico.getAll();
        for (Produto p : listaP) {
            for (Imagem i : listaI) {
                if (p.getId().equals(i.getId())) {
                    c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(), p.getQuantidadeU(),
                            p.getValUnitario(), p.getValTotal(), i.getArquivo());
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    @Override
    public List<Catalogo> consultaPorDescricao(String descricao) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Produto> cadastrar(Produto produto) {
        logger.info(">>> serviço cadastrar produto  >>>");
        return Optional.ofNullable(repositoryP.save(produto));
    }

    @Override
    public Optional<Produto> consultarPorId(String id) {
        logger.info(">>>>>> servico consulta por id chamado");
        long codProduto = Long.parseLong(id);
        return repository.findById(codProduto);

    }

    @Override
    public Optional<Produto> atualizar(Long id, Produto produto) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
    }
}