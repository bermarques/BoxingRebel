package br.com.boxingrebel.ecom.product.domain.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

public record ProductDescription(String value) {
  public ProductDescription {
    Assert.field("value", value).notNull().minLength(10);

  }
}
