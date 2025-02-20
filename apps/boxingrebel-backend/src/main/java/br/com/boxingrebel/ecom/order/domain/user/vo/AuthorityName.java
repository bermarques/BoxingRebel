package br.com.boxingrebel.ecom.order.domain.user.vo;

import br.com.boxingrebel.ecom.shared.error.domain.Assert;

public record AuthorityName(String name) {

  public AuthorityName {
    Assert.field("name", name).notNull();
  }
}
