package io.azzlo.e_commerce.service;


import io.azzlo.e_commerce.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> buscarProductos();
    Producto guardar (Producto producto);
    Producto encontrarPorId(Long idProducto);
    void eliminar(Long idProducto);
}
