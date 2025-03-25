package xyz.amricko0b.ddd.infra;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Here we collect all command handlers altogether. */
@Configuration
public class PipelineConfig {

  @Bean
  @SuppressWarnings("rawtypes")
  public Pipeline pipeline(ObjectProvider<Command.Handler> handlers) {
    return new Pipelinr().with(() -> handlers.stream());
  }
}
