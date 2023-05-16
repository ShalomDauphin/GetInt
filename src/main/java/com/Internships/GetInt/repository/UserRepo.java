package com.Internships.GetInt.repository;

import com.Internships.GetInt.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLoginAndPassword(String login, String password);
    Optional<UserModel> findFirstByLogin(String login);
    Optional<UserModel> findFirstByEmail(String email);
}
