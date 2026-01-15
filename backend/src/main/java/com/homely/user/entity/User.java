package com.homely.user.entity;

import com.homely.common.base.BaseEntity;
import com.homely.common.enums.RoleType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String email;

    private String passwordHash;
    private String name;
    private String phone;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private boolean isActive = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;
}
