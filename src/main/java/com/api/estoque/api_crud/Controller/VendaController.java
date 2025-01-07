package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Venda.VendaEntity;
import com.api.estoque.api_crud.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

//    @GetMapping
//    public ModelAndView viewVenda() {
//        ModelAndView mv = new ModelAndView("/venda/listaVendas");
//        List<VendaEntity> vendas = vendaService.listarVendas();
//        return mv;
//    }

    @PostMapping("/api")
    public void registrarVenda(@RequestBody VendaEntity vendaEntity) {
        vendaService.registrarVenda(vendaEntity);
    }

    @GetMapping("/adicionar")
    public ModelAndView viewAddVenda() {
        ModelAndView mv = new ModelAndView("/venda/addVenda");
        return mv;
    }

}
