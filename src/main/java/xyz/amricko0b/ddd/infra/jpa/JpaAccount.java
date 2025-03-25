package xyz.amricko0b.ddd.infra.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * This is NOT domain entity at all!
 *
 * <p>JPA entities are just a way of persistence. One can think about it as of DTO for database. It
 * brings NO business logic.
 */
@Getter
@Setter
@Entity(name = "Account")
@Table(name = "account")
public class JpaAccount {

  @Id
  @Column(nullable = false)
  private String iban;

  @Column(nullable = false)
  private BigDecimal balance;

  @Column(nullable = false)
  private String currency;
}
