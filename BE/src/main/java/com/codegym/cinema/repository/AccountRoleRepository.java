package com.codegym.cinema.repository;

import com.codegym.cinema.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRoleRepository extends JpaRepository<AccountRole,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into account_role(username,role_id) value (?,'3')", nativeQuery=true)
    void setDefaultRole(String username);
}
