package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Id> {

    User findByEmail(String email);
    User findUserByEmail(String email);
    User findUserById(long id);
    User findByActCode(String actCode);
}
