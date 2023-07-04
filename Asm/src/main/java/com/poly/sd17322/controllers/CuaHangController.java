package com.poly.sd17322.controllers;

import com.poly.sd17322.models.ChucVu;
import com.poly.sd17322.models.CuaHang;
import com.poly.sd17322.services.ICuaHangService;
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
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    private ICuaHangService cuaHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort = Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<CuaHang> cuaHangPage = cuaHangService.getAll(pageable);
        model.addAttribute("listCuaHang", cuaHangPage);
        model.addAttribute("contentPage","cua-hang/index.jsp");
        return "layout";
    }

    @GetMapping("form-add")
    public String formAdd(Model model,@ModelAttribute("cuaHang") CuaHang cuaHang){
        model.addAttribute("contentPage","cua-hang/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("cuaHang") @Valid CuaHang cuaHang,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","cua-hang/form-add.jsp");
            return "layout";
        }
        cuaHangService.add(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        CuaHang cuaHang = cuaHangService.findById(id);
        model.addAttribute("cuaHang",cuaHang);
        model.addAttribute("contentPage","cua-hang/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,@ModelAttribute("cuaHang") @Valid CuaHang cuaHang,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("cuaHang",cuaHang);
            model.addAttribute("contentPage","cua-hang/form-detail.jsp");
            return "layout";
        }
        cuaHangService.update(id,cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        cuaHangService.delete(id);
        return "redirect:/cua-hang/hien-thi";
    }
}
