package com.dcsmart.dcsmart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    private Long person_id;

    private String name;

    private String register;

    private String email;

//    @JsonIgnore
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Phone> phones;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")

    private Address address;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    private Boolean isActive;
}
