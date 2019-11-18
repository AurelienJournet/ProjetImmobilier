package com.fr.adaming.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.web.dto.BienDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
@RequestMapping(path = "api/bien")
public interface IBienController {

	@GetMapping(path = "/getAll")
	Collection<Bien> getAllBiens();

	@GetMapping(path = "/getById")
	Bien getBienById(Long id);

//	@GetMapping(path = "/getByPrix")
//	Bien findByPrix(int prix);


	@PostMapping(path = "/save", consumes = "application/json")
	Bien saveBien(@RequestBody BienDto biendto);

	@PutMapping(path = "/update")
	Bien updateBien(BienDto biendto);

	@GetMapping(path = "/{id}/delete")
	boolean deleteBien(Long id);

	@PostMapping(path = "/etatVente", consumes = "application/json")
	Bien modifEtatVente(@RequestBody BienDto biendto);
}