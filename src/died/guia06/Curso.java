package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() 
	{
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos, Integer creditosRequeridos)
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.log = new Registro();
		this.inscriptos = new ArrayList<Alumno>();
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
	}
	
	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public boolean inscribir(Alumno a) 
	{
			this.cupo -= 1;
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
			return true;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico o por nro de libreta
	 */
	public void imprimirInscriptos(String o) 
	{
		try 
		{
			Comparator<Alumno> comp = null;
			List<Alumno> listaOrdenada = inscriptos;
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			switch(o)
			{
			case "ALFABETICO":
				comp = (a1, a2) -> a1.getNombre().compareTo(a2.getNombre());
				Collections.sort(listaOrdenada, comp);
				for(Alumno unAlumno: listaOrdenada)
				{
					System.out.println("Nombre: "+unAlumno.getNombre() + " | Nro. de libreta: " +unAlumno.getnroLibreta());
				}
				break;
			case "LIBRETA":
				comp = (a1, a2) -> a1.getnroLibreta().compareTo(a2.getnroLibreta());
				Collections.sort(listaOrdenada, comp);
				for(Alumno unAlumno: listaOrdenada)
				{
					System.out.println("Nombre: "+unAlumno.getNombre() + " | Nro. de libreta: " +unAlumno.getnroLibreta());
				}
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean inscribirAlumno(Alumno a)
	{
		try
		{
			if(a.creditosObtenidos() >= this.creditosRequeridos)
			{
				if(this.cupo > 0)
				{
					if(a.cantidadMaterias(this.cicloLectivo) < 3)
					{
						inscribir(a);
						try
						{
							log.registrar(this, "inscribir ",a.toString());
						}
						catch(IOException e)
						{
							throw new RegistroAuditoriaException("Error de registro");
						}
						return true;
					}
					else
					{
						throw new Excepcion("El alumno ya tiene todas las materias de cursado regular");
					}
				}
				else
				{
					throw new Excepcion("El curso tiene el cupo cubierto");
				}
			}
			else
			{
				throw new Excepcion("El alumno no tiene los creditos requeridos");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Integer getCreditos()
	{
		return this.creditos;
	}

	public Integer getCicloLectivo()
	{
		return this.cicloLectivo;
	}
	
	public void imprimirCurso()
	{
		System.out.println("ID: " +this.id);
		System.out.println("Nombre: " +this.nombre);
		System.out.println("Ciclo lectivo: " +this.cicloLectivo);
		System.out.println("Cupo: " +this.cupo);
		System.out.println("Creditos: " +this.creditos);
		System.out.println("Creditos requeridos: " +this.creditosRequeridos);
		System.out.println("--------------------------------------------");
	}
}
