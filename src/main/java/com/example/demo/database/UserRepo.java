package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo,Integer>{

}
