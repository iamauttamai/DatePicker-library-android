package com.iamauttamai.datepicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import com.iamauttamai.datepicker.callback.PickerCallBack
import com.iamauttamai.datepicker.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.chrono.ThaiBuddhistDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDate.setOnClickListener {
            DatePicker(this)
                .setTitle("เลือกวันที่")
                .setConfirm("ตกลง")
                .setTitleColor(Color.parseColor("#005DA8"))
                .setTitleSize(10f)
                .setStartYear(1998)
                .setEndYear(2050)
                .create(object : PickerCallBack {
                    override fun data(data: Date) {
                        // Format the date EN
                        val dateFormat: String = DateFormat.format("yyyy-MM-dd", data).toString()

                        // Create a LocalDate object with the Gregorian calendar date
                        val gregorianDate = LocalDate.parse(dateFormat, DateTimeFormatter.ISO_LOCAL_DATE)

                        // Convert to Thai Buddhist date
                        val buddhistDate = ThaiBuddhistDate.from(gregorianDate)

                        // Format the date TH
                        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy G", Locale("th"))
                        val formattedDate = buddhistDate.format(formatter)

                        Log.e("TAG", "SUCCESS")
                    }
                })
        }
    }
}