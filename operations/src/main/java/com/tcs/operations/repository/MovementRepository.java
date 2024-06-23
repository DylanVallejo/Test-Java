package com.tcs.operations.repository;

import com.tcs.operations.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    @Query(value = "select m.* from Movement m where m.account_id = :accountId", nativeQuery = true)
    List<Movement> findAllByAccountId(@Param("accountId") List<Long> accountId );

}
