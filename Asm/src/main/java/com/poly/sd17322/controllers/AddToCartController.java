package com.poly.sd17322.controllers;

import com.poly.sd17322.models.ChiTietSanPham;
import com.poly.sd17322.models.Item;
import com.poly.sd17322.models.Order;
import com.poly.sd17322.services.IChiTietSanPhamService;
import jakarta.servlet.http.HttpSession;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class AddToCartController {
    @Autowired
    IChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id")UUID id){
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.findById(id);
        Integer soLuong = 1;
        Item item = new Item(id, chiTietSanPham.getSanPham().getTen(),
                chiTietSanPham.getDongSanPham().getTen(),chiTietSanPham.getMauSac().getTen(),chiTietSanPham.getNhaSanXuat().getTen(),
                soLuong,chiTietSanPham.getGiaBan());
        Order orderSession = (Order) httpSession.getAttribute("order");
        if(orderSession == null){
            Order newOrder = new Order();
            List<Item> itemList = new ArrayList<>();
            itemList.add(item);
            newOrder.setItemList(itemList);
            httpSession.setAttribute("order", newOrder);
        }else {
            Order order = (Order) httpSession.getAttribute("order");
            List<Item> itemList = order.getItemList();
            for (Item item1 : itemList){
                if(item1.getId().equals(id)){
                    item1.setSoLuong(item1.getSoLuong() + 1);
                    return "redirect:/home/hien-thi";
                }
            }
            itemList.add(item);
        }
        return "redirect:/home/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") UUID id) {

        Order order = (Order) httpSession.getAttribute("order");
        List<Item> items = order.getItemList();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
            }
        }
        model.addAttribute("listCTSP", items);
        model.addAttribute("contentPage", "order/index.jsp");
        return "layout";
    }

    @GetMapping("/hien-thi")
    public String viewOrder(Model model){
        Integer tongSoSanPham = 0;
        Order order = (Order) httpSession.getAttribute("order");
        System.out.println(order.toString());
        List<Item> itemList = order.getItemList();
        for (Item item:itemList){
            Integer soLuongItem = item.getSoLuong();
            tongSoSanPham = tongSoSanPham + soLuongItem;
        }
        model.addAttribute("tongSoSanPham", tongSoSanPham);
        model.addAttribute("listCTSP", itemList);
        model.addAttribute("contentPage", "order/index.jsp");
        return "layout";
    }
}
