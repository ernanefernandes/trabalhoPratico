package br.com.ernanefernandes.modelo;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "insumos")
public class Insumos implements Serializable {
	public Insumos() {
		
	}
	public Insumos(String nome, Date dataCadastro, Long fornecedor, Long numeroSerie, String descricao, TipoInsumo tipo,
			Localidade localidade) {
		super();
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.fornecedor = fornecedor;
		this.numeroSerie = numeroSerie;
		this.descricao = descricao;
		this.tipoInsumo  = tipo;
		this.localidade = localidade;
	}
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Date dataCadastro;
	private Long fornecedor;
	private Long numeroSerie;
	private String descricao;
	private TipoInsumo tipoInsumo;
	private Localidade localidade;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 60, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Column(precision = 10, scale = 2, nullable = false)
	public Long getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Long fornecedor) {
		this.fornecedor = fornecedor;
	}
	@Column(precision = 10, scale = 2, nullable = false)
	public Long getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(Long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	@Column(length = 60, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoInsumo getTipo() {
		return tipoInsumo;
	}
	public void setTipo(TipoInsumo tipoInsumo	) {
		this.tipoInsumo = tipoInsumo;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "localidade_id")
	public Localidade getLocal() {
		return localidade;
	}
	public void setLocal(Localidade localidade) {
		this.localidade = localidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, dataCadastro, fornecedor, id, localidade, nome, numeroSerie, tipoInsumo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Insumos other = (Insumos) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(fornecedor, other.fornecedor) && Objects.equals(id, other.id)
				&& Objects.equals(localidade, other.localidade) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroSerie, other.numeroSerie) && tipoInsumo == other.tipoInsumo;
	} 
	
	

}