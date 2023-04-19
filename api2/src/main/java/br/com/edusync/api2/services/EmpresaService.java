package br.com.edusync.api2.services;

import br.com.edusync.api2.models.EmpresaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    public List<EmpresaModel> empresas = new ArrayList<>();

    public void adicionar(EmpresaModel empresaQueSeraSalva) {
        empresas.add(empresaQueSeraSalva);
    }

    public List<EmpresaModel> listar() {
        return empresas;
    }

    public EmpresaModel buscarPorCnpj(String cnpj) {       //findFist achar o primeiro //ElseThrow de um erro
        return empresas.stream().filter(e -> cnpj.equals(e.getCnpj())).findFirst().orElseThrow();
    }

    public void atualizar(String cnpj, EmpresaModel empresa) {
        EmpresaModel empresaPesquisar = buscarPorCnpj(cnpj);
    }

    public void remove(String cnpj) {
        EmpresaModel cnpjPesquisar = buscarPorCnpj(cnpj);
        if (cnpjPesquisar != null) {
            empresas.remove(cnpj);
        }
        empresas.remove(cnpjPesquisar);
    }
}
