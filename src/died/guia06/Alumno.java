package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno 
{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public Integer creditosObtenidos() 
	{
		Integer creditos = 0;
		for(Curso unCurso: aprobados)
		{
			creditos += unCurso.getCreditos();
		}
		return creditos;
	}

	public boolean aprobar(Curso c) 
	{
		if(this.cursando.contains(c))
		{
			this.aprobados.add(c);
			this.cursando.remove(c);
			return true;
		}
		else
		{
			System.out.println("El alumno no se encuentra en este curso");
			return false;
		}
		
	}

	public boolean inscripcionAceptada(Curso c) 
	{
		this.cursando.add(c);
		System.out.println("El alumno se inscribio correctamente");
		return true;
	}
	
	public Boolean equals(Alumno a) 
	{
		if(this.nroLibreta == a.nroLibreta)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Integer cantidadMaterias(Integer cicloLectivo)
	{
		Integer cantidad = 0;
		for(Curso unCurso: cursando)
		{
			if(unCurso.getCicloLectivo().equals(cicloLectivo))
			{
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public String toString()
	{
		return "Nombre: " + this.nombre+ " | Nro. de libreta: " + this.nroLibreta;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Integer getnroLibreta()
	{
		return this.nroLibreta;
	}
	
	public void imprimirCursando()
	{
		for(Curso unCurso: cursando)
		{
			unCurso.imprimirCurso();
		}
	}
	
	public void imprimirAprobados()
	{
		for(Curso unCurso: aprobados)
		{
			unCurso.imprimirCurso();
		}
	}
}
