package org.libra.voting.system.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.libra.voting.system.utils.TestConstants.IDENTITY_CARD_ENTITY;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class IdentityCardRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IdentityCardRepository identityCardRepository;

    @Test
    void whenSavingIdentityCardEntity_shouldReturnTheSavedObjectWithIdPopulated() {
        var result = entityManager.persistAndFlush(IDENTITY_CARD_ENTITY);
        var expected = identityCardRepository.findById(result.getId()).orElse(null);

        assertNotNull(expected);
        assertEquals(expected, result);
    }
}