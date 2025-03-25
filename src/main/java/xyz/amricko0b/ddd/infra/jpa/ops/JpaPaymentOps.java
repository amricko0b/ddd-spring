package xyz.amricko0b.ddd.infra.jpa.ops;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.amricko0b.ddd.infra.jpa.JpaPayment;

/**
 * Not a DDD-kind Repository, though you can make it to be some.
 *
 * <p>It's just a way to generate queries.
 */
public interface JpaPaymentOps extends JpaRepository<JpaPayment, Long> {}
