package com.language_practice_server.server_demo.db.entity;

import com.language_practice_server.server_demo.common.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity{
    @Id @GeneratedValue private Long id;
    @Column(unique = true, nullable = false) private String userName;
    private String password;
    @Enumerated(EnumType.STRING) private Role role;
    private boolean active;
    private boolean locked;
    private boolean credentialsExpired;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String password, Role role, boolean active, boolean locked, boolean credentialsExpired, LocalDateTime createdAt, LocalDateTime lastLoginDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.active = active;
        this.locked = locked;
        this.credentialsExpired = credentialsExpired;
        this.createdAt = createdAt;
        this.lastLoginDate = lastLoginDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", locked=" + locked +
                ", credentialsExpired=" + credentialsExpired +
                ", createdDate=" + createdAt +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return active == that.active && locked == that.locked && Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(credentialsExpired, that.credentialsExpired) && Objects.equals(createdAt, that.createdAt) && Objects.equals(lastLoginDate, that.lastLoginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, role, active, locked, credentialsExpired, createdAt, lastLoginDate);
    }
}
