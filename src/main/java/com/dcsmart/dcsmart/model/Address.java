package com.dcsmart.dcsmart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    private String city;
    private String street;
    private String district;
    private String address_number;
    private String state;
    private String country;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    private Boolean isActive;
//    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Person person;

}
