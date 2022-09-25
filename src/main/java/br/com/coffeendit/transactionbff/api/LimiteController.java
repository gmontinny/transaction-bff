package br.com.coffeendit.transactionbff.api;


import br.com.coffeendit.transactionbff.domain.LimiteService;
import br.com.coffeendit.transactionbff.dto.LimiteDiario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/limites")
public class LimiteController {

    public LimiteController(LimiteService limiteService) {
        this.limiteService = limiteService;
    }

    private final LimiteService limiteService;

    @GetMapping(value = "/{agencia}/{conta}")
    public Mono<LimiteDiario> buscarLimiteDiario(@PathVariable("agencia") final Long agencia, @PathVariable("conta") final Long conta) {

        return limiteService.buscarLimiteDiario(agencia, conta);

    }
}




