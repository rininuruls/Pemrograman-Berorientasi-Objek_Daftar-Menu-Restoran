function loadMenu() {
  fetch(apiUrl)
    .then((res) => res.json())
    .then((data) => {
      const menuList = document.getElementById("menu-list");
      menuList.innerHTML = "";

      if (data.length === 0) {
        menuList.innerHTML = `<div class="alert alert-info text-center">Belum ada menu.</div>`;
        return;
      }

      data.forEach((item) => {
        const div = document.createElement("div");
        div.className = "menu-item card p-2 shadow-sm";

        div.innerHTML = `
          <div class="d-flex justify-content-between align-items-center">
            <div>
              <strong>${item.nama}</strong> <span class="badge bg-primary">${item.kategori}</span> 
              <span class="text-muted">Rp${item.harga}</span>
            </div>
            <div>
              <button class="btn btn-sm btn-warning me-1" onclick="editMenu(${item.id}, '${item.nama}', '${item.kategori}', ${item.harga})">✏️ Edit</button>
              <button class="btn btn-sm btn-danger" onclick="deleteMenu(${item.id})">🗑️ Hapus</button>
            </div>
          </div>
        `;

        menuList.appendChild(div);
      });
    })
    .catch((err) => console.error("Gagal load menu:", err));
}
