package com.projeto.projeto_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.projeto_mvc.model.Filme;
import com.projeto.projeto_mvc.model.FilmeService;

@Controller
public class FilmeController {

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
        model.addAttribute("filme", new Filme());
        model.addAttribute("titulo", "Cadastrar Filme");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");

        return "formulario";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Filme filme) {
        FilmeService fs = ctx.getBean(FilmeService.class);
        fs.inserirFilme(filme);
        return "redirect:/sucesso?proximo=/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        FilmeService fs = ctx.getBean(FilmeService.class);
        List<Filme> lista = fs.puxarTodosFilmes();
        model.addAttribute("filmes", lista);
        return "listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        FilmeService fs = ctx.getBean(FilmeService.class);
        Filme velho = fs.puxarFilme(id);
        model.addAttribute("filme", velho);
        model.addAttribute("titulo", "Editar Filme");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, @ModelAttribute Filme filme, @PathVariable int id) {
        FilmeService fs = ctx.getBean(FilmeService.class);
        fs.atualizarFilme(id, filme);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        FilmeService fs = ctx.getBean(FilmeService.class);
        fs.deletar(id);
        return "redirect:/listar";
    }
}
