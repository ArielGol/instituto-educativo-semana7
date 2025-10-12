package ar.com.codigomariano.enums;

public enum Mensaje {
	CURSO_INEX("El curso solicitado no existe"),
	USUARIO_INEX("El usuario especificado no existe"),
	YA_SUSCRIPTO("El usuario ya esta suscripto en el curso"),
	ES_AUTOR("El usuario que intenta suscribirse es el autor del curso"),
	MAX_BECADOS("El curso ya cuenta con el maximo de becados posibles"),
	SUSCRIPTO_OK("El usuario se suscribió exitosamente al curso");
	
	private String mensaje;
	
	private Mensaje(String mensaje) {
		this.mensaje=mensaje;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}

}
