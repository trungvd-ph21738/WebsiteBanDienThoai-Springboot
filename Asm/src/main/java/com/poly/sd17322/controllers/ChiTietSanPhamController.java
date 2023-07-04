package com.poly.sd17322.controllers;

import com.poly.sd17322.models.*;
import com.poly.sd17322.services.*;
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
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private IChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private INhaSanXuatService nhaSanXuatService;

    @Autowired
    private IMauSacService mauSacService;

    @Autowired
    private IDongSanPhamService dongSanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number,4);
        Page<ChiTietSanPham> chiTietSanPhamPage = chiTietSanPhamService.getAll(pageable);
        model.addAttribute("listCTSP",chiTietSanPhamPage);
        model.addAttribute("contentPage","chi-tiet-san-pham/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model,@ModelAttribute("chiTietSanPham") ChiTietSanPham chiTietSanPham){
        model.addAttribute("sanPhams",getListSanPham());
        model.addAttribute("dongSanPhams",getListDongSanPham());
        model.addAttribute("mauSacs",getListMauSac());
        model.addAttribute("nhaSanXuats",getListNhaSanXuat());
        model.addAttribute("contentPage","chi-tiet-san-pham/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model,@ModelAttribute("chiTietSanPham") @Valid ChiTietSanPham chiTietSanPham, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("sanPhams",getListSanPham());
            model.addAttribute("dongSanPhams",getListDongSanPham());
            model.addAttribute("mauSacs",getListMauSac());
            model.addAttribute("nhaSanXuats",getListNhaSanXuat());
            model.addAttribute("contentPage","chi-tiet-san-pham/form-add.jsp");
            return "layout";
        }
        chiTietSanPhamService.add(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.findById(id);
        model.addAttribute("chiTietSanPham",chiTietSanPham);
        model.addAttribute("contentPage","chi-tiet-san-pham/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,
                         @ModelAttribute("chiTietSanPham") @Valid ChiTietSanPham chiTietSanPham,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("chiTietSanPham",chiTietSanPham);
            model.addAttribute("contentPage","chi-tiet-san-pham/form-detail.jsp");
            return "layout";
        }
        chiTietSanPhamService.update(id,chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        chiTietSanPhamService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @ModelAttribute(name = "dongSanPhams")
    public List<DongSanPham> getListDongSanPham(){
        List<DongSanPham> dongSanPhamList = dongSanPhamService.findAll();
        return dongSanPhamList;
    }

    @ModelAttribute(name = "mauSacs")
    public List<MauSac> getListMauSac(){
        List<MauSac> mauSacList = mauSacService.findAll();
        return mauSacList;
    }

    @ModelAttribute(name = "nhaSanXuats")
    public List<NhaSanXuat> getListNhaSanXuat(){
        List<NhaSanXuat> nhaSanXuatList = nhaSanXuatService.findAll();
        return nhaSanXuatList;
    }

    @ModelAttribute(name = "sanPhams")
    public List<SanPham> getListSanPham(){
        List<SanPham> sanPhamList = sanPhamService.findAll();
        return sanPhamList;
    }

}
