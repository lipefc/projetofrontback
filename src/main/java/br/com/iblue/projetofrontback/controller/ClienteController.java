package br.com.iblue.projetofrontback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.iblue.projetofrontback.entity.Cliente;
import br.com.iblue.projetofrontback.entity.Telefone;
import br.com.iblue.projetofrontback.repository.ClienteRepository;
import br.com.iblue.projetofrontback.repository.TelefoneRepository;

@ResponseBody
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteRepository cdao;
	@Autowired
	TelefoneRepository tdao;
	
	@PostMapping("/cliente")
	public ResponseEntity<?> create(@RequestBody Cliente cliente){
		try {
			Set <Telefone> telefones = cliente.getTelefones();
			Cliente cli = cliente;
			for(Telefone x : telefones) {
				cli.adicionar(x);
			}
			cdao.save(cli);
			for (Telefone x : telefones) {
				x.setCliente(cli);
				tdao.save(x);
			}
			Map <String, Object> map = new HashMap<String, Object>() {
				{
					put("Cliente Gravado!!!", cli);
					put("Telefone Gravado!!!", telefones);
				}
			};
		return ResponseEntity.status(500).body(map);
			
		}catch (Exception ex) {
			Map <String, Object> maperro = new HashMap<String, Object>(){
				{
					put("Erro na Gravação", ex.getMessage());
				}
			};
		return ResponseEntity.status(500).body(maperro);
		}
	}
	
	@GetMapping(value = "/clientes")
	public ResponseEntity<List<Cliente>> buscarTodos(){
		List<Cliente> lista = cdao.findAll();
		return ResponseEntity.status(200).body(lista);
	}
}