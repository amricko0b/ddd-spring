package xyz.amricko0b.ddd.app.command.spring;

import an.awesome.pipelinr.Voidy;
import org.jmolecules.architecture.onion.simplified.InfrastructureRing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.amricko0b.ddd.app.command.Pay;
import xyz.amricko0b.ddd.app.command.PayHandler;
import xyz.amricko0b.ddd.app.repository.PaymentRepository;

/** Bean for command handler - exports handler to Spring's context */
@Component
@InfrastructureRing
public class SpringPayHandler extends PayHandler {

  @Autowired
  public SpringPayHandler(PaymentRepository repository) {
    super(repository);
  }

  /** Also enables TX support */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Voidy handle(Pay command) {
    return super.handle(command);
  }
}
