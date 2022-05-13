package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "district_name", columnDefinition = "VARCHAR(50)")
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    private Province province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ward> wardSet;

}
