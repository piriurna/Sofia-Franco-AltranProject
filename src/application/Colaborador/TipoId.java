package application.colaborador;

public enum TipoId {
	PASSAPORTE(0), CARTAO_CIDADAO(1), OUTRO(2);
	
	private int id;
	
	private TipoId(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static TipoId valueOf(int id) {
		 for(TipoId e : values()) {
		        if(e.getId() == id) return e;
		    }
		 return TipoId.OUTRO;
	}
}
