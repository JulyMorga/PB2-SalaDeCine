package com.morga.saladecine;

public class SalaCine {
	private Asiento[][] butacas;
	private Pelicula pelicula;
	
	
	public SalaCine(int fila, int columna) {
		this.butacas = new Asiento[fila][columna];
		
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				this.butacas[i][j] = new Asiento();
			}
		}
	}
	
	public Asiento[][] getButacas(){
		return butacas;
	}
	
	
	public int contarAsientosOcupados() {
		int contador = 0;
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if(this.butacas[i][j].estaOcupado())
					contador++;
				
			}
		}
		return contador;
	}
	
	public int getTotalAsientos() {
		return butacas.length * butacas[0].length;
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPeliculaActual() {
		return pelicula;
	}
	
	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {
		
		if(butacas[fila][columna].estaOcupado())
			return false;
		
		if(this.pelicula.getEdadMinima() > edad)
			return false;
		
		if(nombreComprador == null)
			return false;
		
		
		butacas[fila][columna].ocupar(nombreComprador);
		return true;
	}
	
	public String getTitulo() {
		return pelicula.getTitulo();
	}
	
	
	public boolean liberarAsiento(int fila, int columna){
		if(fila < 0 || columna < 0)
			return false;
		
		if(fila <= butacas.length && columna <= butacas[0].length ) {
			butacas[fila][columna].liberar();
			return true;
		}
		return false;		
	}
}
