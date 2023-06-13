package com.exemple.airxelerateAssessment.service;

import com.exemple.airxelerateAssessment.repositories.RoleRepository;
import com.exemple.airxelerateAssessment.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
