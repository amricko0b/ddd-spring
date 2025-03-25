package xyz.amricko0b.ddd.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Account Entity models a part of payment (debit or credit).
 *
 * <p>Account is and ENTITY because it has certain identifier (IBAN)
 */
@Getter
@Entity
@DomainRing
@AllArgsConstructor
@ToString(of = "iban")
@EqualsAndHashCode(of = "iban")
public class Account {

  /** IBAN acts as an identifier */
  private @Identity Iban iban;

  /** Balance: how much money left? */
  private Money balance;

  /**
   * Domain API
   *
   * <p>Take money from account
   *
   * @param sum how much to take?
   */
  public void withdraw(Money sum) {

    if (!sum.currency().equals(balance.currency())) {
      throw new UnsupportedOperationException(
          String.format(
              "Unable to withdraw %s onto %s account", sum.currency(), balance.currency()));
    }

    var expectedBalance = this.balance.amount().subtract(sum.amount());
    if (expectedBalance.compareTo(BigDecimal.ZERO) < 0) {
      throw new UnsupportedOperationException(
          String.format("Not enough money on account %s", this));
    }

    this.balance = new Money(this.balance.amount().subtract(sum.amount()), this.balance.currency());
  }

  /**
   * Domain API
   *
   * <p>Put money to account
   *
   * @param sum how much to put?
   */
  public void deposit(Money sum) {

    if (!sum.currency().equals(balance.currency())) {
      throw new UnsupportedOperationException(
          String.format(
              "Unable to deposit %s onto %s account", sum.currency(), balance.currency()));
    }

    this.balance = new Money(this.balance.amount().add(sum.amount()), this.balance.currency());
  }

  /**
   * IBAN value object is used for strong typing.
   *
   * <p>It's a value object, cause the equality depends on ALL fields values
   *
   * @param value IBAN value
   */
  @ValueObject
  public record Iban(String value) {}
}
