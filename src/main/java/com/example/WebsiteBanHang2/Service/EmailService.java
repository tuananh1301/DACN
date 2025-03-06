package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Model.HoaDon;

public interface EmailService {
    void sendReminderEmail(String toEmail, String subject, HoaDon hoaDon);
    void sendEmail(String toEmail, String subject, String content);
}
