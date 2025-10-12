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
	
	public static final int MAX_BECADOS=5;
	
	public Curso(int id,String titulo,double precio,int valor) {
		this.idCurso=id;
		this.titulo=titulo;
		this.precio=precio;
		this.valoracion=valor;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
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

	public void getSuscriptores() {
		for (Usuario suscriptor : suscriptores) {
			System.out.println("-------------------");
			System.out.println("idUsuario: "+suscriptor.getId());
			System.out.println("Nombre: "+suscriptor.getNombre());
			System.out.println("Correo electronico: "+suscriptor.getMail());
			System.out.println("¿Es becario?: "+suscriptor.isEsBecario());
		}
	}
	
	

	public void agregarSuscriptores(Usuario nuevo) {
		
		suscriptores.add(nuevo);
	}

	public void getLecciones() {
		for (Leccion leccion : lecciones) {
			System.out.println("-------------------");
			System.out.println("Nombre: "+leccion.getNombre());
			System.out.println("Duración en minutos: "+leccion.getDuracion());
			System.out.println("Tipo de lección: "+leccion.getTipoDeLeccion());
		}
		
	}

	
	public void agregarLecciones(Leccion nueva) {
		lecciones.add(nueva);
	}
	
	public boolean estaSuscripto(int idUsuario) {
		boolean estaSuscripto=false;
		for (Usuario usuario : suscriptores) {
			if(usuario.getId()==idUsuario) {
				estaSuscripto=true;
			}
		}
		return estaSuscripto;
	}
	
	public boolean superaBecarios(Usuario usuarioNuevo) {
		  if(!usuarioNuevo.isEsBecario()) {
		        return false;
		    }
		
	    int contadorBecario = 0;
	    
	    for (Usuario usuario : suscriptores) {
	        if(usuario.isEsBecario()) {
	            contadorBecario++;
	        }
	    }
	    
	    if(contadorBecario >= MAX_BECADOS) {  
	        return true;   
	    }
	    
	    return false;  
	}


}
