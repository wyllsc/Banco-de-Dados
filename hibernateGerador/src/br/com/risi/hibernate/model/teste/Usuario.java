package br.com.risi.hibernate.model.teste;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 4799949348001182317L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	public Long id;

	@Column(name = "TIPO")
	public Character tipo;

	@Column(name = "LOGIN")
	public Long login;

	@Column(name = "SENHA")
	public Long senha;

	@ManyToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
	public Pessoa pessoa;

	@ManyToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "ID_PROCESSO", referencedColumnName = "ID_PROCESSO")
	public Processo processo;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public Long getSenha() {
		return senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Processo getProcesso() {
		if (processo == null) {
			processo = new Processo();
		}
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Usuario(Long id, Character tipo, Long login, Long senha,
			Pessoa pessoa, Processo processo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
		this.processo = processo;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((processo == null) ? 0 : processo.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

}