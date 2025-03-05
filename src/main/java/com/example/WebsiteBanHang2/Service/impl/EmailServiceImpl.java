package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendReminderEmail(String toEmail, String subject, HoaDon hoaDon) {
        logger.info("Chuẩn bị gửi email đến: {}, Subject: {}, HoaDon ID: {}", toEmail, subject, hoaDon.getId());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trandangvip123@gmail.com"); // Đảm bảo khớp với spring.mail.username
        message.setTo(toEmail);
        message.setSubject(subject);

        String content = "Kính gửi khách hàng,\n\n" +
                "Đơn hàng #" + hoaDon.getId() + " của bạn đang ở trạng thái chưa thanh toán.\n" +
                "Vui lòng thanh toán trong thời gian sớm nhất để hoàn tất giao dịch, nếu quá hạn 2 ngày thanh toán đơn hàng của bạn sẽ bị huỷ.\n\n" +
                "Thông tin đơn hàng:\n" +
                "- Ngày tạo: " + hoaDon.getNgayTao() + "\n" +
                "- Tổng tiền: " + hoaDon.getTongTien() + "\n\n" +
                "Trân trọng,\n" +
                "Đội ngũ WebsiteBanHang2";

        message.setText(content);

        try {
            javaMailSender.send(message);
            logger.info("Gửi email thành công đến: {}", toEmail);
        } catch (MailAuthenticationException e) {
            logger.error("Lỗi xác thực email: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendEmail(String toEmail, String subject, String content) {
        logger.info("Chuẩn bị gửi email đến: {}, Subject: {}", toEmail, subject);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trandangvip123@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(content);

        try {
            javaMailSender.send(message);
            logger.info("Gửi email thành công đến: {}", toEmail);
        } catch (MailAuthenticationException e) {
            logger.error("Lỗi xác thực email: {}", e.getMessage(), e);
            throw e;
        }
    }
}