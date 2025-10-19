package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private int idCurso;
	private String titulo;
	private double precio;
	private int valoracion;
	private Usuario autor;
	private List<Usuario> suscriptores=new ArrayList<Usuario>();
	private List<Leccion> lecciones=new ArrayList<Leccion>();
	
	private static final int MAX_BECADOS=5;
	
	public Curso(int id,String titulo,double precio,int valor) {
		this.idCurso=id;
		this.titulo=titulo;
		this.precio=precio;
		this.valoracion=valor;
	}

	public int getIdCurso() {
		return idCurso;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor=autor;
	}
	
	public boolean esAutor(int id) {
		boolean resultado=false;
		if(autor.getId()==id) {
			resultado=true;
		}
		return resultado;
	}
	
	public void mostrarDatos() {
			System.out.println("-------------------");
			System.out.println("idCurso: "+this.idCurso);
			System.out.println("Nombre: "+this.titulo);
			System.out.println("Precio: $"+this.precio);
			System.out.println("Valoración: "+this.valoracion);
		}

	public void getSuscriptores() {
		for (Usuario suscriptor : suscriptores) {
			suscriptor.mostrarDatos();
		}
	}
	
	
	public void agregarSuscriptores(Usuario nuevo) {
		suscriptores.add(nuevo);
	}

	public void getLecciones() {
		for (Leccion leccion : lecciones) {
			leccion.mostrarDatos();
		}
		
	}

	public void agregarLecciones(Leccion nueva) {
		lecciones.add(nueva);
	}
	
	public boolean estaSuscripto(int idUsuario) {
		boolean estaSuscripto=false;
		int contador=0;
		while(!estaSuscripto&&contador<this.suscriptores.size()) {
			Usuario usuario=this.suscriptores.get(contador);
			if(usuario.getId()==idUsuario) {
				estaSuscripto=true;
			}
			contador++;
		}
		return estaSuscripto;
	}
	
	public boolean superaBecarios() {
		boolean resultado=false;
		int becarios=cantidadDeBecarios();
		if(becarios>=MAX_BECADOS) {
			resultado=true;
		}
		return resultado;
	}
	
	private int cantidadDeBecarios() {
		  int becarios = 0;
		    for (Usuario usuario : suscriptores) {
		        if(usuario.getBecario()) {
		            becarios++;
		        }
	      
	}
		    return becarios;
	}

}
