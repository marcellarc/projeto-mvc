package com.projeto.projeto_mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    FilmeDAO fdao;

    public void inserirFilme(Filme filme) {
        fdao.inserirFilme(filme);
    }

    public List<Filme> puxarTodosFilmes() {
        return Filme.converterVarios(fdao.puxarTodosFilmes());
    }

    public void atualizarFilme(int id, Filme novo) {
        fdao.atualizarFilme(id, novo);
    }

    public Filme puxarFilme(int id) {
        return Filme.converter(fdao.puxarFilme(id));
    }

    public void deletar(int id) {
        fdao.deletar(id);
    }

}
