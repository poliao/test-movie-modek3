package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String email, String password) {
        // ตรวจสอบการยืนยันตัวตนของผู้ใช้ และส่งค่าคำตอบกลับ
        // ตรวจสอบ username และ password ว่าถูกต้องหรือไม่
        // คืนค่า true หากยืนยันตัวตนสำเร็จ และ false หากไม่สำเร็จ
        return true; // ตัวอย่างการตรวจสอบการยืนยันตัวตนเท่านั้น
    }
}