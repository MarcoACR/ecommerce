package io.azzlo.e_commerce.service.serviceImpl;

import io.azzlo.e_commerce.model.Producto;
import io.azzlo.e_commerce.reposiroty.ProductoRepository;
import io.azzlo.e_commerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository repositoryProduc;

    @Override
    public List<Producto> buscarProductos() {
        return repositoryProduc.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        repositoryProduc.save(producto);
        return producto;

    }

    @Override
    public Producto encontrarPorId(Long idProducto) {
        if(repositoryProduc.findById(idProducto).isPresent()){
            return repositoryProduc.findById(idProducto).get();
        }
        return null;

    }

    @Override
    public void eliminar(Long idProducto) {
        Producto eliminarProducto = encontrarPorId(idProducto);
        repositoryProduc.delete(eliminarProducto);
    }
}
