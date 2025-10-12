package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int idCategoria;
	private String nombre;
	public List<Curso> cursos=new ArrayList<Curso>();
	

	
	public Categoria(int id, String nombre) {
		this.idCategoria=id;
		this.nombre=nombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void agregarCursos(Curso nuevoCurso) {
		cursos.add(nuevoCurso);
	}
	
	
	
	public Curso encontrarCurso(int id) {
		Curso encontrado=null;
		for (Curso curso : cursos) {
			if(curso.getIdCurso()==id) {
				encontrado=curso;
			}
		}
		return encontrado;
	}
	public void getCursos() {
		for (Curso curso : cursos) {
			System.out.println("-------------------");
			System.out.println("idCurso: "+curso.getIdCurso());
			System.out.println("Nombre: "+curso.getTitulo());
			System.out.println("Precio: $"+curso.getPrecio());
			System.out.println("Valoración: "+curso.getValoracion());
		}
	}
	public void mostrarSuscriptores(int idCurso) {
		Curso seleccionado=null;
		for (Curso curso : cursos) {
			if(curso.getIdCurso()==idCurso) {
				seleccionado=curso;
			}
		}
		seleccionado.getSuscriptores();
	}

	

}
