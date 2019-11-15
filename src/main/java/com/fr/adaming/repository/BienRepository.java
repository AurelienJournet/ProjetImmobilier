package com.fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Bien;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

	boolean existsById(Long id);
	
//	boolean existByVendu(boolean vendu);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Bien SET vendu= :vendu WHERE id= :id")
	void modifEtatVente(long id, Boolean vendu);
	
}
