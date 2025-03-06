package com.example.WebsiteBanHang2.Scheduling;

import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DonHangSchedule {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Scheduled(cron = "0 0 12 * * ?") // Chạy mỗi ngày lúc 12h trưa
//    @Scheduled(fixedRate = 60000) // Chạy mỗi ngày lúc 12h trưa
    public void updateHoaDonCompletedStatus() {
        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        List<HoaDon> hoaDonList = hoaDonRepository.findByTrangThaiVanChuyenAndNgayTaoBefore(HoaDon.TrangThaiVanChuyen.DELIVERED, threeDaysAgo);

        for (HoaDon hoaDon : hoaDonList) {
            System.out.println(hoaDon.toString());
            hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.COMPLETED);
        }
        hoaDonRepository.saveAll(hoaDonList);
        System.out.println("Cập nhật trạng thái đơn hàng thành công lúc: " + LocalDateTime.now());
    }
//    @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(fixedRate = 60000)
    public void updateHoaDonCancelledStatus() {
        LocalDate twoDaysAgo = LocalDate.now().minusDays(2);
        List<HoaDon> hoaDonList = hoaDonRepository.findByTrangThaiVanChuyenAndNgayTaoBefore(HoaDon.TrangThaiVanChuyen.PENDING, twoDaysAgo);

        for (HoaDon hoaDon : hoaDonList) {
            System.out.println(hoaDon.toString());
            hoaDon.setTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen.CANCELLED);
        }
        hoaDonRepository.saveAll(hoaDonList);
        System.out.println("Cập nhật trạng thái đơn hàng thành công lúc: " + LocalDateTime.now());
    }

}
