package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Data
@Table(name = "`user`")
public class User {

    @Id
    @NotNull(message = "Id không được để trống!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "Họ tên không được để trống!")
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Account account;

    @NotBlank(message = "Ngày sinh không được để trống!")
    @Column(name = "birthday", columnDefinition = "date")
    private String birthday;

    @NotNull(message = "Giới tính không được để trống!")
    @Column(name = "gender", columnDefinition = "int")
    private Integer gender;

    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng")
    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống!")
//    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại không đúng định dạng!")
    @Column(name = "phone", columnDefinition = "VARCHAR(20)")
    private String phone;

    @NotBlank(message = "CMND không được để trống!")
    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "CMND không đúng định dạng!")
    @Column(name = "id_card", columnDefinition = "VARCHAR(20)")
    private String idCard;

    @NotBlank(message = "Avatar không được để trống!")
    @Column(name = "avatar_url", columnDefinition = "VARCHAR(255)")
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    private Ward ward;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ticket> ticketSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> commentSet;

    @OneToMany(mappedBy = "rating")
    @JsonBackReference
    private Set<Rating> ratingSet;
}

