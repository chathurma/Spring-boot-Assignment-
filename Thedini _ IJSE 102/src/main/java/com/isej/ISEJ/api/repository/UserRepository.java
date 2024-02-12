package com.isej.ISEJ.api.repository;

import com.isej.ISEJ.api.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Integer> {

}
