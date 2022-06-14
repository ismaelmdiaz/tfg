package com.dichotomy.back.service;

import com.dichotomy.back.entity.Producto;
import com.dichotomy.back.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public List<Producto> listarProductosPorMarca(String marca){
        return productoRepository.findByBrand(marca);
    }

    public Optional<Producto> obtenerPorId(int id){
        return productoRepository.findById(id);
    }
//
    public Optional<Producto> getByModel(String model){
        return productoRepository.findByModel(model);
    }
//
//    public void  save(Producto producto){
//        productoRepository.save(producto);
//    }
//
//    public void delete(int id){
//        productoRepository.deleteById(id);
//    }
//
    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }
//
//    public boolean existsByNombre(String nombre){
//        return productoRepository.existsByNombre(nombre);
//    }
}
