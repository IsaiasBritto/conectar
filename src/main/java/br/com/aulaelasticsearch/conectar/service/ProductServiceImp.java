package br.com.aulaelasticsearch.conectar.service;

import br.com.aulaelasticsearch.conectar.document.Product;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.aulaelasticsearch.conectar.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product, String id) {
        Product newProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setDescription(product.getDescription());
        productRepository.save(newProduct);
    }

    @Override
    public Page<Product> findById(String id) {
        return productRepository.findByIdCustom(id, PageRequest.of(0, 10));
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String id) {

        productRepository.findById(id).orElseThrow(RuntimeException::new);
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findByName(String name) {
        return productRepository.findByName(name, PageRequest.of(0, 10));
    }

    @Override
    public Product findProduct(String id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}