package org.libra.voting.system.utils;

import jakarta.persistence.Access;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.libra.voting.system.model.data.SaveIdentityCardData;
import org.libra.voting.system.model.entity.IdentityCardEntity;
import org.libra.voting.system.model.request.SaveIdentityCardRequest;
import org.libra.voting.system.model.response.SaveIdentityCardResponse;

import java.lang.reflect.Method;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdentityCardTransformers {

    public static IdentityCardEntity convertSaveIdentityCardRequestToIdentityCardEntity(
        SaveIdentityCardRequest request
    ) {
        return IdentityCardEntity.builder()
            .personalNumericCode(request.getPersonalNumericCode())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .birthDate(request.getBirthDate())
            .series(request.getSeries())
            .dateOfIssue(request.getDateOfIssue())
            .expirationDate(request.getExpirationDate())
            .issuingAuthority(request.getIssuingAuthority())
            .sex(request.getSex())
            .bloodGroup(request.getBloodGroup())
            .residence(request.getResidence())
            .residenceEstablishmentDate(request.getResidenceEstablishmentDate())
            .build();
    }

    public static SaveIdentityCardResponse convertIdentityCardEntityToSaveIdentityCardResponse(
        IdentityCardEntity identityCardEntity
    ) {
        return SaveIdentityCardResponse.builder()
            .saveIdentityCardData(SaveIdentityCardData.builder()
                .id(identityCardEntity.getId())
                .firstName(identityCardEntity.getFirstName())
                .lastName(identityCardEntity.getLastName())
                .build()
            ).errorData(null)
            .build();
    }
}
