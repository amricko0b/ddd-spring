package xyz.amricko0b.ddd.app.repository;

import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.jmolecules.ddd.annotation.Repository;
import xyz.amricko0b.ddd.domain.Account;
import xyz.amricko0b.ddd.domain.Payment;

/**
 * An app repository.
 *
 * <p>A repository is defined on "per-aggregate" basis. There is no sense in defining separate repo
 * for each entity and value object.
 */
@Repository
@ApplicationRing
public interface PaymentRepository {

  /** A repository takes care about all entities in aggregate. */
  Account getAccount(Account.Iban iban);

  /** Also provides a way to persist the whole aggregate */
  void save(Payment payment);
}
