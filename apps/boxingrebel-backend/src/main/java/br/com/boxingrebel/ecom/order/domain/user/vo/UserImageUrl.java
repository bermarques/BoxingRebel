package br.com.boxingrebel.ecom.order.domain.user.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

public record UserImageUrl(String value) {

  public UserImageUrl {
    Assert.field("value", value).maxLength(1000);
  }
}
