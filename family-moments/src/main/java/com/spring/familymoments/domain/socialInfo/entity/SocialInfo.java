package com.spring.familymoments.domain.socialInfo.entity;

import com.spring.familymoments.domain.common.BaseEntity;
import com.spring.familymoments.domain.socialInfo.UserType;
import com.spring.familymoments.domain.user.entity.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "SocialInfo")
@Setter
@Getter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
public class SocialInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "snsInfoId", nullable = false, updatable = false)
    private Long snsInfoId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", nullable = false)
    private User user;
    @Column(name = "type", nullable = false, length = 10)
    private UserType type = UserType.NORMAL;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String snsUserId;
}