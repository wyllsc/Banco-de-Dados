package br.com.risi.hibernate.model.teste;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "PROCESSO")
public class Processo implements Serializable {

	private static final long serialVersionUID = -8750576155836389154L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PROCESSO")
	public Long id;

	@Column(name = "NUM_PROCESSO")
	public Long numero_processo;
	
	@Column(name = "REQUERENTE")
	public String requerente;
	
	@Column(name = "REQUERIDO")
	public String requerido;
	
	@Column(name = "ADVOGADO")
	public String advogado;
	
	@Column(name = "DATA_INICIO")
	public Date dataInicioProcesso;

	@Column(name = "DATA_FIM")
	public Date dataFimProcesso;
	
	@Column(name = "DESCRICAO")
	public String descricao ;
	
	@Column(name = "OBSERVACAO")
	public String observacao;
	
	@Column(name = "DESEMBARGADOR")
	public String desembargador;
	
	@ManyToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "ID_ANDAMENTO_PROCESSO", referencedColumnName = "ID_ANDAMENTO_PROCESSO")
	public AndamentoProcesso andamentoProcesso;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero_processo() {
		return numero_processo;
	}

	public void setNumero_processo(Long numero_processo) {
		this.numero_processo = numero_processo;
	}

	public String getRequerente() {
		return requerente;
	}

	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}

	public String getRequerido() {
		return requerido;
	}

	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}

	public String getAdvogado() {
		return advogado;
	}

	public void setAdvogado(String advogado) {
		this.advogado = advogado;
	}

	public Date getDataInicioProcesso() {
		return dataInicioProcesso;
	}

	public void setDataInicioProcesso(Date dataInicioProcesso) {
		this.dataInicioProcesso = dataInicioProcesso;
	}

	public Date getDataFimProcesso() {
		return dataFimProcesso;
	}

	public void setDataFimProcesso(Date dataFimProcesso) {
		this.dataFimProcesso = dataFimProcesso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDesembargador() {
		return desembargador;
	}

	public void setDesembargador(String desembargador) {
		this.desembargador = desembargador;
	}

	public AndamentoProcesso getAndamentoProcesso() {
		return andamentoProcesso;
	}

	public void setAndamentoProcesso(AndamentoProcesso andamentoProcesso) {
		this.andamentoProcesso = andamentoProcesso;
	}

	public Processo(Long id, Long numero_processo, String requerente,
			String requerido, String advogado, Date dataInicioProcesso,
			Date dataFimProcesso, String descricao, String observacao,
			String desembargador, AndamentoProcesso andamentoProcesso) {
		super();
		this.id = id;
		this.numero_processo = numero_processo;
		this.requerente = requerente;
		this.requerido = requerido;
		this.advogado = advogado;
		this.dataInicioProcesso = dataInicioProcesso;
		this.dataFimProcesso = dataFimProcesso;
		this.descricao = descricao;
		this.observacao = observacao;
		this.desembargador = desembargador;
		this.andamentoProcesso = andamentoProcesso;
	}

	public Processo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((advogado == null) ? 0 : advogado.hashCode());
		result = prime
				* result
				+ ((andamentoProcesso == null) ? 0 : andamentoProcesso
						.hashCode());
		result = prime * result
				+ ((dataFimProcesso == null) ? 0 : dataFimProcesso.hashCode());
		result = prime
				* result
				+ ((dataInicioProcesso == null) ? 0 : dataInicioProcesso
						.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((desembargador == null) ? 0 : desembargador.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((numero_processo == null) ? 0 : numero_processo.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((requerente == null) ? 0 : requerente.hashCode());
		result = prime * result
				+ ((requerido == null) ? 0 : requerido.hashCode());
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
		Processo other = (Processo) obj;
		if (advogado == null) {
			if (other.advogado != null)
				return false;
		} else if (!advogado.equals(other.advogado))
			return false;
		if (andamentoProcesso == null) {
			if (other.andamentoProcesso != null)
				return false;
		} else if (!andamentoProcesso.equals(other.andamentoProcesso))
			return false;
		if (dataFimProcesso == null) {
			if (other.dataFimProcesso != null)
				return false;
		} else if (!dataFimProcesso.equals(other.dataFimProcesso))
			return false;
		if (dataInicioProcesso == null) {
			if (other.dataInicioProcesso != null)
				return false;
		} else if (!dataInicioProcesso.equals(other.dataInicioProcesso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (desembargador == null) {
			if (other.desembargador != null)
				return false;
		} else if (!desembargador.equals(other.desembargador))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero_processo == null) {
			if (other.numero_processo != null)
				return false;
		} else if (!numero_processo.equals(other.numero_processo))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		if (requerido == null) {
			if (other.requerido != null)
				return false;
		} else if (!requerido.equals(other.requerido))
			return false;
		return true;
	}
}