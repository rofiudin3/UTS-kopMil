# ☕ Kopi dan Nyemil — Aplikasi Pemesanan Makanan & Minuman Android (Java & XML)

Aplikasi mobile **Kopi dan Nyemil** adalah aplikasi pemesanan kopi dan camilan berbasis Android yang dibuat menggunakan **Java** dan **XML Layout** berdasarkan wireframe tugas pengembangan aplikasi mobile. Aplikasi ini mengimplementasikan seluruh alur pengguna mulai dari halaman pembuka (*Splash/Welcome*), autentikasi (*Sign Up, Login, Register*), katalog menu makanan & minuman (*Home*), pengaturan profil (*Profile*), pengisian alamat pengiriman (*Order*), hingga konfirmasi pesanan (*Konfirmasi Pesanan*).

## ✨ Fitur Utama Aplikasi

1. **Splash / Welcome Screen**: Menampilkan identitas visual dan logo lingkaran aplikasi **Kopi dan Nyemil** dengan slogan *"Get a taste of your wish"* serta tombol **Start now**.
2. **Sign Up Landing Screen**: Halaman sambutan keanggotaan yang mengarahkan pengguna untuk membuat akun baru (**Register**) atau masuk ke akun yang sudah ada (**Login**).
3. **Login User**: Formulir masuk menggunakan `username` dan `password` dengan validasi input kosong.
4. **Register**: Formulir pendaftaran pengguna baru yang mencakup `nama lengkap`, `username`, dan `password`.
5. **Home (Daftar Makanan & Minuman)**:
   * Menampilkan sapaan dinamis `"Halo [Nama],"` sesuai nama pengguna yang login/register.
   * Menampilkan daftar menu statis (*dummy data*) sebanyak **6 item** (memenuhi syarat minimal 5 item) lengkap dengan ikon/foto, nama menu, komposisi, dan harga:
     * **Kopi Susu Gula Aren** — Espresso, susu, gula aren (Rp 22.000)
     * **Donat Cokelat** — Donat empuk, glaze cokelat (Rp 12.000)
     * **Sourdough Loaf** — Roti fermentasi alami (Rp 35.000)
     * **Cappuccino** — Espresso, foam susu lembut (Rp 25.000)
     * **Matcha Latte** — Matcha Jepang, susu segar (Rp 27.000)
     * **Croissant Butter** — Pastry renyah mentega Prancis (Rp 24.000)
6. **Profile**: Memungkinkan pengguna melihat dan mengubah nama tampilan (`Profile Setting`) secara langsung (*real-time*).
7. **Alamat Pengiriman (Order)**: Formulir pengiriman pesanan yang memuat ringkasan pesanan, input `Nama Lengkap`, `Alamat`, dan `Patokan atau detail lengkap` beserta tombol **Order dan Kirim**.
8. **Konfirmasi Pesanan**: Menampilkan indikator lingkaran hijau sukses (**OK**) beserta pesan konfirmasi pengiriman kurir dan tombol **Oke** untuk kembali ke halaman utama.
9. **Bottom Navigation Bar**: Navigasi cepat antar halaman **Home**, **Order**, dan **Profile** sesuai rancangan wireframe.

## 🛠️ Teknologi yang Digunakan

* **IDE**: Android Studio (Ladybug / Koala / Iguana atau versi terbaru)
* **Bahasa Pemrograman**: Java
* **Desain Antarmuka (UI)**: XML Layout (`RelativeLayout`, `LinearLayout`, `ScrollView`, `FrameLayout`, dan `GradientDrawable` styling)
* **Penyimpanan Data**: Static / In-Memory Dummy Data (Tanpa Database sesuai ketentuan tugas)
* **Minimum SDK**: API 24 (Android 7.0 Nougat)

## 🚀 Cara Menjalankan Aplikasi (Panduan Pemula dari Nol)

### Langkah 1: Buat Project Baru di Android Studio (`Empty Views Activity`)

1. Buka **Android Studio**, lalu klik **New Project**.
2. Pada tab **Phone and Tablet**, pilih template **Empty Views Activity** *(penting: pilih yang ada kata **"Views"** agar menggunakan XML & Java)*, lalu klik **Next**.
3. Isi detail project sebagai berikut:
   * **Name**: `Kopi dan Nyemil`
   * **Package name**: `com.example.kopidannyemil`
   * **Language**: **Java**
   * **Minimum SDK**: `API 24 ("Nougat"; Android 7.0)`
4. Klik **Finish** dan tunggu hingga proses *Gradle Sync* di pojok kanan bawah selesai.

### Langkah 2: Salin Kode `activity_main.xml` dan `MainActivity.java`

1. **Salin Layout XML (`activity_main.xml`)**:
   * Di panel kiri Android Studio (**Project**), buka folder `app` ➔ `res` ➔ `layout` ➔ klik dua kali **`activity_main.xml`**.
   * Klik ikon **Code** (di pojok kanan atas editor XML, di samping Split/Design).
   * Hapus seluruh isi kode bawaan, lalu **tempel (paste)** seluruh kode dari file **`activity_main.xml`** yang telah disediakan.
2. **Salin Kode Program (`MainActivity.java`)**:
   * Buka folder `app` ➔ `java` ➔ `com.example.kopidannyemil` ➔ klik dua kali **`MainActivity.java`**.
   * Hapus seluruh isi kode bawaan, lalu **tempel (paste)** seluruh kode dari file **`MainActivity.java`** yang telah disediakan.
   * *(Catatan: Jika nama `package` di baris paling atas project kamu berbeda, sesuaikan baris pertama `package ...;` tersebut dengan nama package project kamu).*

### Langkah 3: Jalankan Aplikasi di Emulator atau HP Android

1. Pilih perangkat tujuan di bagian atas Android Studio (Emulator atau HP Android milikmu).
2. Klik tombol **Run 'app'** (ikon segitiga hijau ▶️ di bagian atas) atau tekan `Shift + F10`.
3. Aplikasi **Kopi dan Nyemil** akan langsung berjalan di layar!

## 📸 Screenshot Tampilan Aplikasi

> **Catatan sebelum dikumpulkan**: Ambil *screenshot* dari setiap layar saat aplikasi dijalankan di Emulator/HP (klik ikon kamera 📷 **Take Screenshot** di sisi kanan Emulator Android Studio), simpan ke dalam folder `screenshots/` di dalam project kamu, lalu masukkan ke tabel di bawah ini.

| 1. Splash / Welcome | 2. Sign Up | 3. Login User | 4. Register |
| ----- | ----- | ----- | ----- |
|  |  |  |  |

| 5. Home (Menu) | 6. Profile | 7. Alamat Pengiriman | 8. Konfirmasi Pesanan |
| ----- | ----- | ----- | ----- |
|  |  |  |  |

## 📤 Cara Mengunggah Project ke GitHub

### Cara 1: Langsung dari Menu Android Studio (Paling Mudah)

1. Pastikan kamu sudah login akun GitHub di Android Studio (**File ➔ Settings ➔ Version Control ➔ GitHub**).
2. Klik menu **VCS** di bagian atas ➔ pilih **Share Project on GitHub** (atau **Git ➔ GitHub ➔ Share Project on GitHub**).
3. Beri nama repository misalnya `kopi-dan-nyemil-android`, lalu klik **Share**.
4. Centang semua file termasuk `README.md`, tulis pesan commit `"Initial commit: Aplikasi Kopi dan Nyemil (Java & XML)"`, lalu klik **Add**.

### Cara 2: Menggunakan Terminal / Git Bash

Jalankan perintah berikut di **Terminal** Android Studio (bagian bawah):

```bash
git init
git add .
git commit -m "Implementasi aplikasi Android Kopi dan Nyemil menggunakan Java dan XML"
git branch -M main
git remote add origin https://github.com/USERNAME_KAMU/kopi-dan-nyemil-android.git
git push -u origin main
```
