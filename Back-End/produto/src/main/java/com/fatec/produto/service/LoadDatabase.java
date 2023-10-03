package com.fatec.produto.service;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IProdutoRepository;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(IProdutoRepository repository) {
        return args -> {
            Produto produto1 = new Produto("KIT BANQUETA CONNECT PRETA ESTRUTURA 7024 PRETA K", "produto", 8, 247.46,
                    1979.98);
            Produto produto2 = new Produto("KIT CADEIRA 319 EXECUTIVA BASE RETA METAL C/CAPA", "produto", 230, 303.26, 1979.68);
            Produto produto3 = new Produto("KIT CADEIRA 3019 C/CAPA PT C/ MEC 4125 BASE RETA M", "produto", 80, 356.72, 28537.60);

            repository.saveAll(Arrays.asList(produto1, produto2, produto3));
            logger.info(">>>>> loaddatabase -> cadastro de 3 produtos realizado.");
        };
    }
}