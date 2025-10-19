package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int idCategoria;
	private String nombre;
	private List<Curso> cursos=new ArrayList<Curso>();
	

	
	public Categoria(int id, String nombre) {
		this.idCategoria=id;
		this.nombre=nombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}


	public void agregarCursos(Curso nuevoCurso) {
		cursos.add(nuevoCurso);
	}
		
	public Curso encontrarCurso(int id) {
		Curso encontrado=null;
		int contador=0;
		while(encontrado==null&&contador<this.cursos.size()) {
			Curso curso=this.cursos.get(contador);
			if(curso.getIdCurso()==id) encontrado=curso;
			contador++;
		}
		return encontrado;
	}
	public void mostrarCursos() {
		for (Curso curso : this.cursos) {
			curso.mostrarDatos();
		}
	}
	public void mostrarSuscriptores(int idCurso) {
		Curso seleccionado=encontrarCurso(idCurso);
		if(seleccionado!=null) seleccionado.getSuscriptores();
	}
	public void mostrarDatos() {
		System.out.println("-------------------");
		System.out.println("Id : "+this.idCategoria);
		System.out.println("Nombre : "+this.nombre);
	}

	

}
