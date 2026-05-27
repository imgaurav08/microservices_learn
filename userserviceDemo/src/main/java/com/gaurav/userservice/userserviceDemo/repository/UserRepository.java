package com.gaurav.userservice.userserviceDemo.repository;

import com.gaurav.userservice.userserviceDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
