package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;

@RequestMapping(value="/index")
public String index(Model model,
		@RequestParam(name="page", defaultValue="0")int p,
		@RequestParam(name="size", defaultValue="10")int s){
	Pageable pageable = PageRequest.of(p,s);

	Page<Produit> produits = produitRepository.findAll(pageable);
	model.addAttribute("listProduits",produits.getContent());

	Page<Produit> pageProduits = null;
	int[] pages=new int[pageProduits.getTotalPages()];
	model.addAttribute("pages",pages);
	return "produits";

}
	
		
	
	

}
