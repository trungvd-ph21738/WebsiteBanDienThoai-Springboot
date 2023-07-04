package com.poly.sd17322.controllers;

import com.poly.sd17322.models.ChiTietSanPham;
import com.poly.sd17322.services.IChiTietSanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private IChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<ChiTietSanPham> listCTSP = chiTietSanPhamService.findAll();
        model.addAttribute("listCTSP", listCTSP);
        model.addAttribute("contentPage","home/home.jsp");
        return "layout";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")UUID id){
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.findById(id);
        model.addAttribute("cTSP", chiTietSanPham);
        model.addAttribute("contentPage","home/detail.jsp");
        return "layout";
    }
}
