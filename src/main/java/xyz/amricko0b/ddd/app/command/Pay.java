package xyz.amricko0b.ddd.app.command;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import java.math.BigDecimal;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;

/** An app command */
@ApplicationRing
public record Pay(String debitIban, String creditIban, BigDecimal sum, String currency)
    implements Command<Voidy> {}
