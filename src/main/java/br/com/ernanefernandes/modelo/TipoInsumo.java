package br.com.ernanefernandes.modelo;

public enum TipoInsumo {
	MAQUINARIO("Maquinario"),
	MATERIA_PRIMA("Matéria-Prima"),
	REJEITO("Rejeito");
	
	private String descricao;
	
	TipoInsumo(String descricao) {
		this.descricao = descricao;
		}
		public String getDescricao() {
		return descricao;
		}
	}
