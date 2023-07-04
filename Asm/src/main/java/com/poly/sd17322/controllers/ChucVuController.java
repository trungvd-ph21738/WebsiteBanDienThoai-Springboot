package com.poly.sd17322.controllers;

import com.poly.sd17322.models.ChucVu;
import com.poly.sd17322.services.ChucVuService;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){
        Sort sort =Sort.by("ma").descending();
        Pageable pageable = PageRequest.of(number,4,sort);
        Page<ChucVu> chucVuPage = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu",chucVuPage);
        model.addAttribute("contentPage","chuc-vu/index.jsp");
        return "layout";
    }

    @GetMapping("/form-add")
    public String formAdd(Model model, @ModelAttribute("chucVu") ChucVu chucVu){
        model.addAttribute("contentPage","chuc-vu/form-add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(Model model,
            @ModelAttribute("chucVu") @Valid  ChucVu chucVu, BindingResult bindingResult){
//        Kiểm tra lỗi
        if(bindingResult.hasErrors()){
            model.addAttribute("contentPage","chuc-vu/form-add.jsp");
            return "layout";
        }
////        Kiểm tra mã trùng
//        if (chucVuService.existsByMa(chucVu.getMa())) {
//            bindingResult.rejectValue("ma", "duplicate.ma", "Mã đã tồn tại"); // Thêm lỗi vào bindingResult
//            model.addAttribute("contentPage","chuc-vu/form-add.jsp");
//            return "layout";
//        }
        chucVuService.addOrUpdate(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        ChucVu chucVu = chucVuService.findById(id);
        model.addAttribute("chucVu",chucVu);
        model.addAttribute("contentPage","chuc-vu/form-detail.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") UUID id,@ModelAttribute("chucVu") @Valid ChucVu chucVu,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("chucVu",chucVu);
            model.addAttribute("contentPage","chuc-vu/form-detail.jsp");
            return "layout";
        }
        chucVuService.update(id,chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }
}
