package com.controller;

import com.model.Menu;
import com.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller untuk resource Menu.
 */
@CrossOrigin(origins = "*") // 🚨 Penting agar fetch() dari HTML bisa mengakses API
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    /**
     * 🔷 Ambil semua menu.
     * GET /api/menu
     */
    @GetMapping
    public List<Menu> getAll() {
        return service.getAll();
    }

    /**
     * 🔷 Tambah menu baru.
     * POST /api/menu
     */
    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return service.save(menu);
    }

    /**
     * 🔷 Hapus menu berdasarkan ID.
     * DELETE /api/menu/{id}
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /**
     * 🔷 Update menu yang sudah ada.
     * PUT /api/menu/{id}
     */
    @PutMapping("/{id}")
    public Menu update(@PathVariable Long id, @RequestBody Menu menu) {
        menu.setId(id);
        return service.save(menu);
    }
}
