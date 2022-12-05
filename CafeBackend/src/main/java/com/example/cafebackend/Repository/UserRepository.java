package com.example.cafebackend.Repository;

import com.example.cafebackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
