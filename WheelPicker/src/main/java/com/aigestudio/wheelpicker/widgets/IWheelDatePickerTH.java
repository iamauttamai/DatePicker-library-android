package com.aigestudio.wheelpicker.widgets;

import android.widget.TextView;

import java.util.Date;

public interface IWheelDatePickerTH {
    void setOnDateSelectedListener(WheelDatePickerTH.OnDateSelectedListener listener);

    Date getCurrentDate();

    int getItemAlignYear();

    void setItemAlignYear(int align);

    int getItemAlignMonth();

    void setItemAlignMonth(int align);

    int getItemAlignDay();

    void setItemAlignDay(int align);

    WheelYearPickerTH getWheelYearPickerTH();

    WheelMonthPickerTH getWheelMonthPickerTH();

    WheelDayPicker getWheelDayPicker();

    TextView getTextViewYear();

    TextView getTextViewMonth();

    TextView getTextViewDay();
}