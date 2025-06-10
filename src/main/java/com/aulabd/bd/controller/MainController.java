/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aulabd.bd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aulabd.bd.model.Cliente;
import com.aulabd.bd.model.ClienteService;

@Controller
public class MainController {
    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("titulo", "CADASTRO DE CLIENTES");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");

        return "formulario";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Cliente cli) {
        ClienteService cs = ctx.getBean(ClienteService.class);
        cs.inserirCLiente(cli);
        return "redirect:listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        ClienteService cs = ctx.getBean(ClienteService.class);
        List<Cliente> lista = cs.puxarTodosClientes();
        model.addAttribute("clientes", lista);
        return "listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        ClienteService cs = ctx.getBean(ClienteService.class);
        Cliente velho = cs.puxarCliente(id);
        model.addAttribute("cliente", velho);
        model.addAttribute("titulo", "EDITAR CLIENTES");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, @ModelAttribute Cliente cli, @PathVariable int id) {
        ClienteService cs = ctx.getBean(ClienteService.class);
        cs.atualizarCliente(id, cli);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ClienteService cs = ctx.getBean(ClienteService.class);
        cs.deletar(id);
        return "redirect:/listar";
    }
}
