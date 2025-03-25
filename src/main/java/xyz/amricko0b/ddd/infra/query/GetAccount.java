package xyz.amricko0b.ddd.infra.query;

import an.awesome.pipelinr.Command;
import xyz.amricko0b.ddd.infra.query.GetAccount.Result;
import xyz.amricko0b.ddd.infra.query.model.AccountQueryModel;

/**
 * A query.
 *
 * <p>Queries are designed to be as fast as they can and optimized for reading. That is why:
 *
 * <ul>
 *   <li>We do not put them at application layer
 *   <li>We do not use domain model in them
 * </ul>
 *
 * When handling a query, we just access our DB no more no less.
 */
public record GetAccount(String iban) implements Command<Result> {

  /** Query is demanded to have response model */
  public record Result(AccountQueryModel account) {}
}
