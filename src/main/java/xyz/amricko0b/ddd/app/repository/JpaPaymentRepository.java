package xyz.amricko0b.ddd.app.repository;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.InfrastructureRing;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.amricko0b.ddd.domain.Account;
import xyz.amricko0b.ddd.domain.Account.Iban;
import xyz.amricko0b.ddd.domain.Payment;
import xyz.amricko0b.ddd.infra.jpa.mapper.JpaAccountMapper;
import xyz.amricko0b.ddd.infra.jpa.mapper.JpaPaymentMapper;
import xyz.amricko0b.ddd.infra.jpa.ops.JpaAccountOps;
import xyz.amricko0b.ddd.infra.jpa.ops.JpaPaymentOps;

/**
 * Implementation of the repository.
 *
 * <p>Note that this is not a Spring Data Repository, but it utilizes Spring Data's functionality.
 */
@Component
@InfrastructureRing
@RequiredArgsConstructor
public class JpaPaymentRepository implements PaymentRepository {

  // We treat Spring Data's repos as "Ops" - just a way to generate queries
  private final JpaAccountOps accountOps;
  private final JpaPaymentOps paymentOps;

  // Mappers are where handy here to map between domain and JPA entities
  private final JpaAccountMapper accountMapper;
  private final JpaPaymentMapper paymentMapper;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public Account getAccount(Iban iban) {
    var jpa = accountOps.getReferenceById(iban.value());
    return accountMapper.mapToDomain(jpa);
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public void save(Payment payment) {

    var jpa = paymentMapper.mapToJpa(payment);
    paymentOps.save(jpa);
  }
}
