package ar.com.codigomariano.enums;

public enum Tipo {
	TEXTO("Texto"),
	VIDEO("Video"),
	RECURSO("Recurso");
	
	private String tipoDeLeccion;
	
	private Tipo(String tipo) {
		this.tipoDeLeccion=tipo;
	}
	
	public String getTipoDeLeccion() {
		return this.tipoDeLeccion;
	}

}
