package br.com.boxingrebel.ecom.product.infrastructure.secondary.repository;

import br.com.boxingrebel.ecom.product.domain.aggregate.Category;
import br.com.boxingrebel.ecom.product.domain.repository.CategoryRepository;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import br.com.boxingrebel.ecom.product.infrastructure.secondary.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDataCategoryRepository implements CategoryRepository {

  private final JpaCategoryRepository jpaCategoryRepository;

  public SpringDataCategoryRepository(JpaCategoryRepository jpaCategoryRepository) {
    this.jpaCategoryRepository = jpaCategoryRepository;
  }

  @Override
  public Page<Category> findAll(Pageable pageable) {
    return jpaCategoryRepository.findAll(pageable).map(CategoryEntity::to);
  }

  @Override
  public int delete(PublicId publicId) {
    return jpaCategoryRepository.deleteByPublicId(publicId.value());
  }

  @Override
  public Category save(Category categoryToCreate) {
    CategoryEntity categoryToSave = CategoryEntity.from(categoryToCreate);
    CategoryEntity categorySaved = jpaCategoryRepository.save(categoryToSave);

    return CategoryEntity.to(categorySaved);
  }
}
