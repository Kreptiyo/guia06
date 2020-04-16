package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursoTest {

	@Test
	void testInscribirAlumno_BIEN() 
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		boolean esperado = c1.inscribirAlumno(a1);
		assertTrue(esperado);
	}
	
	@Test
	void testInscribirAlumno_faltaDeCupos()
	{
		Curso c1 = new Curso(1, "AMI", 2020, 0, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		boolean esperado = c1.inscribirAlumno(a1);
		assertFalse(esperado);
	}
	
	@Test
	void testInscribirAlumno_faltaDeCreditos()
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 10);
		Alumno a1 = new Alumno("Ariel", 25703);
		boolean esperado = c1.inscribirAlumno(a1);
		assertFalse(esperado);
	}
	
	@Test
	void testInscribirAlumno_MaximaCantidadDeMateriasRegular()
	{
		Curso c1 = new Curso(1, "DIED", 2020, 10, 10, 0);
		Curso c2 = new Curso(1, "DISEÑO", 2020, 10, 10, 0);
		Curso c3 = new Curso(1, "MATEMATICA SUPERIOR", 2020, 10, 10, 0);
		Curso c4 = new Curso(1, "COMUNICACION", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		c1.inscribirAlumno(a1);
		c2.inscribirAlumno(a1);
		c3.inscribirAlumno(a1);
		boolean esperado = c4.inscribirAlumno(a1);
		assertFalse(esperado);
	}

}
