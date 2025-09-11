package com.morga.saladecine;

public class PeliculaComedia extends Pelicula{

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de Comedia"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las peliculas de accion se caracterizan por tener un alto grado de violancia, explosibos impresionantes y heroes que salvan al mundo.";
		return sinopsis;
		
	}

}
