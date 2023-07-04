package com.poly.sd17322.controllers;

import com.poly.sd17322.models.MauSac;
import com.poly.sd17322.services.IMauSacService;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    private IMauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort = Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<MauSac> mauSacPage = mauSacService.getAll(pageable);
        model.addAttribute("listMauSac", mauSacPage);
        model.addAttribute("contentPage","mau-sac/index.jsp");
        return "layout";
    }

    @GetMapping("form-add")
    public String formAdd(Model model,@ModelAttribute("mauSac") MauSac mauSac){
        model.addAttribute("contentPage","mau-sac/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("mauSac") @Valid MauSac mauSac,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","mau-sac/form-add.jsp");
            return "layout";
        }
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        MauSac mauSac = mauSacService.findById(id);
        model.addAttribute("mauSac",mauSac);
        model.addAttribute("contentPage","mau-sac/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,
                         @ModelAttribute("mauSac") @Valid MauSac mauSac,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("mauSac",mauSac);
            model.addAttribute("contentPage","mau-sac/form-detail.jsp");
            return "layout";
        }
        mauSacService.update(id,mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }
}
