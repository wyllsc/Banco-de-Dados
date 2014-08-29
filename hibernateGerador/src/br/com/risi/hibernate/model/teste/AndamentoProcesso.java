package br.com.risi.hibernate.model.teste;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANDAMENTO_PROCESSO")
public class AndamentoProcesso implements Serializable {

	private static final long serialVersionUID = 5225438029489370844L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ANDAMENTO_PROCESSO")
	public Long id;

	@Column(name = "TIPO")
	public Character tipo;

	@Column(name = "DESCRICAO")
	public String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AndamentoProcesso other = (AndamentoProcesso) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public AndamentoProcesso(Long id, Character tipo, String descricao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public AndamentoProcesso() {
		super();
		// TODO Auto-generated constructor stub
	}
}