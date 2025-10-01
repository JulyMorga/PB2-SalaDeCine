package com.morga.candyBar;

public class Snack extends Producto {
	private Tamano tamano; 
	//El precio final tiene 20% de recargo si es grande y 15% de descuento si es pequeño.
	
	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, precioBase, stock);
		this.tamano = tamano;
	}

	@Override
	protected double calcularPrecioFinal() {
		
		switch (this.tamano) {
		case PEQUENO: {
			// Descuento
			return precioBase - (precioBase * 0.15);
			// precioBase  * 0.85;  // (1-0.15)
		}
		case GRANDE: {
			// Recargo
			return precioBase * 1.20;
			// (precioBase * 1) + precioBase * 0.20;
		}
		default:
			
		}
		return precioBase;
	}

}
