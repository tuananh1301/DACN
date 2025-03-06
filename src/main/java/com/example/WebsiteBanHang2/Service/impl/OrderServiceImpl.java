package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.HoaDonChiTietDTO;
import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Model.*;
import com.example.WebsiteBanHang2.Model.GioHang.CartItem;
import com.example.WebsiteBanHang2.Model.GioHang.ShoppingCart;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.HoaDonChiTiet;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.*;
import com.example.WebsiteBanHang2.Service.HoaDonService;
import com.example.WebsiteBanHang2.Repository.DonViVanChuyenRepository;
import com.example.WebsiteBanHang2.Repository.HoaDonChiTietRepository;
import com.example.WebsiteBanHang2.Repository.HoaDonRepository;
import com.example.WebsiteBanHang2.Repository.SanPhamChiTietRepository;
import com.example.WebsiteBanHang2.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    DonViVanChuyenRepository donViVanChuyenRepository;
    @Autowired
    UserAccountRepository userAccountRepository;
    // Lấy danh sách đơn hàng PENDING
    public List<HoaDon> getPendingOrders() {
        return hoaDonService.findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.PENDING);
    }

    @Override
    public List<HoaDon> getShippedOrders() {
        return hoaDonService.findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.SHIPPED);
    }

    @Override
    public List<HoaDon> getDeliveredOrders() {
        return hoaDonService.findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.DELIVERED);
    }
    @Override
    public List<HoaDon> getCompeletedOrders() {
        return hoaDonService.findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.COMPLETED);
    }

    @Override
    public List<HoaDon> getCancelledOrders() {
        return hoaDonService.findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.CANCELLED);
    }


    // Xác nhận đơn hàng
    @Transactional
    public HoaDon confirmOrder(Integer orderId) {
        HoaDon hoaDon = hoaDonRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đơn hàng"));

        if (hoaDon.getTrangThaiVanChuyen() != HoaDon.TrangThaiVanChuyen.PENDING) {
            throw new IllegalStateException("Đơn hàng không ở trạng thái PENDING");
        }

        hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.SHIPPED);
        return hoaDonRepository.save(hoaDon);
    }

    // Hủy đơn hàng
    @Transactional
    public HoaDon cancelOrder(Integer orderId) {
        HoaDon hoaDon = hoaDonRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đơn hàng"));

        if (hoaDon.getTrangThaiVanChuyen() != HoaDon.TrangThaiVanChuyen.PENDING) {
            throw new IllegalStateException("Đơn hàng không ở trạng thái PENDING");
        }

        // Cập nhật trạng thái
        hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.CANCELLED);
        hoaDonRepository.save(hoaDon);

        // Hoàn lại số lượng sản phẩm
        List<HoaDonChiTiet> chiTiets = hoaDonChiTietRepository.findByHoaDonId_Id(orderId);
        for (HoaDonChiTiet chiTiet : chiTiets) {
            SanPhamChiTiet spct = chiTiet.getSanPhamChiTietId();
            spct.setSoLuong(spct.getSoLuong() + chiTiet.getSoLuong());
            sanPhamChiTietRepository.save(spct);
        }
        return hoaDon;
    }

    @Override
    public HoaDon confirmDelivered(Integer orderId) {
        HoaDon hoaDon = hoaDonRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đơn hàng"));

        if (hoaDon.getTrangThaiVanChuyen() != HoaDon.TrangThaiVanChuyen.SHIPPED) {
            throw new IllegalStateException("Đơn hàng không ở trạng thái SHIPPED");
        }

        hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.DELIVERED);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon confirmCompeleted(Integer orderId) {
        HoaDon hoaDon = hoaDonRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đơn hàng"));

        if (hoaDon.getTrangThaiVanChuyen() != HoaDon.TrangThaiVanChuyen.DELIVERED) {
            throw new IllegalStateException("Đơn hàng không ở trạng thái DELIVERED");
        }

        hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.COMPLETED);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    @Transactional
    public HoaDon placeOrder(UserAccount khachHang, ShoppingCart cart, String diaChiGiaoHang, Integer idDonViVanChuyen) {
        String maHoaDon = generateMaHoaDon();
        DonViVanChuyen donViVanChuyen = donViVanChuyenRepository.findById(idDonViVanChuyen).orElseThrow(() -> new RuntimeException("DonViVanChuyen not found"));
        BigDecimal tongTienSanPham = cart.getTongTien();
        BigDecimal phiVanChuyen = donViVanChuyen.getPhiVanChuyen() != null ? donViVanChuyen.getPhiVanChuyen() : BigDecimal.ZERO;
        BigDecimal tongTien = tongTienSanPham.add(phiVanChuyen);

        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKhachHang(khachHang);
        hoaDon.setMaHoaDon(maHoaDon);
        hoaDon.setTongTien(tongTien);
        hoaDon.setLoaiDon("ONLINE");
        hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.PENDING);
        hoaDon.setDiaChiGiaoHang(diaChiGiaoHang);
        hoaDon.setIdDonViVanChuyen(donViVanChuyen);
        hoaDon.setNgayTao(LocalDate.now());
        hoaDon.setTrangThai((byte) 1);
        hoaDon = hoaDonRepository.save(hoaDon);

        List<HoaDonChiTiet> chiTietHoaDonList = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            SanPhamChiTiet spct = sanPhamChiTietRepository.findById(item.getSanPhamChiTietId())
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

            if (spct.getSoLuong() < item.getSoLuongMua()) {
                throw new RuntimeException("Số lượng tồn kho không đủ cho sản phẩm: " + item.getTenSanPham());
            }

            HoaDonChiTiet chiTiet = new HoaDonChiTiet();
            chiTiet.setHoaDonId(hoaDon);
            chiTiet.setSanPhamChiTietId(spct);
            chiTiet.setSoLuong(item.getSoLuongMua());
            chiTiet.setDonGia(item.getDonGia());
            chiTiet.setTrangThai((byte) 1);
            chiTietHoaDonList.add(chiTiet);

            spct.setSoLuong(spct.getSoLuong() - item.getSoLuongMua());
            sanPhamChiTietRepository.save(spct);

        }
        hoaDonChiTietRepository.saveAll(chiTietHoaDonList);
        return hoaDon;
    }
    private String generateMaHoaDon() {
        long count = hoaDonRepository.count() + 1;
        return "HD" + String.format("%03d", count);
    }

}
