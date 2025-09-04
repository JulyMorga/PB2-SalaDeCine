package com.morga.saladecine;

public abstract class Pelicula {
	 String titulo;
	 int duracion; 
	 int edadMinima;
	 
	public Pelicula(String titulo, int duracion, int edadMinima) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}
	
	public abstract void mostrarSinopsis();

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}
	
}
