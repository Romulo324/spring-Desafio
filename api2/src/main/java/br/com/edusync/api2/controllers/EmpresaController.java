package br.com.edusync.api2.controllers;

import br.com.edusync.api2.models.EmpresaModel;
import br.com.edusync.api2.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    @RestController
    @RequestMapping(value = "/empresa")
    public class EmpresaController {

        @Autowired
        private EmpresaService service;

        @GetMapping(value = "/lista")
        public ResponseEntity listarValorSalarial(){
            return new ResponseEntity(service.listar(), HttpStatus.OK);
        }
        @PostMapping(value = "/add")
        public ResponseEntity empresaAdicionada(@RequestBody EmpresaModel empresa){
            service.adicionar(empresa);
            return new ResponseEntity(empresa, HttpStatus.CREATED);
        }
        @PutMapping(value = "/alterar/{cnpj}")
        public ResponseEntity alterar(@PathVariable String cnpj , @RequestBody EmpresaModel empresa){
            service.atualizar(cnpj, empresa);
            return new ResponseEntity(empresa, HttpStatus.OK);
        }
        @DeleteMapping(value = "/deletar/{cnpj}")
        public ResponseEntity deletar(@PathVariable String cnpj){
            service.remove(cnpj);
            return new ResponseEntity(HttpStatus.OK);
        }
}
