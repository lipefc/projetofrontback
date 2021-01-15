package br.com.iblue.projetofrontback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.iblue.projetofrontback.entity.Cliente;
import br.com.iblue.projetofrontback.entity.Telefone;
import br.com.iblue.projetofrontback.repository.ClienteRepository;
import br.com.iblue.projetofrontback.repository.TelefoneRepository;

@SpringBootApplication
public class ProjetofrontbackApplication /*implements CommandLineRunner*/{

	//Injeção de Depêndencia (MEM)
	/*@Autowired
	ClienteRepository cdao;
	@Autowired
	TelefoneRepository tdao;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetofrontbackApplication.class, args);
	}

/*	@Override 
	public void run(String... args) throws Exception {
	  try {
		Cliente c = new Cliente(null, "Thais","thais@gmail.com",0.);
		Telefone t1 = new Telefone(null, "88763902", 500., null);
		Telefone t2 = new Telefone(null, "83720984", 800., null);
		
		t1.setCliente(c);
		t2.setCliente(c);
		c.adicionar(t1);
		c.adicionar(t2);
		
		cdao.save(c);
		
		for(Telefone x : c.getTelefones()) {
			tdao.save(x); //Verifica a chave estrangeira
		}
		System.out.println("Dadis Gravados...");
	  }catch(Exception ex) {
		  System.out.println("Error: " + ex.getMessage());
	  }
	}*/
}