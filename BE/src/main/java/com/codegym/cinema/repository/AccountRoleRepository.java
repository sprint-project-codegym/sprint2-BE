package com.codegym.cinema.repository;

import com.codegym.cinema.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRoleRepository extends JpaRepository<AccountRole,Integer> {
    @Modifying
    @Query(value = "insert into account_role(account_role.username,account_role.role_id) values (?1,?2)", nativeQuery = true)
    void saveAccountRole(String username, Integer roleId);
}
