package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;

@RequestMapping(value="/index")

public String index(Model model) {
	Pageable pageable = PageRequest.of(0, 10);
   
	Page<Produit> produits = produitRepository.findAll(pageable);
	model.addAttribute("listProduits",produits.getContent());
	
	return "produits";
}
	
		
	
	

}
