/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aulabd.bd.model;

import java.util.Map;
import java.util.List; 
import java.util.ArrayList; 

import org.springframework.beans.factory.ListableBeanFactory;

/**
 *
 * @author lab53
 */
public class Cliente {
    private int id;
    private String nome, cpf;

    //INICIALIZAR O FORM
    public Cliente() {}

    //CADASTRO
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    //MOSTRAR
    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Cliente converter(Map<String,Object> registro) {
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String cpf = (String) registro.get("cpf");

        return new Cliente(id, nome, cpf);
    }

    public static List<Cliente> converterVarios(List<Map<String,Object>> registros) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        for(Map<String, Object> reg : registros) {
            lista.add(converter(reg));
        }
        return lista;
    }
}
