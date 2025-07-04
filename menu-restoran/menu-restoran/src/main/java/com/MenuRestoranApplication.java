package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan; // Bisa dibutuhkan jika entitas tidak di sub-paket

@SpringBootApplication
// Jika kelas Menu kamu tidak berada dalam sub-paket dari com.restoran.menurestoran,
// atau di paket lain, kamu mungkin perlu menambahkan ini:
// @EntityScan("com.model") // Tentukan base package untuk entitas kamu
public class MenuRestoranApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuRestoranApplication.class, args);
    }
}