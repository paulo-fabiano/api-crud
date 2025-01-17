package com.api.estoque.api_crud.controller;

import com.api.estoque.api_crud.entity.Cliente;
import com.api.estoque.api_crud.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/api/adicionar")
    public String criarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        try {
            clienteService.criarCliente(cliente);
            redirectAttributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao adicionar cliente: " + e.getMessage());
        }
        return "redirect:/cliente/adicionar";
    }

    @GetMapping
    public String viewCliente(Model model) {
        List<Cliente> allClientes = clienteService.listarClientes();
        model.addAttribute("clientes", allClientes);
        return "/cliente/cliente";
    }

    @GetMapping("/adicionar")
    public String viewAdicionar() {
        return "cliente/adicionar";
    }

    @GetMapping("/atualizar/{id}")
    public String viewAtualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cliente", clienteService.listarCliente(id));
        return "cliente/atualizar";
    }

//    @GetMapping("/atualizar/{id}")
//    public String viewAtualizar(@PathVariable Long id, @ModelAttribute Cliente cliente) throws ClienteNaoEncontrado {
//        ModelAndView mv = new ModelAndView();
//        try {
//            Cliente cliente = clienteService.listarCliente(id);
//            mv.addObject("cliente", cliente);
//        } catch (Exception e) {
//            mv.addObject("mensagemErro", "Erro ao atualizar o item: " + e.getMessage());
//        }
//        return "cliente/atualizar";
//    }

    @PostMapping("/api/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            clienteService.deletarCliente(id);
            mv.addObject("mensagem", "Cliente excluído com sucesso");
        } catch (Exception e) {
            mv.addObject("mensagemErro", "Erro ao excluir cliente: " + e.getMessage());
        }
        return "redirect:/cliente";
    }

}
