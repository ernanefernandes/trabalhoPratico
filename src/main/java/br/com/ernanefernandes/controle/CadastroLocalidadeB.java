package br.com.ernanefernandes.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.ernanefernandes.modelo.Localidade;
import br.com.ernanefernandes.service.CapturaException;
import br.com.ernanefernandes.service.LocalidadeService;
import br.com.ernanefernandes.util.FacesUtil;


@Named
@ViewScoped
public class CadastroLocalidadeB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//private RelatorioDespesa relatorioDespesa;
	private Localidade local;
	private List<Localidade> listaLocais;
	
	//@Inject
	//private RelatorioDespesaService relatorioDespesaService;
	
	@Inject
	private FacesUtil facesUtil;
	
	@Inject
	private LocalidadeService localidadeServico;
	
	@PostConstruct
	public void init() {
		this.clean();
		this.local = new Localidade();
		this.listaLocais = this.localidadeServico.listar();
	}
	public List<Localidade> getListaInsumos() {
		return listaLocais;
	}
	
	public void salvar() throws CapturaException {
		localidadeServico.cadastrar(this.local);
		this.local = new Localidade();
		facesUtil.info("Registro salvo com sucesso!");
	}
	
	private void clean() {
		this.local = new Localidade();
	}

	public Localidade getLocal() {
		return local;
	}
	public void setLocal(Localidade local) {
		this.local = local;
	}
	
}

