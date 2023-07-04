package com.poly.sd17322.controllers;

import com.poly.sd17322.models.GioHang;
import com.poly.sd17322.models.KhachHang;
import com.poly.sd17322.models.SanPham;
import com.poly.sd17322.services.IGioHangService;
import com.poly.sd17322.services.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort = Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<GioHang> gioHangPage = gioHangService.getAll(pageable);
        model.addAttribute("listGioHang", gioHangPage);
        return "/gio-hang/index";
    }

    @GetMapping("form-add")
    public String formAdd(Model model,@ModelAttribute("gioHang") GioHang gioHang){
        model.addAttribute("khachHangs",getListKhachHang());
        return "/gio-hang/form-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("gioHang") GioHang gioHang){
        gioHangService.add(gioHang);
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        GioHang gioHang = gioHangService.findById(id);
        model.addAttribute("gioHang",gioHang);
        return "/gio-hang/form-detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,@ModelAttribute("gioHang") GioHang gioHang){
        gioHangService.update(id,gioHang);
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        gioHangService.delete(id);
        return "redirect:/gio-hang/hien-thi";
    }

    @ModelAttribute(name = "khachHangs")
    public List<KhachHang> getListKhachHang(){
        List<KhachHang> khachHangList = khachHangService.findAll();
        return khachHangList;
    }
}
