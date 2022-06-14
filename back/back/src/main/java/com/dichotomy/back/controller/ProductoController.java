package com.dichotomy.back.controller;

import com.dichotomy.back.dto.MensajeDto;
import com.dichotomy.back.dto.ProductoDto;
import com.dichotomy.back.entity.Producto;
import com.dichotomy.back.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listaproductos")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> list = productoService.listarProductos();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){

        if(!productoService.existsById(id))
            return new ResponseEntity(new MensajeDto("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.obtenerPorId(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<Producto> getByBrand(@PathVariable("marca") String marca){

        List<Producto> lista = productoService.listarProductosPorMarca(marca);
        return new ResponseEntity(lista, HttpStatus.OK);
    }
//
//    @GetMapping("/detailname/{nombre}")
//    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
//        if(!productoService.existsByNombre(nombre))
//            return new ResponseEntity(new MensajeDto("no existe"), HttpStatus.NOT_FOUND);
//        Producto producto = productoService.getByNombre(nombre).get();
//        return new ResponseEntity(producto, HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
//        if(StringUtils.isBlank(productoDto.getModel()))
//            return new ResponseEntity(new MensajeDto("el modelo es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productoDto.getPrice()==null || productoDto.getPrice()<0 )
//            return new ResponseEntity(new MensajeDto("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productoService.existsByModel(productoDto.getModel()))
//            return new ResponseEntity(new MensajeDto("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        Producto producto = new Producto(productoDto.getModel(), productoDto.getPrecio());
//        productoService.save(producto);
//        return new ResponseEntity(new MensajeDto("producto creado"), HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
//        if(!productoService.existsById(id))
//            return new ResponseEntity(new MensajeDto("no existe"), HttpStatus.NOT_FOUND);
//        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
//            return new ResponseEntity(new MensajeDto("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(productoDto.getNombre()))
//            return new ResponseEntity(new MensajeDto("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
//            return new ResponseEntity(new MensajeDto("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//
//        Producto producto = productoService.getOne(id).get();
//        producto.setNombre(productoDto.getNombre());
//        producto.setPrecio(productoDto.getPrecio());
//        productoService.save(producto);
//        return new ResponseEntity(new MensajeDto("producto actualizado"), HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id")int id){
//        if(!productoService.existsById(id))
//            return new ResponseEntity(new MensajeDto("no existe"), HttpStatus.NOT_FOUND);
//        productoService.delete(id);
//        return new ResponseEntity(new MensajeDto("producto eliminado"), HttpStatus.OK);
//    }


}
