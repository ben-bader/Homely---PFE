package com.homely.moderation.entity;

import com.homely.common.base.BaseEntity;
import com.homely.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditLog extends BaseEntity {

    @ManyToOne
    private User admin;

    private String action;

    @Column(columnDefinition = "jsonb")
    private String details;
}
