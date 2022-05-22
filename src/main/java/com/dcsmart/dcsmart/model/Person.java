package com.dcsmart.dcsmart.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "person")
public class Person {
    @Id
    @Column(name = "person_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "person_name")
    private String name;

    @Column(name = "register")
    private String register;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Phone> phones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    private Address address;

    @OneToOne(mappedBy = "person")
    private User user;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "is_active")
    private Boolean isActive;
}
