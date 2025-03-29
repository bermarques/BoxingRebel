package br.com.boxingrebel.ecom.product.application;

import br.com.boxingrebel.ecom.product.domain.aggregate.Category;
import br.com.boxingrebel.ecom.product.domain.aggregate.Product;
import br.com.boxingrebel.ecom.product.domain.repository.CategoryRepository;
import br.com.boxingrebel.ecom.product.domain.repository.ProductRepository;
import br.com.boxingrebel.ecom.product.domain.service.CategoryCRUD;
import br.com.boxingrebel.ecom.product.domain.service.ProductCRUD;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsApplicationService {

  private ProductCRUD productCRUD;
  private CategoryCRUD categoryCRUD;

  public ProductsApplicationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productCRUD = new ProductCRUD(productRepository);
    this.categoryCRUD = new CategoryCRUD(categoryRepository);
  }

  @Transactional
  public Product createProduct(Product newProduct) {
    return productCRUD.save(newProduct);
  }

  @Transactional
  public Page<Product> findAllProducts(Pageable pageable) {
    return productCRUD.findAll(pageable);
  }

  @Transactional
  public PublicId deleteProduct(PublicId publicId) {
    return productCRUD.delete(publicId);
  }

  @Transactional
  public Category createCategory(Category category) {
    return categoryCRUD.save(category);
  }

  @Transactional
  public PublicId deleteCategory(PublicId publicId) {
    return categoryCRUD.delete(publicId);
  }

  @Transactional(readOnly = true)
  public Page<Category> findAllCategories(Pageable pageable) {
    return categoryCRUD.findAll(pageable);
  }
}
