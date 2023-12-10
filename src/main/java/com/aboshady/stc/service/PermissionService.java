package com.aboshady.stc.service;

import com.aboshady.stc.enums.User;
import com.aboshady.stc.model.Permission;
import com.aboshady.stc.model.PermissionGroup;
import com.aboshady.stc.repository.PermissionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PermissionService {

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    public PermissionGroup createPermissionGroup(String name){
        Permission adminPermission = Permission.builder().userEmail(User.ADMIN.getUserEmail()).permissionLevel(User.ADMIN.getPermissionLevel()).build();
        Permission userPermission = Permission.builder().userEmail(User.USER.getUserEmail()).permissionLevel(User.USER.getPermissionLevel()).build();

        PermissionGroup group = PermissionGroup.builder().name(name).permissions(Arrays.asList(adminPermission, userPermission)).build();
        return permissionGroupRepository.save(group);
    }
}
