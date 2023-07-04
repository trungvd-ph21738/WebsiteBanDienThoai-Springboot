package com.poly.sd17322.controllers;

import com.poly.sd17322.models.HoaDon;
import com.poly.sd17322.models.HoaDonChiTiet;
import com.poly.sd17322.services.IHoaDonChiTietService;
import com.poly.sd17322.services.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private IHoaDonService hoaDonService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.findAll();
        System.out.println(hoaDonChiTietList.size());
        model.addAttribute("listHDCT", hoaDonChiTietList);
        model.addAttribute("contentPage", "hoa-don-chi-tiet/index.jsp");
        return "layout";
    }

    @GetMapping("/detail/{id}")
    public String hienThiHDCT(Model model,@PathVariable("id")UUID id){
        System.out.println("Đã vào tìm kiếm hóa đơn");
        HoaDon hoaDon = hoaDonService.findById(id);
        List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietService.findByHoaDonId(id);
        System.out.println("Tổng HDCT là: " + hoaDonChiTiets.size());
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("listHDCT", hoaDonChiTiets);
        model.addAttribute("contentPage", "hoa-don-chi-tiet/detail.jsp");
        return "layout";
    }
}
