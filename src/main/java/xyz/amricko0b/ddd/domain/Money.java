package xyz.amricko0b.ddd.domain;

import java.math.BigDecimal;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Value object representing a certain amount of money
 *
 * <p>It's a value object because:
 *
 * <ul>
 *   <li>Money(15, USD) != Money(15, EUR)
 *   <li>Money(15, USD) != Money(20, USD)
 * </ul>
 *
 * So one needs all field values to tell whether one object differs from another.
 *
 * @param amount how much money?
 * @param currency currency of ammount
 */
@DomainRing
@ValueObject
public record Money(BigDecimal amount, String currency) {}
