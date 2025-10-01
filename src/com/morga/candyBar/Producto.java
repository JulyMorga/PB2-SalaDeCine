package com.morga.candyBar;

public abstract class Producto {
	String nombre;
	double precioBase;
	int Stock;
	
	protected abstract double calcularPrecioFinal();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public Producto(String nombre, double precioBase, int stock) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		Stock = stock;
	}
	
	

}
