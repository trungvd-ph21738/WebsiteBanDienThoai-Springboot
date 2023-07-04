package com.poly.sd17322.controllers;

import com.poly.sd17322.models.*;
import com.poly.sd17322.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thanh-toan")
public class ThanhToanController {

    @Autowired
    private IChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private INhanVienService nhanVienService;

    @Autowired
    private IKhachHangService khachHangService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/xac-minh")
    public String viewConfirm(Model model){
        Order order = (Order) httpSession.getAttribute("order");
        List<Item> listSanPhamMua = order.getItemList();
        model.addAttribute("listSanPhamMua", listSanPhamMua);
        model.addAttribute("contentPage", "order/buy-confirm.jsp");
        return "layout";
    }

    @GetMapping("/dat-hang")
    public String datHang(Model model){
//        Tạo Nhân Viên Fake
        ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>) nhanVienService.findAll();
        NhanVien nhanVien = listNhanVien.get(2);

//        Tạo Khách Hàng Fake
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) khachHangService.findAll();
        KhachHang khachHangMoi = listKhachHang.get(1);

//        Tạo Hóa Đơn
        List<HoaDon> hoaDons = hoaDonService.findAll();
        Integer soLuongHoaDon = hoaDons.size();
        String maHoaDonMoi = "HD" + (soLuongHoaDon + 1);
        HoaDon hoaDonNew = new HoaDon();
        Date ngayTao = new Date(System.currentTimeMillis());
        hoaDonNew.setMa(maHoaDonMoi);
        hoaDonNew.setKhachHang(khachHangMoi);
        hoaDonNew.setNhanVien(nhanVien);
        hoaDonNew.setNgayTao(ngayTao);
        hoaDonNew.setTinhTrang(1);
        hoaDonService.save(hoaDonNew);
//        Thêm sản phẩm chi tiết vào hóa đơn chi tiết
        Order order = (Order) httpSession.getAttribute("order");
        List<Item> listSanPhamMua = order.getItemList();
        System.out.println("Số sản phẩm mua là: "+listSanPhamMua.size());
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();

        for (Item item: listSanPhamMua){
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.findById(item.getId());
            hoaDonChiTiet.setId(new IdHoaDonChiTiet(hoaDonNew,chiTietSanPham));
            hoaDonChiTiet.setDonGia(item.getGiaBan());
            hoaDonChiTiet.setSoLuong(item.getSoLuong());
            hoaDonChiTiets.add(hoaDonChiTiet);
            chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - item.getSoLuong());
            chiTietSanPhamService.add(chiTietSanPham);
        }
        hoaDonChiTietService.saveAll(hoaDonChiTiets);

//        Xóa thông tin session của giỏ hàng
        httpSession.removeAttribute("order");
        System.out.println("Đặt Hàng Thành Công");
        return "redirect:/home/hien-thi";
    }
}
