package br.com.aulaelasticsearch.conectar.repository;

import br.com.aulaelasticsearch.conectar.document.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Optional<Product> findById(String id);

    // Busca personalizada com Elasticsearch usando "match"
    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"operator\": \"and\"}}}")
    Page<Product> findByName(String name, Pageable pageable);

    @Query("{\"match\": {\"id\": \"?0\"}}")
    Page<Product> findByIdCustom(String id, Pageable pageable);

}
