package com.example.WebsiteBanHang2.Model.GioHang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getTotalItems() {
        return items.stream().mapToInt(CartItem::getSoLuongMua).sum();
    }

    public BigDecimal getTongTien() {
        return items.stream()
                .map(CartItem::getThanhTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void removeItem(Integer sanPhamChiTietId) {
        items.removeIf(item -> item.getSanPhamChiTietId().equals(sanPhamChiTietId));
    }
}
