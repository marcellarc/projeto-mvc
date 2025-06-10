/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirCliente(Cliente cli) {
        String sql = "INSERT INTO cliente(nome, cpf) VALUES(?, ?)";
        Object[] parametros = new Object[2];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getCpf();

        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosClientes() {
        String sql = "SELECT * FROM cliente;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarCliente(int id, Cliente novo) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ? WHERE id = ?";
        Object[] parametros = new Object[3];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getCpf();
        parametros[2] = id;

        jdbc.update(sql, parametros);
    }

    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        jdbc.update(sql, id);
    }
}
