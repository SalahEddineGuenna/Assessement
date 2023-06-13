package com.exemple.airxelerateAssessment.repositories;

import com.exemple.airxelerateAssessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
