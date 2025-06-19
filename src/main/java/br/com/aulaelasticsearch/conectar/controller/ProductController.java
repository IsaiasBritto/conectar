package br.com.aulaelasticsearch.conectar.controller;

import br.com.aulaelasticsearch.conectar.document.Product;
import br.com.aulaelasticsearch.conectar.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Product _product) {
        productService.createProduct(_product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/id/{id}")
    public void update(@RequestBody Product _product, @PathVariable String id) {
        productService.updateProduct(_product, id);
    }
    /*
     * @ResponseStatus(HttpStatus.OK)
     * 
     * @GetMapping("/name/{name}")
     * public void findByName(@PathVariable String name) {
     * productService.findByName(name);
     * }
     */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{name}")
    public Page<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findById/{id}")
    public void findById(@PathVariable String id) {
        productService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAll")
    public Iterable<Product> getAll() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);

    }
}
