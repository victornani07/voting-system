package org.libra.voting.system.repository;

import org.libra.voting.system.model.entity.IdentityCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCardEntity, Long> {
}
