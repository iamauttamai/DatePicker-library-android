package com.iamauttamai.datepicker

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import com.aigestudio.wheelpicker.widgets.WheelDatePickerTH
import com.iamauttamai.datepicker.callback.PickerCallBack

/**
 * Created by AuttaphonL. on 17,March,2023
 */

class DatePicker {

    private lateinit var context: Context
    private var alertDialog: AlertDialog? = null
    private lateinit var confirm: LinearLayout
    private lateinit var close: LinearLayout
    private lateinit var txtTitle: TextView
    private lateinit var txtConfirm: TextView
    private lateinit var picker: WheelDatePickerTH
    private lateinit var bgSelectDate: FrameLayout
    private val datePicker by lazy { DatePicker(context) }

    constructor(context: Context) {
        this.context = context
    }

    fun setTitle(textTitle: String): DatePicker {
        ThaiDatePickerData.textTitle = textTitle
        return datePicker
    }

    fun setTitleColor(colorTitle: Int): DatePicker {
        ThaiDatePickerData.colorTitle = colorTitle
        return datePicker
    }

    fun setTitleSize(sizeTitle: Float): DatePicker {
        ThaiDatePickerData.sizeTitle = sizeTitle
        return datePicker
    }

    fun setStartYear(year: Int): DatePicker {
        ThaiDatePickerData.startYear = year
        return datePicker
    }

    fun setEndYear(year: Int): DatePicker {
        ThaiDatePickerData.endYear = year
        return datePicker
    }

    fun setDay(day: Int): DatePicker {
        ThaiDatePickerData.day = day
        return datePicker
    }

    fun setMonth(month: Int): DatePicker {
        ThaiDatePickerData.month = month
        return datePicker
    }

    fun setYear(year: Int): DatePicker {
        ThaiDatePickerData.year = year
        return datePicker
    }


    fun create(pickerCallBack: PickerCallBack) {
        val adb = AlertDialog.Builder(context)
        val v = LayoutInflater.from(context).inflate(R.layout.picker_th, null)
        confirm = v.findViewById(R.id.btnConfirm)
        picker = v.findViewById(R.id.pickerDate)
        txtTitle = v.findViewById(R.id.txtTitle)
        close = v.findViewById(R.id.btnClose)
        bgSelectDate = v.findViewById(R.id.bgSelectDate)
        txtConfirm = v.findViewById(R.id.txtConfirm)
        setData()
        setFontAndSizeText()
        adb.setView(v)
        alertDialog = adb.create()
        alertDialog?.window?.attributes?.windowAnimations = R.style.DialogAnimations_SmileWindow
        alertDialog?.setCancelable(false)
        alertDialog?.window?.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
        alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog?.show()
        confirm.setOnClickListener {
            alertDialog?.dismiss()
            pickerCallBack.data(picker.currentDate)
        }
        close.setOnClickListener {
            alertDialog?.dismiss()
        }
    }

    private fun setFontAndSizeText() {
        if (ThaiDatePickerData.sizeTitle != 0f) {
            txtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, ThaiDatePickerData.sizeTitle)
        }
    }

    private fun setData() {
        txtTitle.text = ThaiDatePickerData.textTitle
        txtTitle.setTextColor(ThaiDatePickerData.colorTitle)
        picker.yearStart = ThaiDatePickerData.startYear
        picker.yearEnd = ThaiDatePickerData.endYear
        picker.selectedDay = ThaiDatePickerData.day
        picker.selectedMonth = ThaiDatePickerData.month
        picker.selectedYear = ThaiDatePickerData.year
    }

    object ThaiDatePickerData {
        var textTitle = ""
        var colorTitle = Color.parseColor("#000000")
        var sizeTitle = 0f
        var startYear = 1998
        var endYear = 2050
        var day = 1
        var month = 1
        var year = 1998
    }

}