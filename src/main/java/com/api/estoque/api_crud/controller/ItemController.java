package com.api.estoque.api_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/")
public class ItemController {

//    @Autowired
//    private ItemService itemService;
//
//    /*
//        Controller que cria itens
//     */
//
//    @PostMapping("item")
//    public String criarItem(ItemEntity itemEntity, RedirectAttributes redirectAttributes) {
//        ModelAndView mv = new ModelAndView();
//        try {
//            itemService.salvarItem(itemEntity);
//            redirectAttributes.addFlashAttribute("mensagem", "Item criado com sucesso");
//        }
//        catch (Exception e) {
//            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao criar Item: " + e.getMessage());
//        }
//        return "redirect:/estoque/cadastrar";
//    }
//
//    @GetMapping("item")
//    public ResponseEntity<List<ItemEntity>> buscarTodosItens() {
//        List<ItemEntity> itens = itemService.buscarTodosItens();
//        return ResponseEntity.ok(itens);
//    }
//
//    @GetMapping("item/{id}")
//    public ResponseEntity<ItemEntity> buscarItemPorId(@PathVariable Long id) throws IdNaoEncontrado {
//        return ResponseEntity.ok().body(itemService.buscarItemPorId(id));
//    }
//
//    /*
//        Controller que atualiza os itens
//     */
//
//    @PostMapping("item/{id}")
//    public ModelAndView atualizarItem(@PathVariable Long id, @ModelAttribute ItemEntity itemEntity) {
//        ModelAndView mv = new ModelAndView();
//        try {
//            itemService.atualizarItem(id, itemEntity);
//
//            mv.setViewName("estoque/atualizar");
//            mv.addObject("mensagem", "Item atualizado com sucesso");
//        }
//        catch (Exception e) {
//            mv.setViewName("estoque/atualizar");
//            mv.addObject("mensagemErro", "Erro ao atualizar o item: " + e.getMessage());
//        }
//        return mv;
//    }
//
//    /*
//        Controller que deleta itens
//        Por enquanto vou ter que definir como POST, devido a um problema no HTML, após terminar o projeto irei corrigir
//     */
//    @PostMapping("item/deletar/{id}")
//    public String delatarItem(@PathVariable Long id) {
//        ModelAndView mv = new ModelAndView();
//        try {
//            itemService.deletarItem(id);
//            mv.addObject("mensagem", "Item excluido com sucesso");
//
//        }
//        catch (Exception e) {
//            mv.addObject("mensagemErro", "Erro ao excluir o item: " + e.getMessage());
//        }
//        return "redirect:/estoque";
//    }

}
