package org.libra.voting.system.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.libra.voting.system.model.enums.SexEnum;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
}
