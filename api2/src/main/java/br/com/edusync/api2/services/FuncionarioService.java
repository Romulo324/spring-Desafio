package br.com.edusync.api2.services;

import br.com.edusync.api2.models.FuncionarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {
    private List<FuncionarioModel> funcionarios = new ArrayList<>();

    public void adicionar(FuncionarioModel funcionarioQueSeraSalvo){
        funcionarios.add(funcionarioQueSeraSalvo);
    }

    public List<FuncionarioModel> listar(){
        return funcionarios;
    }

    public FuncionarioModel buscarPorCpf(String cpf){
        return funcionarios.stream().filter(f -> cpf.equals(f.getCpf())).findFirst().orElseThrow();
    }

    public void atualizar(String cpf, FuncionarioModel funcionario) {
        remove(cpf);
        funcionarios.add(funcionario);
    }

    public void remove(String cpf) {
        FuncionarioModel cpfPesquisa = buscarPorCpf(cpf);
        if (cpfPesquisa != null) {
            funcionarios.remove(cpfPesquisa);
        }
        funcionarios.remove(cpfPesquisa);
    }
}
