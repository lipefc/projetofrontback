package br.com.iblue.projetofrontback.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tbltelefone")
@SequenceGenerator(sequenceName="seq_telefone", name="seq_telefone", initialValue=1, allocationSize=1)
public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id		 //primary key
	@GeneratedValue(generator = "seq_telefone")
	@Column(name="idtelefone")
	@JsonProperty(value= "idtelefone")
	private Long idTelefone;
	
	@Column(name="numero", length=15)
	@JsonProperty("numero")
	private String numero;
	
	@Column(name="valor")
	@JsonProperty("valor")
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", referencedColumnName="idCliente")
	@JsonBackReference("Telefones")
	private Cliente cliente;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(Long idTelefone, String numero, Double valor, Cliente cliente) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.valor = valor;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", valor=" + valor + "]";
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}