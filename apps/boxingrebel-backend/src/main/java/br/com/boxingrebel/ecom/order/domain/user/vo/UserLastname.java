package br.com.boxingrebel.ecom.order.domain.user.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

public record UserLastname(String value) {

  public UserLastname {
    Assert.field("value", value).maxLength(255);
  }
}
