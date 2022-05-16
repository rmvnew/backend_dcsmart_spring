package com.dcsmart.dcsmart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "phone")
public class Phone {

    @Id
    @Column(name = "phone_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phone_id;
    private String phone_number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",referencedColumnName = "person_id")
    private Person person;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    private Boolean isActive;

}
