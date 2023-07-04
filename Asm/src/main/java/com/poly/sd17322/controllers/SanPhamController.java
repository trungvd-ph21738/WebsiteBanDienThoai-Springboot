package com.poly.sd17322.controllers;

import com.poly.sd17322.models.SanPham;
import com.poly.sd17322.services.ISanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort =Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<SanPham> sanPhamPage = sanPhamService.getAll(pageable);
        model.addAttribute("listSanPham",sanPhamPage);
        model.addAttribute("contentPage","san-pham/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model,@ModelAttribute("sanPham") SanPham sanPham){
        model.addAttribute("contentPage","san-pham/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("sanPham") @Valid SanPham sanPham,
                      BindingResult bindingResult,
                      Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","san-pham/form-add.jsp");
            return "layout";
        }
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("contentPage","san-pham/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @ModelAttribute("sanPham") @Valid SanPham sanPham,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","san-pham/form-detail.jsp");
            return "layout";
        }
        sanPhamService.update(id,sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        sanPhamService.delete(id);
        return "redirect:/san-pham/hien-thi";
    }
}
