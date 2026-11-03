# ☕ Kopi dan Nyemil (`kopMil`)

**Kopi dan Nyemil** adalah aplikasi mobile Android untuk pemesanan minuman kopi dan aneka camilan secara praktis. Aplikasi ini dibangun menggunakan **Android Studio** berdasarkan rancangan *wireframe* alur pemesanan pengguna, mulai dari halaman pembuka (*Splash/Welcome*), autentikasi pengguna (*Sign Up, Login, Register*), katalog menu makanan dan minuman (*Home*), pengelolaan profil (*Profile*), formulir alamat pengiriman (*Order*), hingga halaman konfirmasi pesanan (*Konfirmasi Pesanan*).

## ✨ Fitur Aplikasi

1. **Splash / Welcome Screen**
   * Menampilkan identitas visual berupa logo lingkaran **Kopi dan Nyemil**, judul aplikasi, *tagline* *"Get a taste of your wish"*, serta tombol **Start now** untuk memulai aplikasi.
2. **Sign Up Screen**
   * Menampilkan halaman sambutan keanggotaan (*member*) beserta navigasi menuju halaman pendaftaran akun baru (**Register**) atau masuk ke akun yang sudah terdaftar (**Login**).
3. **Login User**
   * Menyediakan formulir masuk menggunakan `username` dan `password` lengkap dengan validasi input kosong serta tombol kembali.
4. **Register**
   * Menyediakan formulir registrasi pengguna baru yang mencakup `nama lengkap`, `username`, dan `password`. Nama lengkap yang didaftarkan otomatis ditampilkan pada sapaan pengguna di halaman utama.
5. **Home (Daftar Makanan & Minuman)**
   * Menampilkan sapaan dinamis **`"Halo [Nama],"`** sesuai identitas pengguna yang sedang aktif.
   * Menampilkan katalog makanan dan minuman menggunakan data statis (*dummy data*) sebanyak **6 item menu** (memenuhi ketentuan minimal 5 item):
     * **Kopi Susu Gula Aren** — Espresso, susu, gula aren (`Rp 22.000`)
     * **Donat Cokelat** — Donat empuk, glaze cokelat (`Rp 12.000`)
     * **Sourdough Loaf** — Roti fermentasi alami (`Rp 35.000`)
     * **Cappuccino** — Espresso, foam susu lembut (`Rp 25.000`)
     * **Matcha Latte** — Matcha Jepang, susu segar (`Rp 27.000`)
     * **Croissant Butter** — Pastry renyah mentega Prancis (`Rp 24.000`)
   * Setiap kartu menu bersifat interaktif dan dapat diketuk langsung untuk memilih pesanan dan menuju halaman pengisian alamat pengiriman.
6. **Profile**
   * Menampilkan informasi **Profile Saya / Profile Setting** yang memungkinkan pengguna memperbarui nama tampilan secara *real-time* melalui tombol **Save**.
7. **Alamat Pengiriman (Order)**
   * Menampilkan ringkasan item menu dan harga yang sedang dipesan.
   * Menyediakan formulir pengiriman yang terdiri dari `Nama Lengkap`, `Alamat`, dan `Patokan atau detail lengkap` beserta tombol **Order dan Kirim**.
8. **Konfirmasi Pesanan**
   * Menampilkan sapaan pengguna, lencana lingkaran hijau **OK**, pesan konfirmasi pengiriman oleh kurir, ringkasan pesanan beserta alamat tujuan, serta tombol **Oke** untuk kembali ke halaman **Home**.
9. **Bottom Navigation Bar**
   * Memudahkan perpindahan antar halaman utama (**Home**, **Order**, dan **Profile**) dengan indikator tombol aktif yang jelas.

## 🛠️ Teknologi yang Digunakan

* **IDE**: Android Studio
* **Bahasa Pemrograman**: Kotlin (`MainActivity.kt`)
* **Desain Antarmuka (UI)**: XML Layout (`activity_main.xml`) dengan komponen Android Views (`RelativeLayout`, `FrameLayout`, `LinearLayout`, `ScrollView`, `EditText`, `Button`, `TextView`) & `GradientDrawable`
* **Arsitektur & Data**: Static / In-Memory Dummy Data (tanpa database eksternal sesuai ketentuan tugas)
* **Package Name**: `com.example.kopmil`
* **Minimum SDK**: API 24 (Android 7.0 Nougat)

## 📂 Struktur File Utama

```text
kopMil/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/kopmil/
│           │   └── MainActivity.kt          # Logika navigasi 8 layar, validasi form, & data statis
│           ├── res/layout/
│           │   └── activity_main.xml        # Desain antarmuka XML untuk seluruh 8 halaman wireframe
│           └── AndroidManifest.xml          # Konfigurasi utama aplikasi Android
├── screenshots/                             # Folder dokumentasi tangkapan layar aplikasi
└── README.md                                # Dokumentasi repositori proyek
```

## 🚀 Cara Menjalankan Aplikasi

1. **Clone Repository**
    Unduh atau *clone* repository ini ke komputer Anda menggunakan perintah berikut:
   ```bash
   git clone https://github.com/USERNAME_GITHUB_ANDA/kopMil.git
   ```
2. **Buka di Android Studio**
   * Buka aplikasi **Android Studio**.
   * Pilih menu **File ➔ Open**, lalu arahkan ke folder project **`kopMil`** yang telah di-*clone* dan klik **OK**.
3. **Sinkronisasi Gradle**
   * Tunggu hingga proses *Gradle Sync* di bagian bawah Android Studio selesai secara otomatis.
4. **Jalankan Aplikasi (*Run*)**
   * Siapkan perangkat **Android Emulator** (misalnya Pixel 9) atau hubungkan perangkat HP Android fisik dengan fitur *USB Debugging* aktif.
   * Klik tombol **Run 'app' (▶️)** di bilah atas Android Studio atau tekan pintasan keyboard `Shift + F10`.

## 📸 Screenshot Tampilan Aplikasi

> **Catatan**: Simpan gambar hasil *screenshot* emulator ke dalam folder `screenshots/` di proyek Anda dengan nama file di bawah ini agar gambar tampil otomatis di halaman GitHub.

| 1. Splash / Welcome | 2. Sign Up | 3. Login User | 4. Register |
| :---: | :---: | :---: | :---: |
|  |  |  |  |

| 5. Home (Daftar Menu) | 6. Profile | 7. Alamat Pengiriman | 8. Konfirmasi Pesanan |
| :---: | :---: | :---: | :---: |
|  |  |  |  |
