package br.com.empiricus.model;

//BY THIAGOSILVA
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "UserLoginPJ")
@AllArgsConstructor
@NoArgsConstructor
public class ClientePJ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull
	private String email;

	@NotNull
	@Column(name = "cnpj", unique = true)
	@Size(min = 14, max = 14)
	private String cnpj;

	@NotNull
	@Column(name = "telefone")
	private String telefone;

	@NotNull
	@Size(min = 6, max = 100)
	private String senha;

	@OneToMany(mappedBy = "userLoginPJ", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("userLoginPJ")
	@Schema(hidden = true)
	private List<Ativos> ativos;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Ativos> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<Ativos> ativos) {
		this.ativos = ativos;
	}	
	
}
