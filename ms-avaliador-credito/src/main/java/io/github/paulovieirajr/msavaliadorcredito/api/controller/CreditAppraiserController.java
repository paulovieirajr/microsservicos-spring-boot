package io.github.paulovieirajr.msavaliadorcredito.api.controller;

import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentRequest;
import io.github.paulovieirajr.msavaliadorcredito.core.application.model.ClientDataAssessmentResponse;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserAssessmentUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.application.usecases.CreditAppraiserFindByCpfUseCase;
import io.github.paulovieirajr.msavaliadorcredito.core.domain.ClientStatus;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static io.github.paulovieirajr.msavaliadorcredito.api.constants.ApiDetailsConstants.API_VERSION;
import static io.github.paulovieirajr.msavaliadorcredito.api.constants.CreditAppraiserControllerConstants.ASSESSMENT;
import static io.github.paulovieirajr.msavaliadorcredito.api.constants.CreditAppraiserControllerConstants.CREDIT_APPRAISER;

@RestController
@RequestMapping(API_VERSION + CREDIT_APPRAISER)
@Validated
public class CreditAppraiserController {

    private final CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase;
    private final CreditAppraiserAssessmentUseCase creditAppraiserAssessmentUseCase;

    public CreditAppraiserController(CreditAppraiserFindByCpfUseCase creditAppraiserFindByCpfUseCase,
                                     CreditAppraiserAssessmentUseCase creditAppraiserAssessmentUseCase) {
        this.creditAppraiserFindByCpfUseCase = creditAppraiserFindByCpfUseCase;
        this.creditAppraiserAssessmentUseCase = creditAppraiserAssessmentUseCase;
    }

    @GetMapping
    public ResponseEntity<ClientStatus> findByCpf(@RequestParam
                                                  @CPF(message = "CPF informado é inválido") String cpf) {
        var response = creditAppraiserFindByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(response);
    }

    @PostMapping(ASSESSMENT)
    public ResponseEntity<ClientDataAssessmentResponse> assessment(@RequestBody
                                                                   @Valid ClientDataAssessmentRequest clientDataAssessmentRequest) {
        var response = creditAppraiserAssessmentUseCase.execute(clientDataAssessmentRequest);
        return ResponseEntity.ok(response);
    }
}
