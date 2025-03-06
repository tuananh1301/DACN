package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Dto.UserAccountDTO;
import com.example.WebsiteBanHang2.Model.GioHang.ShoppingCart;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.UserAccount;

import java.util.List;

public interface OrderService {
    List<HoaDon> getPendingOrders();
    List<HoaDon> getShippedOrders();
    List<HoaDon> getDeliveredOrders();
    List<HoaDon> getCompeletedOrders();
    List<HoaDon> getCancelledOrders();
    HoaDon cancelOrder(Integer orderId);
    HoaDon confirmDelivered(Integer orderId);
    HoaDon confirmCompeleted(Integer orderId);
    HoaDon confirmOrder(Integer orderId);
    HoaDon placeOrder(UserAccount khachHang, ShoppingCart cart, String diaChiGiaoHang, Integer idDonViVanChuyen);
}
