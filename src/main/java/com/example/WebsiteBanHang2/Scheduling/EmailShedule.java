package com.example.WebsiteBanHang2.Scheduling;

import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Repository.HoaDonRepository;
import com.example.WebsiteBanHang2.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmailShedule {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")
//    @Scheduled(fixedRate = 60000)
    public void sendReminderEmails() {
        LocalDate oneDayAgo = LocalDate.now().minusDays(1);
        List<HoaDon> pendingOrders = hoaDonRepository.findByTrangThaiVanChuyenAndNgayTaoBefore(HoaDon.TrangThaiVanChuyen.PENDING, oneDayAgo);

        for (HoaDon hoaDon : pendingOrders) {
            emailService.sendReminderEmail(
                hoaDon.getIdKhachHang().getEmail(),
                "Nhắc nhở thanh toán đơn hàng #" + hoaDon.getMaHoaDon(),
                hoaDon
            );
        }
        System.out.println("Gửi email nhắc nhở thành công lúc: " + LocalDateTime.now());
    }
}
