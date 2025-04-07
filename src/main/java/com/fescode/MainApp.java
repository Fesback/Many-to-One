package com.fescode;

import com.fescode.model.Categoria;
import com.fescode.model.Producto;
import com.fescode.model.TipoCategoria;
import com.fescode.service.CategoriaService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        CategoriaService service = new CategoriaService();

        //Insertando categorias y productos
        Categoria categoriaNueva = new Categoria(TipoCategoria.SEGUNDA_MANO);
        Producto producto = new Producto("Mesa");
        Producto producto2 = new Producto("Silla");
        categoriaNueva.agregarProducto(producto);
        categoriaNueva.agregarProducto(producto2);
        service.crearCategoria(categoriaNueva);



        List<Categoria> categorias = service.getCategoriaProductos();
        System.out.println("Numero de categorias recuperadas: " + categorias.size());
        categorias.forEach(c -> {
            System.out.println("Categoria: " + c.getTipoCategoria());
            System.out.println("******************");
            c.getProductos().forEach(p -> {
                System.out.println("Producto: " + p.getNombre()); // listado
            });

        });

    }
}
