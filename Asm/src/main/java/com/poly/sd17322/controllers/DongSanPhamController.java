package com.poly.sd17322.controllers;

import com.poly.sd17322.models.DongSanPham;
import com.poly.sd17322.services.IDongSanPhamService;
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
@RequestMapping("/dong-san-pham")
public class DongSanPhamController {

    @Autowired
    private IDongSanPhamService dongSanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort = Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<DongSanPham> dongSanPhamPage = dongSanPhamService.getAll(pageable);
        model.addAttribute("listDongSanPham", dongSanPhamPage);
        model.addAttribute("contentPage", "dong-san-pham/index.jsp");
        return "layout";
    }

    @GetMapping("form-add")
    public String formAdd(Model model,@ModelAttribute("dongSanPham") DongSanPham dongSanPham){
        model.addAttribute("contentPage", "dong-san-pham/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("dongSanPham") @Valid DongSanPham dongSanPham,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage", "dong-san-pham/form-add.jsp");
            return "layout";
        }
        dongSanPhamService.add(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        DongSanPham dongSanPham = dongSanPhamService.findById(id);
        model.addAttribute("dongSanPham",dongSanPham);
        model.addAttribute("contentPage", "dong-san-pham/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,@ModelAttribute("dongSanPham") @Valid DongSanPham dongSanPham,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("dongSanPham",dongSanPham);
            model.addAttribute("contentPage", "dong-san-pham/form-detail.jsp");
            return "layout";
        }
        dongSanPhamService.update(id,dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        dongSanPhamService.delete(id);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
