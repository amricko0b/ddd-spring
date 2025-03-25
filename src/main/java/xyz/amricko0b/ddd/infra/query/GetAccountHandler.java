package xyz.amricko0b.ddd.infra.query;

import an.awesome.pipelinr.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xyz.amricko0b.ddd.infra.jpa.ops.JpaAccountOps;
import xyz.amricko0b.ddd.infra.query.model.AccountQueryModel;

/** A query handler. One can call it Presenter. */
@Component
@RequiredArgsConstructor
public class GetAccountHandler implements Command.Handler<GetAccount, GetAccount.Result> {

  private final JpaAccountOps accountOps;

  @Override
  @Transactional(readOnly = true)
  public GetAccount.Result handle(GetAccount query) {
    var jpa = accountOps.getReferenceById(query.iban());

    var model = new AccountQueryModel();
    model.setIban(jpa.getIban());
    model.setBalance(jpa.getBalance());
    model.setCurrency(jpa.getCurrency());

    return new GetAccount.Result(model);
  }
}
