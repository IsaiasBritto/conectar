package br.com.aulaelasticsearch.conectar.controller;

import br.com.aulaelasticsearch.conectar.document.Product;
import br.com.aulaelasticsearch.conectar.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Product product) {
        productService.createProduct(product);
        log.info("Produto criado: {}", product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Product product, @PathVariable String id) {
        productService.updateProduct(product, id);
        log.info("Produto atualizado (ID: {}): {}", id, product);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findByName(@PathVariable String name) {
        log.info("Buscando produtos com nome: {}", name);
        return productService.findByName(name);
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Product> findById(@PathVariable String id) {
        log.info("Buscando produto por ID: {}", id);
        return productService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAll() {
        log.info("Buscando todos os produtos");
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        log.info("Produto deletado (ID: {})", id);
    }

    @GetMapping("/")
    public String homePage() {
        log.info("Acessou a página inicial da API");
        return "Seja bem-vindo à API em Java com Spring Boot";
    }

    @GetMapping("/logs")
    public String logPage() {
        log.info("Teste de geração de log para integração com Filebeat/Logstash");
        return "Log registrado com sucesso!";
    }

    @GetMapping("/waring")
    public String warngPage() {

        LocalDateTime localDateTime = LocalDateTime.now();

        log.warn("Log:" + localDateTime);
        return "Bem vindo a página de Warning!";
    }

    @GetMapping("/er")
    public String errorPage() {

        LocalDateTime localDateTime = LocalDateTime.now();

        log.error("This error page:" + localDateTime);
        return "Bem vindo a página de Error!";
    }
}
