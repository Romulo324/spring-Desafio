package br.com.edusync.api2.controllers;

import br.com.edusync.api2.models.FuncionarioModel;
import br.com.edusync.api2.services.EmpresaService;
import br.com.edusync.api2.services.FuncionarioService;
import br.com.edusync.api2.services.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;
    @Autowired
    private EmpresaService conectar;

    @Autowired
    private SalarioService conectarS;

    @GetMapping(value = "/lista")
    public ResponseEntity listarFuncionario(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity funcionarioAdicionado(@RequestParam Integer codigo, @RequestParam String cnpj,
                                                @RequestBody FuncionarioModel funcionario) {
        funcionario.setEmpresa(conectar.buscarPorCnpj(cnpj));
        funcionario.setSalario(conectarS.buscarPorCodigo(codigo));
        service.adicionar(funcionario);
        return  new ResponseEntity(funcionario, HttpStatus.CREATED);
    }
    @PutMapping(value = "/alterar/{cpf}")
    public ResponseEntity alterar(@PathVariable String cpf,@RequestBody FuncionarioModel funcionario){
        service.atualizar(cpf, funcionario);
        return new ResponseEntity(cpf, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{cpf}")
    public ResponseEntity deletar(@PathVariable String cpf){
        service.remove(cpf);
        return  new ResponseEntity(HttpStatus.OK);
    }
}
