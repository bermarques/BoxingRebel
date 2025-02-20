package br.com.boxingrebel.ecom.order.domain.user.repository;

import br.com.boxingrebel.ecom.order.domain.user.aggregate.User;
import br.com.boxingrebel.ecom.order.domain.user.vo.UserAddress;
import br.com.boxingrebel.ecom.order.domain.user.vo.UserEmail;
import br.com.boxingrebel.ecom.order.domain.user.vo.UserPublicId;

import java.util.Optional;

public interface UserRepository {
  void save(User user);

  Optional<User> get(UserPublicId userPublicId);

  Optional<User> getOnyByEmail(UserEmail userEmail);

  void updateAddress(UserPublicId userPublicId, UserAddress userAddress);
}
