package com.fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Client;
/**
 * @author Aurélien
 *
 */
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{

}

