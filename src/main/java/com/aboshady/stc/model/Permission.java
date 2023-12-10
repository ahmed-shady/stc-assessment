package com.aboshady.stc.model;

import com.aboshady.stc.enums.PermissionLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "PERMISSION_GROUPS")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "PERMISSION_LEVEL")
    private PermissionLevel permissionLevel;


    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    @JsonIgnore
    private PermissionGroup group;
}
