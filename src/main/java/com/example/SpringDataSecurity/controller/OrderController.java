package com.example.SpringDataSecurity.controller;

import com.example.SpringDataSecurity.model.Order;
import com.example.SpringDataSecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "index";
    }

    @RequestMapping("/paginated")
    public String getOrdersPaginated(Model model, @RequestParam("page")Optional<Integer> page) {
        int currentPage = page.orElse(1);
        Page<Order> orderPage = orderService.getOrdersPaginated(PageRequest.of(currentPage-1, 5));
        model.addAttribute("orderPage", orderPage);
        int totalPages = orderPage.getTotalPages();
        if (totalPages>0) {
            List<Integer> pageNumbers = new ArrayList<>();
            for(int i=1; i<=totalPages; i++) {
                pageNumbers.add(i);
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }
}

