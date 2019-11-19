package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.web.dto.BienDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
@RequestMapping(path = "api/bien")
public interface IBienController {

	@GetMapping(path = "/getAll")
	List<BienDto> getAllBiens();

	@GetMapping(path = "/{id}/getById")
	BienDto getBienById(@PathVariable Long id);

	@PostMapping(path = "/save", consumes = "application/json")
	BienDto saveBien(@RequestBody BienDto biendto);

	@PutMapping(path = "/update")
	BienDto updateBien(@RequestBody BienDto biendto);

	@GetMapping(path = "/{id}/delete")
	boolean deleteBien(Long id);

	@PostMapping(path = "/etatVente", consumes = "application/json")
	BienDto modifEtatVente(@RequestBody BienDto biendto);
}