package com.api.estoque.api_crud.controller;

import com.api.estoque.api_crud.entity.Boleto;
import com.api.estoque.api_crud.Exceptions.BoletoNaoAdicionado;
import com.api.estoque.api_crud.Service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping
    public ModelAndView viewListaBoleto() {
        ModelAndView mv = new ModelAndView("/boleto/listaBoletos");
        List<Boleto> boletos = boletoService.listarBoleto();
        mv.addObject("boletos", boletos);
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView viewBoletoAdicioanar() {
        ModelAndView mv = new ModelAndView("/boleto/addBoleto");
        return mv;
    }

    @PostMapping("/api/salvar")
    public String viewAddBoleto(@ModelAttribute  Boleto boleto) {
        ModelAndView mv = new ModelAndView("/boleto/addBoleto");
        try {
            boletoService.adicinarBoleto(boleto);
        } catch (BoletoNaoAdicionado e) {
            throw new RuntimeException(e);
        }
        return "redirect:/boleto/adicionar";
    }

    @GetMapping("/api/deletar/{id}")
    public String viewListaBoleto(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("/boleto/listaBoleto");
        try {
            boletoService.apagarBoleto(id);
            return "redirect:/boleto";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
