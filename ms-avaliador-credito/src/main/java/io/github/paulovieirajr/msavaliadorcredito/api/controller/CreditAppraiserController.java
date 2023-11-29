package io.github.paulovieirajr.msavaliadorcredito.api.controller;

import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserFindByCpfUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientStatus;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.github.paulovieirajr.msavaliadorcredito.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.msavaliadorcredito.api.constants.CreditAppraiserControllerConstants.CREDIT_APPRAISER;

@RestController
@RequestMapping(API_VERSION + CREDIT_APPRAISER)
@Validated
public class CreditAppraiserController {

    private final CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase;

    public CreditAppraiserController(CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase) {
        this.creditAppraiserFindByCpfUseCase = creditAppraiserFindByCpfUseCase;
    }

    @GetMapping
    public ResponseEntity<ClientStatus> findByCpf(@RequestParam
                                                  @CPF(message = "CPF informado é inválido") String cpf) {
        var response = creditAppraiserFindByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(response);
    }
}
