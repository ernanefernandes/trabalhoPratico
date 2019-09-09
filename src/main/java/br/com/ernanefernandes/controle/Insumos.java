package br.com.ernanefernandes.controle;
import java.io.Serializable;
import java.util.Date;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import br.com.ernanefernandes.modelo.Localidade;
import br.com.ernanefernandes.modelo.TipoInsumo;

@Named
@SessionScoped
public class Insumos implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Date dataCadastro;
	private Long fornecedor;
	private Long numeroSerie;
	private String descricao;
	private TipoInsumo tipoInsumo;
	private Localidade localidade;
	
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

	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Long fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Long getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(Long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoInsumo getTipo() {
		return tipoInsumo;
	}
	public void setTipo(TipoInsumo tipoInsumo	) {
		this.tipoInsumo = tipoInsumo;
	}

	public Localidade getLocal() {
		return localidade;
	}
	public void setLocal(Localidade localidade) {
		this.localidade = localidade;
	}

	
	

}