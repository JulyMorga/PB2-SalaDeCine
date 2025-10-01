package com.morga.candyBar;

public class Bebida extends Producto{
	Contenedor contenedor;
	
	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, precioBase, stock);
		this.contenedor = contenedor;
	}

	@Override
	protected double calcularPrecioFinal() {
		double precioFinal = this.precioBase;
		// El precio final tiene +10% de recargo si su contenedor es una botella.
		if(this.contenedor == Contenedor.BOTELLA)
			 precioFinal *= 1.1;
		
		return precioFinal;
	}
	
}
