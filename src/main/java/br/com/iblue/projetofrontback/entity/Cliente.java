package br.com.iblue.projetofrontback.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tblcliente")
@SequenceGenerator(sequenceName="seq_cliente", name="seq_cliente", initialValue=1, allocationSize=1)
public class Cliente implements Serializable {
	//hibernate -- JPA --> spring - data
	
	private static final long serialVersionUID = 1L;
	
	@Id //primary key
	@GeneratedValue(generator = "seq_cliente")
	@Column(name="idcliente")
	@JsonProperty("idcliente")
	private Long idCliente;
	
	@Pattern(regexp = "[A-Za-z ]{2,50}", message="Nome Inválido!!!")
	@Column(name="nomecliente", length=50)
	@JsonProperty("nomecliente")
	private String nome;
	
	@Pattern(regexp = "([a-zA-Z]+)@([a-zA-Z])+\\.([a-z]+)", message="Email Inválido!!!")
	@Column(name="email", length=50, unique=true)
	@JsonProperty("email")
	private String email;
	
	@Min(value=-2000 , message="Saldo Negativo Fora do Limite")
	@Column(name="saldo")
	@JsonProperty("saldo")
	private Double saldo=0.;
	
	@OneToMany(mappedBy ="cliente", fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	private Set<Telefone> telefones = new HashSet<>();

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long idCliente, 
			@Pattern(regexp = "[A-Za-z ]{2,50}", message = "Nome Inválido!!!") String nome,
			@Pattern(regexp = "([a-zA-Z]+)@([a-zA-Z])+\\.([a-z]+)", message = "Email Inválido!!!") String email,
			@Min(value = -2000, message = "Saldo Negativo Fora do Limite") Double saldo, Set<Telefone> telefones) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		this.telefones = telefones;
	}

	public Cliente(Long idCliente, @Pattern(regexp = "[A-Za-z ]{2,50}", message = "Nome Inválido!!!") String nome,
			@Pattern(regexp = "([a-zA-Z]+)@([a-zA-Z])+\\.([a-z]+)", message = "Email Inválido!!!") String email,
			@Min(value = -2000, message = "Saldo Negativo Fora do Limite") Double saldo) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", saldo=" + saldo
				+ "]";
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void adicionar(Telefone telefone) {
		this.saldo += telefone.getValor();
		this.telefones.add(telefone);
	}
}