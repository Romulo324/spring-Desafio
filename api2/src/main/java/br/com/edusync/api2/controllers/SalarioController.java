package br.com.edusync.api2.controllers;

import br.com.edusync.api2.models.SalarioModel;
import br.com.edusync.api2.services.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/salario")
public class SalarioController {
    @Autowired
    private SalarioService service;

    @GetMapping()
    public ResponseEntity listarTodos(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @GetMapping(value = "/{codigo}")
    public ResponseEntity listarPorCodigo(@PathVariable Integer codigo){
        return new ResponseEntity(service.buscarPorCodigo(codigo), HttpStatus.OK);
    }
    @PostMapping(value = "/novo")
    public ResponseEntity novoSalario(@RequestBody SalarioModel salario ){
        service.adicionar(salario);
        return new ResponseEntity(salario, HttpStatus.CREATED);
    }
    @PutMapping(value = "alterar/{codigo}")
    public ResponseEntity alterar (@PathVariable Integer codigo, @RequestBody SalarioModel salario){
        service.atualizar(codigo, salario);
        return new ResponseEntity(salario, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{codigo}")
    public ResponseEntity deletar(Integer codigo){
        service.remove(codigo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
