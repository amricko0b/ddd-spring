package xyz.amricko0b.ddd.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

/** Payment entity forms the root for aggregate Payment */
@Entity
@Getter
@DomainRing
@AggregateRoot
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

  public static Payment create(Account from, Account to, Money sum) {

    from.withdraw(sum);
    to.deposit(sum);

    return new Payment(from, to, sum);
  }

  /** Account entity for debit side */
  private final Account debit;

  /** Account entity for credit side */
  private final Account credit;

  /** Payment's sum */
  private final Money total;

  /** Simple internal identifier */
  private @Identity Long id;
}
