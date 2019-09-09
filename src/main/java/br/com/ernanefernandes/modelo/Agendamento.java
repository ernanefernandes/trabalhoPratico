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
@Table(name = "agendamento")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private TipoManutencao tipoManutencao;
	private Insumos insumo;
	private Usuario solicitante;
	private Usuario responsavel;
	private Date dataEntrada;
	private Date dataPrevisao;
	private Date dataSaida;
	private String descricao;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoManutencao getTipoManutencao() {
		return tipoManutencao;
	}
	public void setTipoManutencao(TipoManutencao tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "insumo_id")
	public Insumos getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumos insumo) {
		this.insumo = insumo;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "solicitante_id")
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "responsavel_id")
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_entrada", nullable = false)
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_previsao", nullable = false)
	public Date getDataPrevisao() {
		return dataPrevisao;
	}
	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_saida", nullable = false)
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	@Column(length = 255, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataEntrada, dataPrevisao, dataSaida, descricao, id, insumo, responsavel, solicitante,
				tipoManutencao);
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
		Agendamento other = (Agendamento) obj;
		return Objects.equals(dataEntrada, other.dataEntrada) && Objects.equals(dataPrevisao, other.dataPrevisao)
				&& Objects.equals(dataSaida, other.dataSaida) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(insumo, other.insumo)
				&& Objects.equals(responsavel, other.responsavel) && Objects.equals(solicitante, other.solicitante)
				&& tipoManutencao == other.tipoManutencao;
	}


}