package io.github.paulovieirajr.msavaliadorcredito.core.application.model;

import io.github.paulovieirajr.msavaliadorcredito.core.domain.ApprovedCreditCardClient;

import java.util.Collection;
import java.util.Set;

public record ClientDataAssessmentResponse(
        Set<ApprovedCreditCardClient> approvedCreditCards
) {
}
