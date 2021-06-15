package com.example.SpringDataSecurity.controller;

import com.example.SpringDataSecurity.model.Order;
import com.example.SpringDataSecurity.model.PortalUser;
import com.example.SpringDataSecurity.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @RequestMapping("/paginated")
    public String getUsersPaginated(Model model, @RequestParam("page")Optional<Integer> page) {
        int currentPage = page.orElse(1);
        Page<PortalUser> userPage = userService.getUsersPaginated(PageRequest.of(currentPage-1, 2));
        model.addAttribute("userPage", userPage);
        int totalPages = userPage.getTotalPages();
        if (totalPages>0) {
            List<Integer> pageNumbers = new ArrayList<>();
            for(int i=1; i<=totalPages; i++) {
                pageNumbers.add(i);
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "user";
    }
}

