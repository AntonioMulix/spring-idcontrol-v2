package com.id.control.repository;

import com.id.control.entity.ChallengePasskey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface ChallengePasskeyRepository extends JpaRepository<ChallengePasskey, Long> {

}
