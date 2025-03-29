package br.com.boxingrebel.ecom.product.domain.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

public record ProductBrand(String value) {

  public ProductBrand {
    Assert.field("value", value).notNull().minLength(3);
  }
}
