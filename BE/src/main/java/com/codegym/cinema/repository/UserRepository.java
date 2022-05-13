package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Account;
import com.codegym.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Integer> {
    /*
    * HauLC
    **/
    User findUserByAccount_Username(String username);
    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="insert into user(name,avatar_url,email,username) value (?,?,?,?)", nativeQuery=true)
    void saveSocialUser(String name, String avatar_url, String email, String username);

    //NgaLT query thêm mới user
    @Modifying
    @Query(value = "INSERT INTO User (avatar_url,birthday, email, gender, id_card, `name`, phone,username, ward_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    void createUser(String avatarUrl, String birthday, String email,Integer gender, String idCard,String name, String phone,
                    String userName,Integer wardId);

    @Query(value = "select * from user where id_card = :idCard", nativeQuery = true)
    User findUserByIdCard(@Param("idCard") String idCard);

}
