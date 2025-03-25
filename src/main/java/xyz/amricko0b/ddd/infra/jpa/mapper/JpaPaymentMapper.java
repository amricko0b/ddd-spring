package xyz.amricko0b.ddd.infra.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import xyz.amricko0b.ddd.domain.Money;
import xyz.amricko0b.ddd.domain.Payment;
import xyz.amricko0b.ddd.infra.jpa.JpaPayment;

/** Mappers ARE very handy in layered architectures when you need lots of cross-boundary DTOs */
@Mapper(componentModel = ComponentModel.SPRING, uses = JpaAccountMapper.class)
public interface JpaPaymentMapper {

  @Mapping(target = "total", source = "total.amount")
  @Mapping(target = "currency", source = "total.currency")
  JpaPayment mapToJpa(Payment payment);

  @Mapping(target = "total", source = "payment", qualifiedByName = "mapToTotal")
  Payment mapToDomain(JpaPayment payment);

  @Named("mapToTotal")
  default Money mapToTotal(JpaPayment jpa) {
    return new Money(jpa.getTotal(), jpa.getCurrency());
  }
}
