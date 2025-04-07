package com.fescode.service;

import com.fescode.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CategoriaService {
    private final EntityManagerFactory factory;

    public CategoriaService() {
        this.factory = Persistence.createEntityManagerFactory("ManyToOnePU");
    }

    public void crearCategoria(Categoria categoria){
        EntityManager manager = factory.createEntityManager();
        try{
            manager.getTransaction().begin();
            manager.persist(categoria);
            manager.getTransaction().commit();
        }catch (Exception e){
            if(manager.getTransaction().isActive()){
                manager.getTransaction().rollback();
            }
            throw new RuntimeException();
        }finally {
            manager.close();
        }
    }

    //LiSTAR CATEGORIAS
    public List<Categoria> getCategoriaProductos(){
        EntityManager manager = factory.createEntityManager();
        try{
            String query = "SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.productos";
            return manager.createQuery(query, Categoria.class).getResultList();
        }finally{
            manager.close();
        }
    }

    public void cerrar(){
        factory.close();
    }
}
