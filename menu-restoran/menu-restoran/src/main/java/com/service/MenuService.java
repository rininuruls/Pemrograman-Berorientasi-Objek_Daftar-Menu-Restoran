package com.service;

import com.model.Menu;
import com.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository repo;

    public MenuService(MenuRepository repo) {
        this.repo = repo;
    }

    /**
     * Ambil semua menu dari database.
     */
    public List<Menu> getAll() {
        return repo.findAll();
    }

    /**
     * Simpan menu (baik tambah baru maupun update).
     */
    public Menu save(Menu menu) {
        if (menu.getNama() == null || menu.getNama().isEmpty()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong");
        }
        if (menu.getKategori() == null || menu.getKategori().isEmpty()) {
            throw new IllegalArgumentException("Kategori tidak boleh kosong");
        }
        if (menu.getHarga() == null || menu.getHarga() <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }

        return repo.save(menu);
    }

    /**
     * Hapus menu berdasarkan ID.
     */
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Menu dengan ID " + id + " tidak ditemukan");
        }
        repo.deleteById(id);
    }
}
