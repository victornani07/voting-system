CREATE SEQUENCE seq_identity_card
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

CREATE TABLE t_identity_card
(
    id BIGINT DEFAULT nextval('seq_identity_card') PRIMARY KEY,
    pnc VARCHAR(13) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    series VARCHAR(9) NOT NULL,
    date_of_issue DATE NOT NULL,
    expiration_date DATE NOT NULL,
    issuing_authority VARCHAR(30) NOT NULL,
    sex VARCHAR(1) NOT NULL,
    blood_group VARCHAR(10) NULL,
    residence VARCHAR(100) NOT NULL,
    residence_establishment_date DATE NOT NULL,

    CONSTRAINT unique_users_pnc UNIQUE (pnc)
);

ALTER SEQUENCE seq_identity_card OWNED BY t_identity_card.id;

COMMENT ON TABLE t_identity_card IS 'The table stores identity card data for users involved in voting process.';

COMMENT ON COLUMN t_identity_card.id IS 'Identity card ID.';
COMMENT ON COLUMN t_identity_card.pnc IS 'The personal numeric code of user.';
COMMENT ON COLUMN t_identity_card.first_name IS 'The first name of the user holding the identity card.';
COMMENT ON COLUMN t_identity_card.last_name IS 'The last name of the user holding the identity card.';
COMMENT ON COLUMN t_identity_card.birth_date IS 'The birth date of the user holding the identity card.';
COMMENT ON COLUMN t_identity_card.series IS 'The series of the identity card.';
COMMENT ON COLUMN t_identity_card.date_of_issue IS 'The date when the identity card was emitted.';
COMMENT ON COLUMN t_identity_card.expiration_date IS 'The expiration date of the identity card.';
COMMENT ON COLUMN t_identity_card.issuing_authority IS 'The issuing authority that emitted the identity card.';
COMMENT ON COLUMN t_identity_card.sex IS 'The gender of the identity card holder.';
COMMENT ON COLUMN t_identity_card.blood_group IS 'The blood group of the identity card holder.';
COMMENT ON COLUMN t_identity_card.residence IS 'The residence of the identity card holder.';
COMMENT ON COLUMN t_identity_card.residence_establishment_date IS 'The date when the residence was established.';