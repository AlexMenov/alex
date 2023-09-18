package com.alex.bank.alexbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Slf4j
@Table(name = "users_accounts")
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // person data
    @Column
    @NotEmpty
    @NotNull
    @Min(6)
    @Max(256)
    private String username;
    @Column
    @JsonIgnore
    @NotEmpty
    @Min(8)
    @NotNull
    private String password;
    @Column
    @NotEmpty
    private String userRealName;
    @Column
    @NotEmpty
    private String userRealLastName;
    @Column
    @NotEmpty
    @Email
    private String email;
    @Column
    @NotEmpty
    private String phoneNumber;
    @Column
    private String userPhoto;
    @Column
    private String address;

    @NotEmpty
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    // person finance
    @Column
    private String operationsHistory;
    @Column
    private String accounts;
    @Column
    private String userLoggingHistory;
    @Column
    private String userPrivateOptions;
    @Column
    private String tax;
    @Column
    private String confidants;

    // person settings

    @Column
    private boolean isAccountNonExpired;
    @Column
    private boolean isAccountNonLocked;
    @Column
    private boolean isCredentialsNonExpired;
    @Column
    private boolean isEnabled;

    public UserAccount(String username, String password, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        assert roles != null;
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
