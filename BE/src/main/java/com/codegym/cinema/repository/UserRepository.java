package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    //NgaLT query thêm mới user
    @Modifying
    @Query(value = "INSERT INTO User (avatar_url,birthday, email, gender, id_card, `name`, phone,username, ward_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    void createUser(String avatarUrl, String birthday, String email,Integer gender, String idCard,String name, String phone,
                    String userName,Integer wardId);

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findUserByUsername(@Param("username") String username);

    @Query(value = "select * from user where id_card = :idCard", nativeQuery = true)
    User findUserByIdCard(@Param("idCard") String idCard);

    @Query(value = "select * from user where email = :email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);


}
