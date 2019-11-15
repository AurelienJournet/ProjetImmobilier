package com.fr.adaming.web.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.web.dto.BienDto;

@RestController
@RequestMapping(path = "api/bien")
public interface IBienController {

	@GetMapping(path = "/getAll")
	Collection<Bien> getAllBiens();

	@GetMapping(path = "/getById")
	Bien getBienById(Long id);

//	@GetMapping(path = "/getByPrix")
//	Bien findByPrix(int prix);

	@PostMapping(path = "/save")
	Bien saveBien(@RequestBody Bien bien);

	@PutMapping(path = "/update")
	Bien updateBien(Bien bien);

	@GetMapping(path = "/{id}/delete")
	boolean deleteBien(Long id);

	@PostMapping(path = "/etatVente")
	Bien modifEtatVente(@RequestBody BienDto biendto);
}
