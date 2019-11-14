package com.fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
