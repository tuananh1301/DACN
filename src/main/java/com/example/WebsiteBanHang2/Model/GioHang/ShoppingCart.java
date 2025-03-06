package com.example.WebsiteBanHang2.Model.GioHang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        for (CartItem existingItem : items) {
            if (existingItem.getSanPhamChiTietId().equals(item.getSanPhamChiTietId())) {
                existingItem.setSoLuongMua(existingItem.getSoLuongMua() + item.getSoLuongMua());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(Integer sanPhamChiTietId) {
        items.removeIf(item -> item.getSanPhamChiTietId().equals(sanPhamChiTietId));
    }

    public BigDecimal getTongTien() {
        return items.stream()
                .map(CartItem::getThanhTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
}
