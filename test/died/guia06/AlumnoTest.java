package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testCreditosObtenidos() 
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		c1.inscribirAlumno(a1);
		a1.aprobar(c1);
		Integer esperado = 10;
		assertEquals(esperado, a1.creditosObtenidos());
	}


	@Test
	void testAprobar() 
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		c1.inscribirAlumno(a1);
		boolean esperado = a1.aprobar(c1);
		assertTrue(esperado);
	}

	@Test
	void testInscripcionAceptada() 
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		boolean esperado = a1.inscripcionAceptada(c1);
		assertTrue(esperado);
	}
	
	@Test
	void testNoAprobar()
	{
		Curso c1 = new Curso(1, "AMI", 2020, 10, 10, 0);
		Curso c2 = new Curso(1, "AMI2", 2020, 10, 10, 0);
		Alumno a1 = new Alumno("Ariel", 25703);
		a1.inscripcionAceptada(c1);
		boolean esperado = a1.aprobar(c2);
		assertFalse(esperado);
	}
	
}
