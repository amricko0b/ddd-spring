package xyz.amricko0b.ddd.entrypoint;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.amricko0b.ddd.infra.query.GetAccount;
import xyz.amricko0b.ddd.infra.query.GetAccount.Result;

/**
 * Export Account as a RESTFull collection
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/account")
public class AccountController {

  private final Pipeline pipeline;

  @GetMapping(path = "/{iban}")
  public Result get(@PathVariable("iban") String iban) {
    return pipeline.send(new GetAccount(iban));
  }
}
