package com.projeto.projeto_mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filme {

    private int id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private int duracao;
    private String status;

    //INICIALIZAR O FORM
    public Filme() {
    }

    // CADASTRO (sem id)
    public Filme(String titulo, String diretor, int anoLancamento, String genero, int duracao, String status) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
        this.status = status;
    }

    // MOSTRAR (com id)
    public Filme(int id, String titulo, String diretor, int anoLancamento, String genero, int duracao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // CONVERSÃO DE UM MAPA
    public static Filme converter(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        String titulo = (String) registro.get("titulo");
        String diretor = (String) registro.get("diretor");
        int ano = (Integer) registro.get("anoLancamento");
        String genero = (String) registro.get("genero");
        int duracao = (Integer) registro.get("duracao");
        String status = (String) registro.get("status");

        return new Filme(id, titulo, diretor, ano, genero, duracao, status);
    }

    // CONVERSÃO DE VÁRIOS REGISTROS
    public static List<Filme> converterVarios(List<Map<String, Object>> registros) {
        ArrayList<Filme> lista = new ArrayList<>();
        for (Map<String, Object> reg : registros) {
            lista.add(converter(reg));
        }
        return lista;
    }

}
