package br.com.ernanefernandes.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.ernanefernandes.modelo.Insumos;
import br.com.ernanefernandes.service.CapturaException;
import br.com.ernanefernandes.service.InsumoService;
import br.com.ernanefernandes.util.FacesUtil;


@Named
@ViewScoped
public class CadastroInsumosB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//private RelatorioDespesa relatorioDespesa;
	private Insumos insumo;
	private List<Insumos> listaInsumos;
	private Insumos insumoSelecionado;
	//@Inject
	//private RelatorioDespesaService relatorioDespesaService;
	
	@Inject
	private FacesUtil facesUtil;
	
	@Inject
	private InsumoService insumoService;
	
	@PostConstruct
	public void init() {
		this.clean();
		this.insumo = new Insumos();
	}
	
	public void prepararCadastro() {
		this.listaInsumos = this.insumoService.listar();
		if (this.insumo == null) {
			this.insumo = new Insumos();
		}
	}
	public List<Insumos> getListaInsumos() {
		return listaInsumos;
	}
	
	public void salvar() throws CapturaException {
		insumoService.cadastrar(this.insumo);
		this.insumo = new Insumos();
		facesUtil.info("Registro salvo com sucesso!");
	}
	public boolean deletar(int id) {
		try {
			insumoService.excluir(id);
			facesUtil.info("Registro excluído com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void clean() {
		this.insumo = new Insumos();
	}

	public Insumos getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumos insumo) {
		this.insumo = insumo;
	}
	
}
