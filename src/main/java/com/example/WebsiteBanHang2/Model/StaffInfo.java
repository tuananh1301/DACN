package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "staff_info")
public class StaffInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userId;

    @Column(name = "staff_code")
    private String staffCode;

    @Column(name = "department")
    private String department;


}
