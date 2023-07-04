package com.poly.sd17322.controllers;

import com.poly.sd17322.models.ChucVu;
import com.poly.sd17322.models.CuaHang;
import com.poly.sd17322.models.NhanVien;
import com.poly.sd17322.services.ChucVuService;
import com.poly.sd17322.services.ICuaHangService;
import com.poly.sd17322.services.INhanVienService;
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

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private INhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ICuaHangService cuaHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort =Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<NhanVien> nhanVienPage = nhanVienService.getAll(pageable);
        model.addAttribute("listNhanVien",nhanVienPage);
        model.addAttribute("contentPage", "nhan-vien/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model,@ModelAttribute("nhanVien") NhanVien nhanVien){
        model.addAttribute("listChucVu",listChucVu());
        model.addAttribute("listCuaHang",listCuaHang());
        model.addAttribute("contentPage", "nhan-vien/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("listChucVu",listChucVu());
            model.addAttribute("listCuaHang",listCuaHang());
            model.addAttribute("contentPage", "nhan-vien/form-add.jsp");
            return "layout";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        NhanVien nhanVien = nhanVienService.findById(id);
        model.addAttribute("nhanVien",nhanVien);
        model.addAttribute("contentPage", "nhan-vien/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @ModelAttribute("nhanVien") @Valid NhanVien nhanVien,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage", "nhan-vien/form-detail.jsp");
            return "layout";
        }
        nhanVienService.update(id,nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @ModelAttribute("listChucVu")
    public List<ChucVu> listChucVu(){
        List<ChucVu> listChucVu = chucVuService.findAll();
        return listChucVu;
    }

    @ModelAttribute("listCuaHang")
    public List<CuaHang> listCuaHang(){
        List<CuaHang> listCuaHang = cuaHangService.findAll();
        return listCuaHang;
    }
}
