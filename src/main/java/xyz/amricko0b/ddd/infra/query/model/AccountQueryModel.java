package xyz.amricko0b.ddd.infra.query.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/** DTO for query result presentation */
@Getter
@Setter
public class AccountQueryModel {
  private String iban;
  private BigDecimal balance;
  private String currency;
}
