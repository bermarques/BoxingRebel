package br.com.boxingrebel.ecom.order.domain.user.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {

  public UserPublicId {
    Assert.notNull("value", value);
  }
}
