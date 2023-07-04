package com.poly.sd17322.controllers;

import com.poly.sd17322.models.KhachHang;
import com.poly.sd17322.services.IKhachHangService;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort =Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<KhachHang> khachHangPage = khachHangService.getAll(pageable);
        model.addAttribute("listKhachHang",khachHangPage);
        model.addAttribute("contentPage","khach-hang/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model,@ModelAttribute("khachHang") KhachHang khachHang){
        model.addAttribute("contentPage","khach-hang/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("khachHang") @Valid KhachHang khachHang,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","khach-hang/form-add.jsp");
            return "layout";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        KhachHang khachHang = khachHangService.findById(id);
        model.addAttribute("khachHang",khachHang);
        model.addAttribute("contentPage","khach-hang/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,
                         @ModelAttribute("khachHang") @Valid KhachHang khachHang,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","khach-hang/form-detail.jsp");
            return "layout";
        }
        khachHangService.update(id,khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        khachHangService.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }
}
