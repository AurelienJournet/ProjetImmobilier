package com.fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Agent;
/**
 * @author VITTOZ Guillaume
 *
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	boolean existsById(Long id);

}
