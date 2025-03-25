package xyz.amricko0b.ddd.infra.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import xyz.amricko0b.ddd.domain.Account;
import xyz.amricko0b.ddd.domain.Account.Iban;
import xyz.amricko0b.ddd.domain.Money;
import xyz.amricko0b.ddd.infra.jpa.JpaAccount;

/**
 * Mappers ARE very handy in layered architectures when you need lots of cross-boundary DTOs
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface JpaAccountMapper {

  @Mapping(target = "iban", source = "iban.value")
  @Mapping(target = "currency", source = "balance.currency")
  @Mapping(target = "balance", source = "balance.amount")
  JpaAccount mapToJpa(Account account);

  @Mapping(target = "balance", source = "account", qualifiedByName = "mapToBalance")
  Account mapToDomain(JpaAccount account);

  @Named("mapToBalance")
  default Money mapToBalance(JpaAccount jpa) {
    return new Money(jpa.getBalance(), jpa.getCurrency());
  }

  default Iban mapToIban(String value) {
    return new Iban(value);
  }
}
