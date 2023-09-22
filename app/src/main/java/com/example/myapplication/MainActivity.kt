package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val jenis = arrayOf(
        "Executive",
        "Bussiness",
        "Economy"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            val jenisAdapter = ArrayAdapter(this@MainActivity,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jenis)
            jenisAdapter.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = jenisAdapter


//            pickDate.init(pickDate.year, pickDate.month, pickDate.dayOfMonth)
//            {_, year, monthOfYear, dayOfMonth ->
//                val selectedDate = "$dayOfMonth/${monthOfYear+1}/$year"
//
//                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
//            }
//
//            pickTime.setOnTimeChangedListener{ view, hoursOfDay, minute ->
//                val selectedTime = String.format("%02d:%02d", hoursOfDay, minute)
//
//                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
//            }

            val button = binding.orderBtn

            button.setOnClickListener{
                //Ambil data dari DatePicker
                val hari = binding.pickDate.dayOfMonth
                val bulan = binding.pickDate.month
                val tahun = binding.pickDate.year

                //Ambil waktu dari Timepicker
                val jam = binding.pickTime.hour
                val menit = binding.pickTime.minute

                // Format tanggal dan waktu ke dalam sebuah pesan
                val formatTanggal = "$hari/${bulan + 1}/$tahun"
                val formatWaktu = String.format("%02d:%02d", jam, menit)
                val message = "Tiket $formatTanggal - $formatWaktu berhasil dipesan"

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            }
        }




        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }
}
