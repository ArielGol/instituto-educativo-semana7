package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Tipo;

public class Leccion {
	private String nombre;
	private int duracion;
	private Tipo tipoDeLeccion;
	
	public Leccion(String nombre,int duracion, Tipo tipo) {
		this.nombre=nombre;
		this.duracion=duracion;
		this.tipoDeLeccion=tipo;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getTipoDeLeccion() {
		return tipoDeLeccion.getTipoDeLeccion();
	}
	
	public void mostrarDatos() {
		System.out.println("-------------------");
		System.out.println("Nombre: "+nombre);
		System.out.println("Duración en minutos: "+duracion);
		System.out.println("Tipo de lección: "+tipoDeLeccion);
	}

}
