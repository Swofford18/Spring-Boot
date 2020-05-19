package com.suetin.boot.service;

import com.suetin.boot.model.Role;
import com.suetin.boot.repository.RoleRepository;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role getAdminRole();

    Role getUserRole();
}
