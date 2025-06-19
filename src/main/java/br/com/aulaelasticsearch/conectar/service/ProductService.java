package br.com.aulaelasticsearch.conectar.service;

import br.com.aulaelasticsearch.conectar.document.Product;

import org.springframework.data.domain.Page;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(Product product, String id);

    Product findProduct(String id);

    Page<Product> findById(String param);

    void deleteProduct(String id);

    Page<Product> findByName(String param);

    Iterable<Product> findAll();

}