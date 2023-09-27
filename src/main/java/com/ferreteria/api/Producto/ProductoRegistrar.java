package com.ferreteria.api.Producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoRegistrar(
		@NotBlank
		String nombre,
		@NotBlank
		String descripcion,
		@NotNull
		int precio,
		@NotNull
		int cantidad
		) {

}
