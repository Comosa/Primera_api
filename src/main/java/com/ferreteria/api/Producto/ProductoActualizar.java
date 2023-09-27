package com.ferreteria.api.Producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoActualizar(
		@NotNull
		Long id,
		@NotBlank
		String nombre,
		@NotBlank
		String descripcion,
		@NotBlank
		int precio,
		@NotBlank
		int cantidad
		) {

}
