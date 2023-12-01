package io.github.paulovieirajr.msavaliadorcredito.core.application.model;

import io.github.paulovieirajr.msavaliadorcredito.core.domain.ApprovedCreditCardClient;

import java.util.Collection;

public record ClientDataAssessmentResponse(
        Collection<ApprovedCreditCardClient> approvedCreditCards
) {
}
