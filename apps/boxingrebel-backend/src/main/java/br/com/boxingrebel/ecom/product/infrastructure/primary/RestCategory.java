package br.com.boxingrebel.ecom.product.infrastructure.primary;

import br.com.boxingrebel.ecom.product.domain.aggregate.Category;
import br.com.boxingrebel.ecom.product.domain.aggregate.CategoryBuilder;
import br.com.boxingrebel.ecom.product.domain.vo.CategoryName;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import br.com.boxingrebel.ecom.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.UUID;

@Builder
public record RestCategory(UUID publicId,
                           String name) {
  public RestCategory {
    Assert.notNull("name", name);
  }

  public static Category toDomain(RestCategory restCategory) {
    CategoryBuilder categoryBuilder = CategoryBuilder.category();

    if(restCategory.name != null) {
      categoryBuilder.name(new CategoryName(restCategory.name));
    }

    if(restCategory.publicId != null) {
      categoryBuilder.publicId(new PublicId(restCategory.publicId));
    }

    return categoryBuilder.build();
  }

  public static RestCategory fromDomain(Category category) {
    RestCategoryBuilder restCategoryBuilder = RestCategoryBuilder.restCategory();

    if(category.getName() != null) {
      restCategoryBuilder.name(category.getName().value());
    }

    return restCategoryBuilder
      .publicId(category.getPublicId().value())
      .build();
  }
}
