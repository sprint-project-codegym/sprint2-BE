package com.codegym.cinema.repository;

import com.codegym.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * LuanVT
     */
    @Query(value = "SELECT * FROM `user` WHERE username = ?1", nativeQuery = true)
    User findByUsername(String username);

    @Modifying
    @Query(value = "update `user`set `name` = ?2, birthday =?3, gender =?4, email =?5, " +
            "id_card =?6, phone =?7 where user_id = ?1", nativeQuery = true)
    void updateUser(int userId, String name, String birthday, Integer gender, String email, String idCard, String phone);

    User findUserByAccount_Username(String username);

    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "insert into user(name,avatar_url,email,username) value (?,?,?,?)", nativeQuery = true)
    void saveSocialUser(String name, String avatar_url, String email, String username);

}
