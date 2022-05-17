package com.dcsmart.dcsmart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "address_number")
    private String address_number;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "address")
    private Person person;

}
