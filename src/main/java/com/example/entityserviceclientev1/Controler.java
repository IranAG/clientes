package com.example.entityserviceclientev1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("clientes")
public class Controler {

    ArrayList<Cliente> lista = new ArrayList<>();
    @PostMapping("crear")
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        Cliente cliente1 = new Cliente(cliente.nombre, cliente.correo);
        lista.add(cliente1);
        cliente1.setId(lista.size());
        guardar();
        return new ResponseEntity<>(cliente1, HttpStatus.OK);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> crear(@PathVariable int id) {
        Cliente c1 = new Cliente();
        for (Cliente c : lista) {
            if (id == c.getId()) {
                c1 = c;
            }
        }
        return new ResponseEntity<>(c1, HttpStatus.OK);
    }

    @PutMapping("modificar")
    public ResponseEntity<?> modificar(@RequestBody Cliente cliente) {
        Cliente c2 = new Cliente();
        for (Cliente c : lista) {
            if (cliente.getId() == c.getId()) {
                c.setNombre(cliente.getNombre());
                c.setCorreo(cliente.getCorreo());
                c2 = c;
            }
        }
        guardar();
        return new ResponseEntity<>(c2, HttpStatus.OK);
    }

    @GetMapping("listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(lista.toString(), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Cliente c2 = new Cliente();
        int index = 0;
        for (Cliente c : lista) {
            if (id == c.getId()) {
                c2 = c;
                lista.remove(index);
            }
            index++;
        }
        guardar();
        return new ResponseEntity<>(c2, HttpStatus.OK);
    }


    public void guardar() {
        try {
            FileWriter jsonData = new FileWriter("./data");
            Scanner reader = new Scanner(lista.toString());
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                jsonData.write(data);
            }
            reader.close();
            jsonData.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public Controler() throws FileNotFoundException {
    }

    public String Controler() throws FileNotFoundException {
        File jasondata = new File("./data");
        Scanner reader = new Scanner(jasondata);
        String data = "";
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            System.out.println(data);
        }
        return data;
    }


}
