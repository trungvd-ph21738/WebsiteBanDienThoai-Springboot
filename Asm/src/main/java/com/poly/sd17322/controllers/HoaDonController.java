package com.poly.sd17322.controllers;

import com.poly.sd17322.models.GioHang;
import com.poly.sd17322.models.HoaDon;
import com.poly.sd17322.services.IHoaDonService;
import com.poly.sd17322.services.IKhachHangService;
import com.poly.sd17322.services.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort = Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number, 10, sort);
        Page<HoaDon> hoaDonPage = hoaDonService.getAll(pageable);
        model.addAttribute("listHoaDon", hoaDonPage);
        model.addAttribute("contentPage", "hoa-don/index.jsp");
        return "layout";
    }

    @GetMapping("/khach-hang/{id}")
    public String hienThiHoaDonTheoKhachHang(@PathVariable("id") UUID idKH, Model model){
        List<HoaDon> hoaDonList =  hoaDonService.findByKhachHangId(idKH);
        model.addAttribute("listHoaDon", hoaDonList);
        model.addAttribute("contentPage", "hoa-don/thong-ke-hoa-don.jsp");
        return "layout";
    }

    @GetMapping("/confirm/{id}")
    public String xacNhanDatHang(Model model, @PathVariable("id")UUID id){
        Integer trangThai = 2;
        HoaDon hoaDonUpdate = hoaDonService.updateTrangThai(id,trangThai);
        return "redirect:/hoa-don/hien-thi";
    }
}
