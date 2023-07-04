package com.poly.sd17322.controllers;

import com.poly.sd17322.models.NhaSanXuat;
import com.poly.sd17322.services.INhaSanXuatService;
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
@RequestMapping("/nha-san-xuat")
public class NhaSanXuatController {
    @Autowired
    private INhaSanXuatService nhaSanXuatService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort =Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<NhaSanXuat> nhaSanXuats = nhaSanXuatService.getAll(pageable);
        model.addAttribute("listNSX",nhaSanXuats);
        model.addAttribute("contentPage","nha-san-xuat/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model,@ModelAttribute("nhaSanXuat") NhaSanXuat nhaSanXuat){
        model.addAttribute("contentPage","nha-san-xuat/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("nhaSanXuat") @Valid NhaSanXuat nhaSanXuat,
                      BindingResult bindingResult,
                      Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","nha-san-xuat/form-add.jsp");
            return "layout";
        }
        nhaSanXuatService.add(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.findById(id);
        model.addAttribute("nhaSanXuat",nhaSanXuat);
        model.addAttribute("contentPage","nha-san-xuat/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @ModelAttribute("nhaSanXuat") @Valid NhaSanXuat nhaSanXuat,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","nha-san-xuat/form-detail.jsp");
            return "layout";
        }
        nhaSanXuatService.update(id,nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        nhaSanXuatService.delete(id);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
