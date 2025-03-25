package xyz.amricko0b.ddd.entrypoint;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.amricko0b.ddd.app.command.Pay;

/** Export Payment as a RESTFull collection */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/payment")
public class PaymentController {

  private final Pipeline pipeline;

  @PostMapping
  public void post(@RequestBody Pay pay) {
    pipeline.send(pay);
  }
}
