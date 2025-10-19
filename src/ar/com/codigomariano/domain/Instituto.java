package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.com.codigomariano.enums.Mensaje;

public class Instituto {
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	private List<Categoria> categorias=new ArrayList<Categoria>();
	
	
	public void mostrarUsuarios() {
		for (Usuario usuario : this.usuarios) {
			usuario.mostrarDatos();
		}
		
	}
	
	public void agregaNuevoUsuario(Scanner scanner) {  
	    System.out.print("Escriba el id: ");
	    int idUsuario = scanner.nextInt();
	    scanner.nextLine(); 
	    String nombre=datosIngresados("Escriba tu nombre: ",scanner);
	    String mail=datosIngresados("Escriba tu mail: ",scanner);
	    String esBecado=datosIngresados("¿Es becado? (si/no): ",scanner);
	    boolean becado = esBecado.equals("si");
	    Usuario nuevo = new Usuario(idUsuario, nombre, mail, becado);
	    agregarUsuarioAListado(nuevo);
	    System.out.println("Usuario agregado exitosamente!");
	}
	
	private String datosIngresados(String texto,Scanner sc) {
		String dato=null;
		System.out.print(texto);
	    dato = sc.nextLine();
	    return dato;
	}
	
	public void agregarUsuarioAListado(Usuario usuario) {
		this.usuarios.add(usuario);
	}


	
	public Usuario encontrarUsuario(int idUsuario) {
	    Usuario encontrado = null;
	    int contador=0;
	    while(encontrado==null&&contador<this.usuarios.size()) {
	    	Usuario usuario=this.usuarios.get(contador);  
	        if(usuario.getId() == idUsuario) {
	            encontrado = usuario;
	        }
	        contador++;
	    }
	    return encontrado;
	}
	
	
	public Categoria encontrarCategoria(int id) {
		Categoria encontrada=null;
		int contador=0;
		while(encontrada==null&&contador<this.categorias.size()) {
			Categoria categoria=this.categorias.get(contador);
			if(categoria.getIdCategoria()==id) {
				encontrada=categoria;
			}
			contador++;
		}
		return encontrada;
	}
	
	
	public void mostrarCursosPorCategoria(int idCategoria) {
		Categoria seleccionada=encontrarCategoria(idCategoria);
		if(seleccionada!=null) seleccionada.mostrarCursos();
	}
	
	
	public String suscribirseACurso(int idUsuario, int idCurso) {
	    String resultado = null;
	    Usuario usuario = encontrarUsuario(idUsuario);
	    Curso cursoASuscribir =encontrarCursoPorCategoria(idCurso);
	    if(usuario == null) {
	       return resultado=Mensaje.USUARIO_INEX.getMensaje();
	    }
	    if(cursoASuscribir == null) {
	        resultado=Mensaje.CURSO_INEX.getMensaje();
	    }else if(cursoASuscribir.esAutor(idUsuario)) {
	        resultado=Mensaje.ES_AUTOR.getMensaje();
	    }else if(cursoASuscribir.estaSuscripto(idUsuario)) {
	        resultado=Mensaje.YA_SUSCRIPTO.getMensaje();
	    }else if(cursoASuscribir.superaBecarios()) {
	        resultado=Mensaje.MAX_BECADOS.getMensaje();
	    }else {
	    
	    cursoASuscribir.agregarSuscriptores(usuario);
	    resultado=Mensaje.SUSCRIPTO_OK.getMensaje();
	    }
	    return resultado;
	}
	
	public void agregarCategorias(Categoria nueva) {
		this.categorias.add(nueva);
	}
	public void getCategorias() {
		for (Categoria categoria : this.categorias) {
			categoria.mostrarDatos();
		}
	}
	private Curso encontrarCursoPorCategoria(int id) {
		Curso curso =null;
		int contador=0;
		while(curso==null&&contador<this.categorias.size()) {
		    Categoria categoria=this.categorias.get(contador);
		    curso=categoria.encontrarCurso(id);
		    contador++;
		        }
		return curso;
	}

}
