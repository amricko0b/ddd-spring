package xyz.amricko0b.ddd.infra.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "Payment")
@Table(name = "payment")
public class JpaPayment {

  @Id private Long id;

  @ManyToOne
  @JoinColumn(name = "debit_account_iban", nullable = false)
  private JpaAccount debit;

  @ManyToOne
  @JoinColumn(name = "credit_account_iban", nullable = false)
  private JpaAccount credit;

  @Column(nullable = false)
  private BigDecimal total;

  @Column(nullable = false)
  private String currency;
}
