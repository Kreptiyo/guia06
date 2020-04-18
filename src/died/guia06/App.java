package died.guia06;

public class App {

	public static void main(String[] args) 
	{
		Curso curso = new Curso(1, "AM I", 2020, 5, 10, 0);
		Curso curso2 = new Curso(2, "AM II", 2020, 5, 20, 10);
		Curso curso3 = new Curso(3, "FISICA I", 2020, 5, 10, 0);
		Curso curso4 = new Curso(4, "FISICA II", 2020, 5, 20, 10);
		Alumno alumno1 = new Alumno("Juan Manuel Garcia", 29703);
		Alumno alumno2 = new Alumno("Ariel Senosiain", 25703);
		Alumno alumno3 = new Alumno("Carlos Bianchi", 27703);
		Alumno alumno4 = new Alumno("Sebastian Gonzales", 22703);
		Alumno alumno5 = new Alumno("Martin Arevalo", 24503);
		Alumno alumno6 = new Alumno("Mateo Pratto", 14503);
		curso.inscribirAlumno(alumno1);
		curso.inscribirAlumno(alumno2);
		curso.inscribirAlumno(alumno3);
		curso.inscribirAlumno(alumno4);
		curso.inscribirAlumno(alumno5);
		curso.inscribirAlumno(alumno6);
		curso.imprimirInscriptos("ALFABETICO");
		System.out.println("-----------------------------------------------");
		curso.imprimirInscriptos("LIBRETA");
		System.out.println("-----------------------------------------------");
		alumno1.aprobar(curso);
		curso2.inscribirAlumno(alumno1);
		alumno1.aprobar(curso2);
		curso2.imprimirInscriptos("ALFABETICO");
		
	}
}
