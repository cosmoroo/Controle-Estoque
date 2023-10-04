package com.fatec.produto.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.IImagemRepository;
import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IProdutoRepository;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IImagemRepository imagemRepository;

    @Bean
    CommandLineRunner initDatabase(IProdutoRepository repository) {
        return args -> {
            Produto produto1 = new Produto("KIT BANQUETA CONNECT PRETA ESTRUTURA 7024 PRETA K", "produto", 8, 247.46,
                    1979.98);
            Produto produto2 = new Produto("KIT CADEIRA 319 EXECUTIVA BASE RETA METAL C/CAPA", "produto", 230, 303.26,
                    1979.68);
            Produto produto3 = new Produto("KIT CADEIRA 3019 C/CAPA PT C/ MEC 4125 BASE RETA M", "produto", 80, 356.72,
                    28537.60);

            repository.saveAll(Arrays.asList(produto1, produto2, produto3));
            logger.info(">>>>> loaddatabase -> cadastro de 3 produtos realizado.");

            // ****************************************************************
            // upload - obtem a imagem do c, atribui ao obj imagem e salva no db do servidor
            // ****************************************************************

            Path path = Paths.get("F:\\Facul\\Web3_Saraiva\\IMG\\produto1.jpg");
            InputStream file = Files.newInputStream(path);
            byte[] arquivo1 = file.readAllBytes();
            Imagem imagem = new Imagem();
            imagem.setId(1L); // associa o id do produto ao id da imagem
            imagem.setNome("produto1.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo1);
            logger.info(">>> loaddatabase -> upload de arquivo imagem realizado =>" + arquivo1.length);
            imagemRepository.save(imagem);
            // ****************************************************************
            path = Paths.get("F:\\Facul\\Web3_Saraiva\\IMG\\produto2.jpg");
            file = Files.newInputStream(path);
            byte[] arquivo2 = file.readAllBytes();
            imagem = new Imagem();
            imagem.setId(2L); // associa o id do produto ao id da imagem
            imagem.setNome("produto2.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo2);
            logger.info(">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo2.length);
            imagemRepository.save(imagem);
            // ****************************************************************
            path = Paths.get("F:\\Facul\\Web3_Saraiva\\IMG\\produto3.jpg");
            file = Files.newInputStream(path);
            byte[] arquivo3 = file.readAllBytes();
            imagem = new Imagem();
            imagem.setId(3L); // associa o id do produto ao id da imagem
            imagem.setNome("produto3.jpg");
            imagem.setCaminho("imagens/" + imagem.getNome());
            imagem.setArquivo(arquivo3);
            logger.info(">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo3.length);
            imagemRepository.save(imagem);

        };
    }
}