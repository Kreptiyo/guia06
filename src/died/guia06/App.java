package died.guia06;

public class App {

	public static void main(String[] args) 
	{
		Curso curso = new Curso(1, "AMI", 2020, 10, 0, 0);
		Curso curso2 = new Curso(2, "AMII", 2020, 10, 0, 0);
		Curso curso3 = new Curso(3, "FISICAI", 2020, 10, 0, 0);
		Curso curso4 = new Curso(4, "FISICAII", 2020, 10, 0, 0);
		Alumno alumno = new Alumno("Zara", 29703);
		Alumno alumno2 = new Alumno("Ariel", 25703);
		Alumno alumno3 = new Alumno("Matias", 27703);
		curso.inscribirAlumno(alumno);
		curso.inscribirAlumno(alumno2);
		curso.inscribirAlumno(alumno3);
		curso.imprimirInscriptos("ALFABETICO");

		
	}
}
