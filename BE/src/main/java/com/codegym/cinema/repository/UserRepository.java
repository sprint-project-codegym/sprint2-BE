package com.codegym.cinema.repository;

import com.codegym.cinema.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "SELECT user.user_id, user.avatar_url,user.birthday, user.email, user.gender, user.id_card, user.name, user.phone, user.username, user.ward_id" +
            " FROM user " +
            "INNER JOIN a0321i1_cinema.account ON account.username = user.username " +
            "INNER JOIN ward ON user.ward_id = ward.ward_id " +
            "INNER JOIN district ON ward.district_id = district.district_id " +
            "INNER JOIN province ON province.province_id = district.province_id " +
            "WHERE user.username like %?1% AND user.id_card like %?2% AND user.phone like %?3% ",
            countQuery = "SELECT count(*) FROM user WHERE user.username like %?1% AND user.id_card like %?2% AND user.phone like %?3%",
            nativeQuery = true)
    Page<User> findByNameUserAndIdCardAndPhoneAndAddress(String name, String idCard, String phone, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE a0321i1_cinema.user SET user.name = ?2, user.birthday = ?3, user.gender = ?4, user.email = ?5, user.phone = ?6,user.id_card = ?7, user.avatar_url = ?8, user.ward_id = ?9 WHERE (user_id = ?1)", nativeQuery = true)
    void saveUser(Integer userId, String name, String birthday, Integer gender, String email, String phone, String idCard, String avatarUrl, Integer wardId);
}
