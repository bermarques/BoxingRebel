package br.com.boxingrebel.ecom.product.domain.service;

import br.com.boxingrebel.ecom.product.domain.aggregate.Product;
import br.com.boxingrebel.ecom.product.domain.repository.ProductRepository;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductCRUD {

  private final ProductRepository productRepository;

  public ProductCRUD(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product save(Product newProduct) {
    newProduct.initDefaultFields();
    return productRepository.save(newProduct);
  }

  public Page<Product> findAll(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  public PublicId delete(PublicId id) {
    int nbOfRowsDeleted = productRepository.delete(id);
    if (nbOfRowsDeleted != 1) {
      throw new EntityNotFoundException(String.format("No Category deleted with id %s", id));
    }
    return id;

  }
}
