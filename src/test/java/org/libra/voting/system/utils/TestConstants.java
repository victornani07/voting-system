package org.libra.voting.system.utils;

import org.libra.voting.system.model.data.SaveIdentityCardData;
import org.libra.voting.system.model.entity.IdentityCardEntity;
import org.libra.voting.system.model.enums.SexEnum;
import org.libra.voting.system.model.request.SaveIdentityCardRequest;
import org.libra.voting.system.model.response.SaveIdentityCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class TestConstants {
    public static final IdentityCardEntity IDENTITY_CARD_ENTITY = IdentityCardEntity.builder()
        .personalNumericCode("2004042063007")
        .firstName("Victor")
        .lastName("Nani")
        .birthDate(LocalDate.of(1999, 10, 7))
        .series("B42061581")
        .dateOfIssue(LocalDate.of(2017, 4, 12))
        .expirationDate(LocalDate.of(2024, 10, 7))
        .issuingAuthority("IS\"CRIS\"REGISTRU")
        .sex(SexEnum.M)
        .bloodGroup("AB(IV)RH+")
        .residence("CHISINAU, BACIOI, STR. SFANTUL STEFAN NR.2")
        .residenceEstablishmentDate(LocalDate.of(2017, 4, 8))
        .build();

    public static final SaveIdentityCardRequest SAVE_IDENTITY_CARD_REQUEST = SaveIdentityCardRequest.builder()
        .personalNumericCode("2004042063007")
        .firstName("Victor")
        .lastName("Nani")
        .birthDate(LocalDate.of(1999, 10, 7))
        .series("B42061581")
        .dateOfIssue(LocalDate.of(2017, 4, 12))
        .expirationDate(LocalDate.of(2024, 10, 7))
        .issuingAuthority("IS\"CRIS\"REGISTRU")
        .sex(SexEnum.M)
        .bloodGroup("AB(IV)RH+")
        .residence("CHISINAU, BACIOI, STR. SFANTUL STEFAN NR.2")
        .residenceEstablishmentDate(LocalDate.of(2017, 4, 8))
        .build();

    public static final SaveIdentityCardResponse SAVE_IDENTITY_CARD_RESPONSE = SaveIdentityCardResponse.builder()
        .saveIdentityCardData(SaveIdentityCardData.builder()
            .id(1L)
            .firstName("Victor")
            .lastName("Nani")
            .build()
        ).build();

    public static final ResponseEntity<SaveIdentityCardResponse> SAVE_IDENTITY_CARD_RESPONSE_RESPONSE_ENTITY =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(SAVE_IDENTITY_CARD_RESPONSE);

    public static final String IDENTITY_CARD_CONTROLLER_REQUEST_MAPPING_PATH = "/api/v1/identity-card";

    public static final Long ID_1 = 1L;
}
