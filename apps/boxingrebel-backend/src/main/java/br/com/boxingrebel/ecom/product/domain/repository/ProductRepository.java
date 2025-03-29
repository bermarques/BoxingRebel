package br.com.boxingrebel.ecom.product.domain.repository;

import br.com.boxingrebel.ecom.product.domain.aggregate.Product;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {

  Product save(Product productToCreate);

  Page<Product> findAll(Pageable pageable);

  int delete(PublicId publicId);
}
