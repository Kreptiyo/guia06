package died.guia06;

public class App {

	public static void main(String[] args) 
	{
		Curso curso1 = new Curso(1, "AM I", 2020, 5, 10, 0);
		Curso curso2 = new Curso(1, "AM II", 2020, 5, 10, 10);
		Curso curso3 = new Curso(1, "FISICA I", 2020, 5, 10, 0);
		Curso curso4 = new Curso(1, "FISICA II", 2020, 5, 10, 10);
		Curso curso5 = new Curso(1, "MATEMATICA DISCRETA", 2020, 5, 10, 0);
		Alumno alumno1 = new Alumno("Juan Manuel Garcia", 29703);
		Alumno alumno2 = new Alumno("Ariel Senosiain", 25703);
		Alumno alumno3 = new Alumno("Carlos Bianchi", 27703);
		Alumno alumno4 = new Alumno("Sebastian Gonzales", 22703);
		Alumno alumno5 = new Alumno("Martin Arevalo", 24503);
		Alumno alumno6 = new Alumno("Mateo Pratto", 14503);
		curso1.inscribirAlumno(alumno1);
		curso1.inscribirAlumno(alumno2);
		curso1.inscribirAlumno(alumno3);
		curso1.inscribirAlumno(alumno4);
		curso1.inscribirAlumno(alumno5);
		curso1.imprimirInscriptos("LIBRETA");
		curso1.inscribirAlumno(alumno6);
		curso2.inscribirAlumno(alumno1);
		alumno1.aprobar(curso1);
		curso2.inscribirAlumno(alumno1);
		curso3.inscribirAlumno(alumno1);
		curso4.inscribirAlumno(alumno1);
		curso5.inscribirAlumno(alumno1);
		curso5.imprimirInscriptos("LIBRETA");
	}
}
