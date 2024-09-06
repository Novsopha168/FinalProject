package com.rupp.finalprojectlms.features.user;


import com.rupp.finalprojectlms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
