package xyz.amricko0b.ddd.infra.jpa.ops;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.amricko0b.ddd.infra.jpa.JpaAccount;

/**
 * Not a DDD-kind Repository, though you can make it to be some.
 *
 * <p>It's just a way to generate queries.
 */
public interface JpaAccountOps extends JpaRepository<JpaAccount, String> {}
