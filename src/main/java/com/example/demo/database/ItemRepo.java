package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Items,Long> {

}
