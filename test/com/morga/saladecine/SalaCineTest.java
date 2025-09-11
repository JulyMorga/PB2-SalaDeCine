package com.morga.saladecine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalaCineTest {
	
	Pelicula peliculas[] = new Pelicula[4];
	SalaCine sala1;
	
	@BeforeEach      // o @Before en junit4
	void metodoQueSeEjecutaAntesDeTodo() {
		
	// Películas de Acción
		peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
		peliculas[1] = new PeliculaAccion("Misión Imposible", 150, 13);
		peliculas[2] = new PeliculaAccion("John Wick 4", 169, 16);
		peliculas[3] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
		
		sala1 = new SalaCine(2, 3);
	}
	
	
	@Test
	void crearSalaOk() {
		
		PeliculaAccion pelicomparacion = new PeliculaAccion("Piratas del Caribe 1", 200, 14);//  (peli1= 0x1235)
		
		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(2, sala1.getButacas().length);
		assertEquals(3, sala1.getButacas()[0].length);
		
		assertEquals(pelicomparacion, sala1.getPeliculaActual());
		
	}
	
	@Test
	void venderBoletoExitoso() {		
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 14, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 2, 16, "Julian Morga");
		assertTrue(venta1);
		assertTrue(venta2);
		
		
	}
	
	
	@Test
	void venderBoletoNoExitosoPorqueSeIntentaVenderYaVendido() {
		
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		assertTrue(venta1);
		assertFalse(venta2);
	}
	
	
	@Test
	void venderBoletoNoExitosoPorqueEdadMinimaNoCumplida() {
			
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 12, "Julian Morga");
		boolean venta3 = sala1.venderBoleto(0, 1, -5, "Julian Morga");
	
		assertFalse(venta1);
		assertFalse(venta3);
	}
	
	
	@Test
	void obtenerTotalAscientosTest() {
		SalaCine sala1 = new SalaCine(2, 3);
		assertEquals(6, sala1.getTotalAsientos());
		
	}
	
	@Test
	void contarAsientosOcupadosTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");
		
		assertEquals(3, sala1.contarAsientosOcupados());
	}
	
	
}

