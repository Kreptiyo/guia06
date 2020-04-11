package died.guia06;

public class App {

	public static void main(String[] args) 
	{
		Curso curso = new Curso(1, "AMI", 2020, 10, 10, 0);
		Curso curso2 = new Curso(2, "AMII", 2020, 10, 0, 0);
		Curso curso3 = new Curso(3, "FISICAI", 2020, 10, 0, 0);
		Curso curso4 = new Curso(4, "FISICAII", 2020, 10, 0, 0);
		Alumno alumno = new Alumno("Carlos", 24703);
		curso.inscribir(alumno);
		curso2.inscribir(alumno);
		curso3.inscribir(alumno);
		curso4.inscribir(alumno);
		System.out.println("cant:" +alumno.cantidadMaterias(2020));
		alumno.aprobar(curso);
		System.out.println("cant:" +alumno.creditosObtenidos());
	}
}
