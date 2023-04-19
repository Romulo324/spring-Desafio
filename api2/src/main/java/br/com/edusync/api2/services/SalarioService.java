package br.com.edusync.api2.services;

import br.com.edusync.api2.models.SalarioModel;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SalarioService {
    public List<SalarioModel> salarios = new ArrayList<>();

    public void adicionarSalario(SalarioModel salarioSalvo) {
        salarios.add(salarioSalvo);
    }
    public SalarioModel buscarPorCodigo(Integer codigo){
        return salarios.stream().filter(s -> codigo.equals(s.getCodigo())).findFirst().orElseThrow();
    }
    public void adicionar (SalarioModel salarioPesquisa){
        salarios.add(salarioPesquisa);
    }
    public void atualizar(Integer codigo, SalarioModel salario){
        SalarioModel salarioPesquisar = buscarPorCodigo(codigo);
        if (salarioPesquisar != null) {
            salarios.remove(salarioPesquisar);
        }
        salarios.add(salarioPesquisar);
    }
    public List<SalarioModel> listar() {
        return salarios;
    }
    public void remove(Integer codigo) {
        SalarioModel codigoPesquisa= buscarPorCodigo(codigo);
        if (codigoPesquisa != null){
            salarios.remove(codigo);
        }
        salarios.remove(codigoPesquisa);
    }

}
