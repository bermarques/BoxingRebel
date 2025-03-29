package br.com.boxingrebel.ecom.product.domain.aggregate;

import br.com.boxingrebel.ecom.product.domain.vo.CategoryName;
import br.com.boxingrebel.ecom.product.domain.vo.PublicId;
import br.com.boxingrebel.ecom.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.UUID;

@Builder
public class Category {
  private final CategoryName name;

  private Long dbId;
  private PublicId publicId;

  public Category(CategoryName name, Long dbId, PublicId publicId) {
    this.name = name;
    this.dbId = dbId;
    this.publicId = publicId;
  }

  private void assertMandatoryFields(CategoryName categoryName) {
    Assert.notNull("name", categoryName);
  }

  public void initDefaultFields() {
    this.publicId = new PublicId(UUID.randomUUID());
  }

  public CategoryName getName() {
    return name;
  }

  public Long getDbId() {
    return dbId;
  }

  public PublicId getPublicId() {
    return publicId;
  }
}
