package com.aboshady.stc.repository;


import com.aboshady.stc.model.PermissionGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionGroupRepository extends CrudRepository<PermissionGroup, Long> {

    Optional<PermissionGroup> findByName(String name);
}
