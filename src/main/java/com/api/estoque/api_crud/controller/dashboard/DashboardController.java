//package com.api.estoque.api_crud.Controller.Dashboard;
//
//import com.api.estoque.api_crud.Service.VendaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/api/dashboard")
//public class DashboardController {
//
//    @Autowired
//    private VendaService vendaService;
//
//    @GetMapping
//    public ResponseEntity<Map<String, String>> viewDashboard(@RequestBody LocalDate dia) {
//
//        Map<String, Double> data = new HashMap<>();
//        data.put("vendas_hoje", vendaService.buscarVendasHoje(dia));
//        data.put("vendas_semana", vendaService.buscarVendasSemana());
//        data.put("visitantes", "CHAMAR FUNÇAÕ!!!");
//        data.put("valor_total_estoque", "Chamar função");
//
//        return ResponseEntity.ok(data);
//
//    }
//
//}
