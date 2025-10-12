package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.com.codigomariano.enums.Mensaje;

public class Instituto {
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	private List<Categoria> categorias=new ArrayList<Categoria>();
	
	
	public void mostrarUsuarios() {
		for (Usuario usuario : usuarios) {
			System.out.println("-------------------");
			System.out.println("idUsuario: "+usuario.getId());
			System.out.println("Nombre: "+usuario.getNombre());
			System.out.println("Correo electronico: "+usuario.getMail());
			System.out.println("¿Es becario?: "+usuario.isEsBecario());
		}
		
	}
	
	
	
	public void agregaNuevoUsuario(Scanner scanner) {  
	    System.out.print("Escriba el id: ");
	    int idUsuario = scanner.nextInt();
	    scanner.nextLine(); 
	    System.out.print("Escriba tu nombre: ");
	    String nombre = scanner.nextLine();
	    System.out.print("Escriba tu mail: ");
	    String mail = scanner.nextLine();
	    System.out.print("¿Es becado? (si/no): ");
	    String esBecado = scanner.nextLine();
	    boolean becado = esBecado.equals("si");
	    Usuario nuevo = new Usuario(idUsuario, nombre, mail, becado);
	    usuarios.add(nuevo);
	    System.out.println("Usuario agregado exitosamente!");
	}
	
	public void agregarUsuarioAListado(Usuario usuario) {
		usuarios.add(usuario);
	}


	
	public Usuario encontrarUsuario(int idUsuario) {
	    Usuario encontrado = null;
	    for (Usuario usuario : usuarios) {  
	        if(usuario.getId() == idUsuario) {
	            encontrado = usuario;
	            break; 
	        }
	    }
	    
	    return encontrado;
	}
	public Categoria encontrarCategoria(int id) {
		Categoria encontrada=null;
		for (Categoria categoria : categorias) {
			if(categoria.getIdCategoria()==id) {
				encontrada=categoria;
				break;
			}
		}
		return encontrada;
	}
	public void mostrarCursos(int idCategoria) {
		Categoria seleccionada=null;
		for (Categoria categoria : categorias) {
			if(categoria.getIdCategoria()==idCategoria) {
				seleccionada=categoria;
				break;
			}
		}
		seleccionada.getCursos();
	}
	
	
	
	public String suscribirseACurso(int idUsuario, int idCurso) {
	    String resultado = null;
	    Usuario usuario = encontrarUsuario(idUsuario);
	    Curso cursoASuscribir = null;
	    if(usuario == null) {
	        return Mensaje.USUARIO_INEX.getMensaje();
	    }
	    for (Categoria categoria : categorias) {
	        cursoASuscribir = categoria.encontrarCurso(idCurso);
	        if(cursoASuscribir != null) {
	            break;
	        }
	    }
	    if(cursoASuscribir == null) {
	        return Mensaje.CURSO_INEX.getMensaje();
	    }
	    if(cursoASuscribir.esAutor(idUsuario)) {
	        return Mensaje.ES_AUTOR.getMensaje();
	    }
	    
	    if(cursoASuscribir.estaSuscripto(idUsuario)) {
	        return Mensaje.YA_SUSCRIPTO.getMensaje();
	    }
	    if(cursoASuscribir.superaBecarios(usuario)) {
	        return Mensaje.MAX_BECADOS.getMensaje();
	    }
	    cursoASuscribir.agregarSuscriptores(usuario);
	    resultado=Mensaje.SUSCRIPTO_OK.getMensaje();
	    return resultado;
	}
		
		
	public void agregarCategorias(Categoria nueva) {
		categorias.add(nueva);
	}
	public void getCategorias() {
		for (Categoria categoria : categorias) {
			System.out.println("-------------------");
			System.out.println("Id : "+categoria.getIdCategoria());
			System.out.println("Nombre : "+categoria.getNombre());

		}
		
	}

}
