package br.com.boxingrebel.ecom.order.domain.user.aggregate;

import br.com.boxingrebel.ecom.order.domain.user.vo.AuthorityName;
import br.com.boxingrebel.ecom.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {

  private AuthorityName name;

  public Authority(AuthorityName authorityName) {
    Assert.notNull("name", authorityName);
    this.name = authorityName;
  }

  public AuthorityName getName() {
    return name;
  }
}
