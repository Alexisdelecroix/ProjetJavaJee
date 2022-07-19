package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;



@SpringBootApplication
public class ProjetJavaJeeApplication {

	public static void main(String[] args) {
		
		
	ApplicationContext ctx=SpringApplication.run(ProjetJavaJeeApplication.class, args);
	ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
	produitRepository.save(new Produit("Xiaomi S Pro", 1000, 500));
	produitRepository.save(new Produit("Ordinateur portable", 1500, 80));
	produitRepository.save(new Produit("Ecran 4K", 800, 100));
	produitRepository.save(new Produit("Drône", 399, 50));
	produitRepository.save(new Produit("Tour Gaming", 2000, 30));
	
	
	produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
	}

}
