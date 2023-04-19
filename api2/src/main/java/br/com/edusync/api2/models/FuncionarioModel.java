package br.com.edusync.api2.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioModel {

    private String cpf;

    private String nome;

    private Integer idade;

    private LocalDate dataNascimento;

    private EmpresaModel empresa;

    private SalarioModel salario;
}
