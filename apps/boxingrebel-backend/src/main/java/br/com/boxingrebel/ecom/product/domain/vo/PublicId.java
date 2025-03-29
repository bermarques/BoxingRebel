package br.com.boxingrebel.ecom.product.domain.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

import java.util.UUID;

public record PublicId(UUID value) {

  public PublicId {
    Assert.notNull("value", value);
  }
}
