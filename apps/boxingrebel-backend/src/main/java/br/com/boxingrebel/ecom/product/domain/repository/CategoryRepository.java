package br.com.boxingrebel.ecom.product.domain.repository;

import br.com.boxingrebel.ecom.product.domain.aggregate.Category;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository {

  Page<Category> findAll(Pageable pageable);

  int delete(PublicId publicId);

  Category save(Category categoryToCreate);
}
