package org.libra.voting.system.model.request;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import org.libra.voting.system.model.enums.SexEnum;

import java.time.LocalDate;


@Value
@Builder
@ToString
public class SaveIdentityCardRequest {

    String personalNumericCode;

    String firstName;

    String lastName;

    LocalDate birthDate;

    String series;

    LocalDate dateOfIssue;

    LocalDate expirationDate;

    String issuingAuthority;

    SexEnum sex;

    String bloodGroup;

    String residence;

    LocalDate residenceEstablishmentDate;
}
