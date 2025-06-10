/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aulabd.bd.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteDAO cdao;

    public void inserirCLiente(Cliente cli) {
        cdao.inserirCliente(cli);
    }

    public List<Cliente> puxarTodosClientes() {
        return Cliente.converterVarios(cdao.puxarTodosClientes());
    }

    public void atualizarCliente(int id, Cliente novo) {
        cdao.atualizarCliente(id, novo);
    }

    public Cliente puxarCliente(int id) {
        return Cliente.converter(cdao.puxarCliente(id));
    }

    public void deletar(int id) {
        cdao.deletar(id);
    }
}
