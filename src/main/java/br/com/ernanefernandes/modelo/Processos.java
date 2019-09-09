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
@Table(name = "processos")
public class Processos implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private TipoAtividade tipo;
	private Status status;
	private String ocorrencia;
	private Date dataCadastro;
	private Turno turno; 
	private Usuario responsavel;
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
	public TipoAtividade getTipo() {
		return tipo;
	}
	public void setTipo(TipoAtividade tipo) {
		this.tipo = tipo;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Column(length = 60, nullable = false)
	public String getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(String ocorrência) {
		this.ocorrencia = ocorrência;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	public Usuario getResponsável() {
		return responsavel;
	}
	public void setResponsável(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, id, ocorrencia, responsavel, status, tipo, turno);
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
		Processos other = (Processos) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(id, other.id)
				&& Objects.equals(ocorrencia, other.ocorrencia) && Objects.equals(responsavel, other.responsavel)
				&& status == other.status && tipo == other.tipo && turno == other.turno;
	}

	
	
}

