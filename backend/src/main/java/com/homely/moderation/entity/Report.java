package com.homely.moderation.entity;

import com.homely.common.base.BaseEntity;
import com.homely.common.enums.ReportStatus;
import com.homely.property.entity.Property;
import com.homely.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Report extends BaseEntity {

    @ManyToOne
    private User reporter;

    @ManyToOne
    private User reportedUser;

    @ManyToOne
    private Property reportedProperty;

    private String reason;

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @ManyToOne
    private User reviewedByAdmin;
}
