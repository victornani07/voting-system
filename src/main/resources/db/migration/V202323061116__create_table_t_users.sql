CREATE SEQUENCE seq_users
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

CREATE TABLE t_user
(
    id BIGINT DEFAULT nextval('seq_users') PRIMARY KEY,
    uuid VARCHAR(36) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    identity_card_id BIGINT NOT NULL,

    CONSTRAINT fk_identity_card_id FOREIGN KEY (identity_card_id) REFERENCES t_identity_card (id)
);

ALTER SEQUENCE seq_users OWNED BY t_user.id;

COMMENT ON TABLE t_user IS 'The table stores the users involved in voting process.';

COMMENT ON COLUMN t_user.id IS 'The user id.';
COMMENT ON COLUMN t_user.uuid IS 'The UUID of user.';
COMMENT ON COLUMN t_user.first_name IS 'The first name of the user.';
COMMENT ON COLUMN t_user.last_name IS 'The last name of the user.';
COMMENT ON COLUMN t_user.identity_card_id IS 'The id of the identity card the user is holding.';