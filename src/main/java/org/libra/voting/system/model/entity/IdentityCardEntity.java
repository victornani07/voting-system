package org.libra.voting.system.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.libra.voting.system.model.enums.SexEnum;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Table(
    name = "t_identity_card",
    uniqueConstraints = { @UniqueConstraint(columnNames = {"pnc"}) }
)
public class IdentityCardEntity {

    @Id
    @Column
    @SequenceGenerator(name = "identity_card_id_generator", sequenceName = "seq_identity_card", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "identity_card_id_generator")
    @ToString.Include
    private Long id;

    @Column(name = "pnc")
    @ToString.Include
    private String personalNumericCode;

    @Column(name = "first_name")
    @ToString.Include
    private String firstName;

    @Column(name = "last_name")
    @ToString.Include
    private String lastName;

    @Column(name = "birth_date")
    @ToString.Include
    private LocalDate birthDate;

    @Column(name = "series")
    @ToString.Include
    private String series;

    @Column(name = "date_of_issue")
    @ToString.Include
    private LocalDate dateOfIssue;

    @Column(name = "expiration_date")
    @ToString.Include
    private LocalDate expirationDate;

    @Column(name = "issuing_authority")
    @ToString.Include
    private String issuingAuthority;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private SexEnum sex;

    @Column(name = "blood_group")
    @ToString.Include
    private String bloodGroup;

    @Column(name = "residence")
    @ToString.Include
    private String residence;

    @Column(name = "residence_establishment_date")
    @ToString.Include
    private LocalDate residenceEstablishmentDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityCardEntity that = (IdentityCardEntity) o;
        return Objects.equals(id, that.id)
            && Objects.equals(personalNumericCode, that.personalNumericCode)
            && Objects.equals(firstName, that.firstName)
            && Objects.equals(lastName, that.lastName)
            && Objects.equals(birthDate, that.birthDate)
            && Objects.equals(series, that.series)
            && Objects.equals(dateOfIssue, that.dateOfIssue)
            && Objects.equals(expirationDate, that.expirationDate)
            && Objects.equals(issuingAuthority, that.issuingAuthority)
            && sex == that.sex && Objects.equals(bloodGroup, that.bloodGroup)
            && Objects.equals(residence, that.residence)
            && Objects.equals(residenceEstablishmentDate, that.residenceEstablishmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            personalNumericCode,
            firstName,
            lastName,
            birthDate,
            series,
            dateOfIssue,
            expirationDate,
            issuingAuthority,
            sex,
            bloodGroup,
            residence,
            residenceEstablishmentDate
        );
    }
}
