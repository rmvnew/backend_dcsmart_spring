package com.dcsmart.dcsmart.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",referencedColumnName = "person_id")
    private Person person;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "is_active")
    private Boolean isActive;

}
