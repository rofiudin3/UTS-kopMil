package com.example.kopmil

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Container 8 Halaman sesuai Wireframe
    private lateinit var screenSplash: LinearLayout
    private lateinit var screenSignUp: LinearLayout
    private lateinit var screenLogin: LinearLayout
    private lateinit var screenRegister: LinearLayout
    private lateinit var screenHome: ScrollView
    private lateinit var screenProfile: LinearLayout
    private lateinit var screenAddressOrder: ScrollView
    private lateinit var screenConfirmation: LinearLayout
    private lateinit var layoutBottomNav: LinearLayout

    // Elemen Input & Teks Dinamis
    private lateinit var etLoginUsername: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var etRegFullName: EditText
    private lateinit var etRegUsername: EditText
    private lateinit var etRegPassword: EditText
    private lateinit var etProfileName: EditText
    private lateinit var etOrderFullName: EditText
    private lateinit var etOrderAddress: EditText
    private lateinit var etOrderLandmark: EditText

    private lateinit var tvHomeGreeting: TextView
    private lateinit var tvProfileGreeting: TextView
    private lateinit var tvConfirmGreeting: TextView
    private lateinit var tvSelectedMenuSummary: TextView
    private lateinit var tvConfirmOrderSummary: TextView

    // Tombol Navigasi Bawah
    private lateinit var btnNavHome: Button
    private lateinit var btnNavOrder: Button
    private lateinit var btnNavProfile: Button

    // Data Statis (Dummy Data) Pengguna & Pesanan
    private var currentUserName: String = "Budi Santoso"
    private var selectedMenuName: String = "Kopi Susu Gula Aren"
    private var selectedMenuPrice: String = "Rp 22.000"
    private var currentScreenId: Int = 1 // 1=Splash, 2=SignUp, 3=Login, 4=Register, 5=Home, 6=Profile, 7=Order, 8=Confirm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        applyModernRoundedStyling()
        setupClickListeners()
        setupBackNavigation()

        // Tampilkan layar pertama (1. Splash / Welcome)
        showScreen(1)
    }

    private fun initViews() {
        // Inisialisasi 8 Layar
        screenSplash = findViewById(R.id.screenSplash)
        screenSignUp = findViewById(R.id.screenSignUp)
        screenLogin = findViewById(R.id.screenLogin)
        screenRegister = findViewById(R.id.screenRegister)
        screenHome = findViewById(R.id.screenHome)
        screenProfile = findViewById(R.id.screenProfile)
        screenAddressOrder = findViewById(R.id.screenAddressOrder)
        screenConfirmation = findViewById(R.id.screenConfirmation)
        layoutBottomNav = findViewById(R.id.layoutBottomNav)

        // Inisialisasi EditText Login & Register
        etLoginUsername = findViewById(R.id.etLoginUsername)
        etLoginPassword = findViewById(R.id.etLoginPassword)
        etRegFullName = findViewById(R.id.etRegFullName)
        etRegUsername = findViewById(R.id.etRegUsername)
        etRegPassword = findViewById(R.id.etRegPassword)

        // Inisialisasi EditText Profile & Order
        etProfileName = findViewById(R.id.etProfileName)
        etOrderFullName = findViewById(R.id.etOrderFullName)
        etOrderAddress = findViewById(R.id.etOrderAddress)
        etOrderLandmark = findViewById(R.id.etOrderLandmark)

        // Inisialisasi TextView Sapaan ("Halo Nama,") & Ringkasan Pesanan
        tvHomeGreeting = findViewById(R.id.tvHomeGreeting)
        tvProfileGreeting = findViewById(R.id.tvProfileGreeting)
        tvConfirmGreeting = findViewById(R.id.tvConfirmGreeting)
        tvSelectedMenuSummary = findViewById(R.id.tvSelectedMenuSummary)
        tvConfirmOrderSummary = findViewById(R.id.tvConfirmOrderSummary)

        // Inisialisasi Tombol Bottom Navigation
        btnNavHome = findViewById(R.id.btnNavHome)
        btnNavOrder = findViewById(R.id.btnNavOrder)
        btnNavProfile = findViewById(R.id.btnNavProfile)
    }

    private fun applyModernRoundedStyling() {
        // Lingkaran penuh untuk Logo di Splash & Lingkaran OK di Konfirmasi Pesanan
        findViewById<View>(R.id.logoCircle).background = createCircleDrawable("#F3CFA6")
        findViewById<View>(R.id.okCircle).background = createCircleDrawable("#A8E6CF")

        // Banner Sign Up & Ringkasan Menu
        findViewById<View>(R.id.bannerSignUp).background = createRoundedDrawable("#FFF3E6", 40f, "#F0D9C0", 2)
        tvSelectedMenuSummary.background = createRoundedDrawable("#FFF3E6", 24f, "#F0D9C0", 2)
        tvConfirmOrderSummary.background = createRoundedDrawable("#FFF3E6", 24f, "#F0D9C0", 2)

        // Kartu 6 Menu Makanan & Minuman di Home
        val cardIds = intArrayOf(
            R.id.cardMenu1, R.id.cardMenu2, R.id.cardMenu3,
            R.id.cardMenu4, R.id.cardMenu5, R.id.cardMenu6
        )
        for (id in cardIds) {
            findViewById<View>(id).background = createRoundedDrawable("#FFF3E6", 32f, "#F0D9C0", 3)
        }

        // Kotak "Foto" pada setiap kartu menu
        val fotoIds = intArrayOf(
            R.id.fotoBox1, R.id.fotoBox2, R.id.fotoBox3,
            R.id.fotoBox4, R.id.fotoBox5, R.id.fotoBox6
        )
        for (id in fotoIds) {
            findViewById<View>(id).background = createRoundedDrawable("#F3CFA6", 24f, "#E3B98B", 0)
        }

        // Kolom Input (EditText) dengan garis tepi rapi sesuai wireframe
        val inputs = arrayOf(
            etLoginUsername, etLoginPassword,
            etRegFullName, etRegUsername, etRegPassword,
            etProfileName,
            etOrderFullName, etOrderAddress, etOrderLandmark
        )
        for (et in inputs) {
            et.background = createRoundedDrawable("#FFFFFF", 24f, "#BDBDBD", 3)
        }
    }

    private fun setupClickListeners() {
        // 1. SPLASH SCREEN -> SIGN UP
        findViewById<Button>(R.id.btnStartNow).setOnClickListener {
            showScreen(2)
        }

        // 2. SIGN UP SCREEN -> REGISTER ATAU LOGIN
        findViewById<Button>(R.id.btnGoToRegister).setOnClickListener {
            showScreen(4)
        }
        findViewById<Button>(R.id.btnGoToLogin).setOnClickListener {
            showScreen(3)
        }

        // 3. LOGIN SCREEN -> HOME
        findViewById<Button>(R.id.btnLoginSubmit).setOnClickListener {
            val user = etLoginUsername.text.toString().trim()
            val pass = etLoginPassword.text.toString().trim()
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Silakan isi username dan password!", Toast.LENGTH_SHORT).show()
            } else {
                currentUserName = user.replaceFirstChar { it.uppercase() }
                updateUserGreetings()
                Toast.makeText(this, "Login Berhasil! Selamat datang, $currentUserName", Toast.LENGTH_SHORT).show()
                showScreen(5)
            }
        }
        findViewById<Button>(R.id.btnLoginBack).setOnClickListener {
            showScreen(2)
        }

        // 4. REGISTER SCREEN -> HOME
        findViewById<Button>(R.id.btnRegisterSubmit).setOnClickListener {
            val fullName = etRegFullName.text.toString().trim()
            val user = etRegUsername.text.toString().trim()
            val pass = etRegPassword.text.toString().trim()
            if (fullName.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua kolom Register!", Toast.LENGTH_SHORT).show()
            } else {
                currentUserName = fullName
                updateUserGreetings()
                Toast.makeText(this, "Registrasi Berhasil! Halo $currentUserName", Toast.LENGTH_SHORT).show()
                showScreen(5)
            }
        }
        findViewById<Button>(R.id.btnRegisterBack).setOnClickListener {
            showScreen(2)
        }

        // 5. HOME SCREEN: Klik salah satu dari 6 item menu untuk memesan
        findViewById<View>(R.id.cardMenu1).setOnClickListener {
            selectMenuAndOrder("Kopi Susu Gula Aren", "Rp 22.000")
        }
        findViewById<View>(R.id.cardMenu2).setOnClickListener {
            selectMenuAndOrder("Donat Cokelat", "Rp 12.000")
        }
        findViewById<View>(R.id.cardMenu3).setOnClickListener {
            selectMenuAndOrder("Sourdough Loaf", "Rp 35.000")
        }
        findViewById<View>(R.id.cardMenu4).setOnClickListener {
            selectMenuAndOrder("Cappuccino", "Rp 25.000")
        }
        findViewById<View>(R.id.cardMenu5).setOnClickListener {
            selectMenuAndOrder("Matcha Latte", "Rp 27.000")
        }
        findViewById<View>(R.id.cardMenu6).setOnClickListener {
            selectMenuAndOrder("Croissant Butter", "Rp 24.000")
        }

        // 6. PROFILE SCREEN: Simpan perubahan nama
        findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val newName = etProfileName.text.toString().trim()
            if (newName.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                currentUserName = newName
                updateUserGreetings()
                Toast.makeText(this, "Profil berhasil disimpan!", Toast.LENGTH_SHORT).show()
            }
        }

        // 7. ALAMAT PENGIRIMAN (ORDER) -> KONFIRMASI PESANAN
        findViewById<Button>(R.id.btnOrderSubmit).setOnClickListener {
            val recipient = etOrderFullName.text.toString().trim()
            val address = etOrderAddress.text.toString().trim()
            val landmark = etOrderLandmark.text.toString().trim()

            if (recipient.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi Nama Lengkap dan Alamat pengiriman!", Toast.LENGTH_SHORT).show()
            } else {
                val landmarkInfo = if (landmark.isEmpty()) "" else " ($landmark)"
                val summary = "Menu: $selectedMenuName ($selectedMenuPrice)\nPenerima: $recipient\nAlamat: $address$landmarkInfo"
                tvConfirmOrderSummary.text = summary
                showScreen(8)
            }
        }

        // 8. KONFIRMASI PESANAN -> KEMBALI KE HOME
        findViewById<Button>(R.id.btnConfirmOk).setOnClickListener {
            showScreen(5)
        }

        // BOTTOM NAVIGATION BAR (Home | Order | Profile)
        btnNavHome.setOnClickListener {
            showScreen(5)
        }
        btnNavOrder.setOnClickListener {
            if (etOrderFullName.text.toString().trim().isEmpty()) {
                etOrderFullName.setText(currentUserName)
            }
            showScreen(7)
        }
        btnNavProfile.setOnClickListener {
            etProfileName.setText(currentUserName)
            showScreen(6)
        }
    }

    private fun selectMenuAndOrder(menuName: String, price: String) {
        selectedMenuName = menuName
        selectedMenuPrice = price
        tvSelectedMenuSummary.text = "Pesanan: $selectedMenuName ($selectedMenuPrice)"
        if (etOrderFullName.text.toString().trim().isEmpty()) {
            etOrderFullName.setText(currentUserName)
        }
        Toast.makeText(this, "$menuName dipilih. Silakan isi alamat pengiriman.", Toast.LENGTH_SHORT).show()
        showScreen(7)
    }

    private fun updateUserGreetings() {
        val greetingText = "Halo $currentUserName,"
        tvHomeGreeting.text = greetingText
        tvProfileGreeting.text = greetingText
        tvConfirmGreeting.text = greetingText
        etProfileName.setText(currentUserName)
        etOrderFullName.setText(currentUserName)
    }

    private fun showScreen(screenNumber: Int) {
        currentScreenId = screenNumber

        screenSplash.visibility = if (screenNumber == 1) View.VISIBLE else View.GONE
        screenSignUp.visibility = if (screenNumber == 2) View.VISIBLE else View.GONE
        screenLogin.visibility = if (screenNumber == 3) View.VISIBLE else View.GONE
        screenRegister.visibility = if (screenNumber == 4) View.VISIBLE else View.GONE
        screenHome.visibility = if (screenNumber == 5) View.VISIBLE else View.GONE
        screenProfile.visibility = if (screenNumber == 6) View.VISIBLE else View.GONE
        screenAddressOrder.visibility = if (screenNumber == 7) View.VISIBLE else View.GONE
        screenConfirmation.visibility = if (screenNumber == 8) View.VISIBLE else View.GONE

        val showBottomBar = (screenNumber == 5 || screenNumber == 6 || screenNumber == 7)
        layoutBottomNav.visibility = if (showBottomBar) View.VISIBLE else View.GONE

        if (showBottomBar) {
            updateBottomNavSelection(screenNumber)
        }
    }

    private fun updateBottomNavSelection(activeScreen: Int) {
        styleBottomNavButton(btnNavHome, activeScreen == 5)
        styleBottomNavButton(btnNavOrder, activeScreen == 7)
        styleBottomNavButton(btnNavProfile, activeScreen == 6)
    }

    private fun styleBottomNavButton(button: Button, isSelected: Boolean) {
        if (isSelected) {
            button.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#1E1E1E"))
            button.setTextColor(Color.WHITE)
        } else {
            button.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F5F5F5"))
            button.setTextColor(Color.parseColor("#424242"))
        }
    }

    private fun setupBackNavigation() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when (currentScreenId) {
                    2 -> showScreen(1)
                    3, 4 -> showScreen(2)
                    6, 7, 8 -> showScreen(5)
                    else -> finish()
                }
            }
        })
    }

    private fun createCircleDrawable(fillColorHex: String): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(Color.parseColor(fillColorHex))
        }
    }

    private fun createRoundedDrawable(
        fillColorHex: String,
        radiusPx: Float,
        strokeColorHex: String,
        strokeWidthPx: Int
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radiusPx
            setColor(Color.parseColor(fillColorHex))
            if (strokeWidthPx > 0) {
                setStroke(strokeWidthPx, Color.parseColor(strokeColorHex))
            }
        }
    }
}