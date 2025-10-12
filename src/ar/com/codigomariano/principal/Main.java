package ar.com.codigomariano.principal;



import java.util.Scanner;

import ar.com.codigomariano.domain.Categoria;
import ar.com.codigomariano.domain.Curso;
import ar.com.codigomariano.domain.Instituto;
import ar.com.codigomariano.domain.Leccion;
import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.enums.Tipo;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//BASE DE DATOS
		Instituto instituto1=new Instituto();	
		Categoria programacion =new Categoria(10,"Programacion");
		Curso logica=new Curso(1,"Logica para principiantes",50,7);
		Leccion htmlCss=new Leccion("Introduccion a HTML y CSS",30,Tipo.VIDEO);
		logica.agregarLecciones(htmlCss);
		programacion.agregarCursos(logica);
		 
		Curso react=new Curso(2,"React:primeros pasos",62.50,9);
		Leccion forms=new Leccion("Forms y Hooks",40,Tipo.RECURSO);
		react.agregarLecciones(forms);
		programacion.agregarCursos(react);
	
		Categoria devops=new Categoria(20,"DevOps");
		Curso linux=new Curso(3,"Linux:manejo de archivos",40,6);
		Leccion archivos=new Leccion("Trabajando con archivos y directorios",50,Tipo.TEXTO);
		Leccion edicion=new Leccion("Edicion de archivos",30,Tipo.VIDEO);
		linux.agregarLecciones(edicion);
		linux.agregarLecciones(archivos);
		devops.agregarCursos(linux);
		
	
		instituto1.agregarCategorias(programacion);
		instituto1.agregarCategorias(devops);
	

		//Usuarios
		Usuario usuario1=new Usuario(1,"Jules","jfeifer0@gov.uk",false);
		Usuario usuario2=new Usuario(2,"Eleonora","egladdish1@barnesandnoble.com",false);
		Usuario usuario3=new Usuario(3,"Wilbert","wklulik2@usnews.com",false);
		Usuario usuario4=new Usuario(4,"Jamey","jbowmer3@twitpic.com",true);
		Usuario usuario5=new Usuario(5,"Anson","acastiglio4@reference.com",true);
		Usuario usuario6=new Usuario(6,"Helena","hstubbe5@vinaora.com",false);
		Usuario usuario7=new Usuario(7,"Golda","glaborde6@irs.gov",false);
		Usuario usuario8=new Usuario(8,"Annmarie","amurty7@nydailynews.com",true);
		Usuario usuario9=new Usuario(9,"Amby","akeast8@ehow.com",true);
		Usuario usuario10=new Usuario(10,"Lazare","lmoxley9@fotki.com",true);
		
		instituto1.agregarUsuarioAListado(usuario1);
		instituto1.agregarUsuarioAListado(usuario2);
		instituto1.agregarUsuarioAListado(usuario3);
		instituto1.agregarUsuarioAListado(usuario4);
		instituto1.agregarUsuarioAListado(usuario5);
		instituto1.agregarUsuarioAListado(usuario6);
		instituto1.agregarUsuarioAListado(usuario7);
		instituto1.agregarUsuarioAListado(usuario8);
		instituto1.agregarUsuarioAListado(usuario9);
		instituto1.agregarUsuarioAListado(usuario10);
		//autores
		logica.setAutor(usuario1);
		react.setAutor(usuario2);
		linux.setAutor(usuario3);
		//suscriptores
		logica.agregarSuscriptores(usuario1);
		logica.agregarSuscriptores(usuario4);
		logica.agregarSuscriptores(usuario5);
		logica.agregarSuscriptores(usuario8);
		logica.agregarSuscriptores(usuario9);
		logica.agregarSuscriptores(usuario10);
		
		react.agregarSuscriptores(usuario2);
		react.agregarSuscriptores(usuario8);
		react.agregarSuscriptores(usuario6);
		
		//Sistema de inscripcion
		menuPrincipal(scanner,instituto1);
		scanner.close();
		
		
	}
		
		private static void menuPrincipal(Scanner scanner,Instituto instituto) {
			boolean salir=false;
			while(!salir) {
				System.out.println("------------------------------------------------------");
				System.out.println("\u001B[31m"+"\u001B[47m"+"****Bienvenido al sistema de Inscripción de cursos****"+"\u001B[0m");
				System.out.println("------------------------------------------------------");
				System.out.println("1.Agregar nuevo Usuario");
				System.out.println("2.Mostrar usuarios");
				System.out.println("3.Mostrar categorias");
				System.out.println("4.Mostrar cursos por categoría");
				System.out.println("5.Mostrar suscriptores por curso");
				System.out.println("6.Suscribirse a curso");
				System.out.println("0.Salir del sistema");
				System.out.println("------------------------------------------------------");
				System.out.print("Seleccione una opcion: ");
				int opcion=scanner.nextInt();
				if(opcion==1) {
					instituto.agregaNuevoUsuario(scanner);
				}else if(opcion==2) {
					instituto.mostrarUsuarios();
				}else if(opcion==3) {
					instituto.getCategorias();
				}else if(opcion==4) {
					System.out.print("¿Cual es el id de la categoria?: ");
					int categoria=scanner.nextInt();
					instituto.mostrarCursos(categoria);
				}else if(opcion==5) {
					System.out.print("¿Cual es el id de la categoria?: ");
					int idCategoria=scanner.nextInt();
					System.out.print("¿Cual es el id del curso?: ");
					int idCurso=scanner.nextInt();
					instituto.encontrarCategoria(idCategoria).mostrarSuscriptores(idCurso);
				}else if(opcion==6) {
					System.out.print("¿Cual es el id del usuario?: ");
					int idUsuario=scanner.nextInt();
					System.out.print("¿Cual es el id del curso?: ");
					int iDCurso=scanner.nextInt();
					String resultado=instituto.suscribirseACurso(idUsuario, iDCurso);
					System.out.println("------------------------");
					System.out.println("\033[1m"+resultado+"\033[1m");
				}else if(opcion==0) {
					System.out.println("Saliendo del programa");
					salir=true;					
				}else {
					System.out.println("Opción invalida.Intente nuevamente");
				}
			
			}
			
			
			
			
		}


	}
	
	


