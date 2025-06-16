package com.projeto.projeto_mvc.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class FilmeDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirFilme(Filme filme) {
        String sql = "INSERT INTO filme(titulo, diretor, anoLancamento, genero, duracao, status) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] parametros = new Object[6];
        parametros[0] = filme.getTitulo();
        parametros[1] = filme.getDiretor();
        parametros[2] = filme.getAnoLancamento();
        parametros[3] = filme.getGenero();
        parametros[4] = filme.getDuracao();
        parametros[5] = filme.getStatus();

        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> puxarTodosFilmes() {
        String sql = "SELECT * FROM filme;";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> puxarFilme(int id) {
        String sql = "SELECT * FROM filme WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarFilme(int id, Filme novo) {
        String sql = "UPDATE filme SET titulo = ?, diretor = ?, anoLancamento = ?, genero = ?, duracao = ?, status = ? WHERE id = ?";
        Object[] parametros = new Object[7];
        parametros[0] = novo.getTitulo();
        parametros[1] = novo.getDiretor();
        parametros[2] = novo.getAnoLancamento();
        parametros[3] = novo.getGenero();
        parametros[4] = novo.getDuracao();
        parametros[5] = novo.getStatus();
        parametros[6] = id;

        jdbc.update(sql, parametros);
    }

    public void deletar(int id) {
        String sql = "DELETE FROM filme WHERE id = ?";
        jdbc.update(sql, id);
    }

}
