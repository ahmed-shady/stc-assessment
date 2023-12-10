package com.aboshady.stc.enums;

import lombok.Getter;

/**
 * two fixed users ADMIN, USER with EDIT, VIEW access respectively
 */
@Getter
public enum User {
    ADMIN("admin@stc.com", PermissionLevel.EDIT), USER("user@stc.com", PermissionLevel.VIEW);

    private final String userEmail;
    private final PermissionLevel permissionLevel;

    User(String userEmail, PermissionLevel permissionLevel){
        this.permissionLevel = permissionLevel;
        this.userEmail = userEmail;
    }
}
