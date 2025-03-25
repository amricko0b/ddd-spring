package xyz.amricko0b.ddd.app.command;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import xyz.amricko0b.ddd.app.repository.PaymentRepository;
import xyz.amricko0b.ddd.domain.Account.Iban;
import xyz.amricko0b.ddd.domain.Money;
import xyz.amricko0b.ddd.domain.Payment;

/**
 * Each command has separate handler.
 *
 * <p>Handler made abstract because it must be extended by bean at infrastructure layer.
 */
@Slf4j
@ApplicationRing
@RequiredArgsConstructor
public abstract class PayHandler implements Command.Handler<Pay, Voidy> {

  private final PaymentRepository repository;

  @Override
  public Voidy handle(Pay command) {

    var debit = repository.getAccount(new Iban(command.debitIban()));
    var credit = repository.getAccount(new Iban(command.creditIban()));
    var sum = new Money(command.sum(), command.currency());

    var payment = Payment.create(debit, credit, sum);
    repository.save(payment);

    log.info("%s has been created");

    return new Voidy();
  }
}
