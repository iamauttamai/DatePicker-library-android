package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 月份选择器
 * <p>
 * Picker for Months
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelMonthPicker extends WheelPicker implements IWheelMonthPicker {
    private int mSelectedMonth;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    public WheelMonthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 12; i++)
            data.add(intToMonth(i));

        super.setData(data);

        mSelectedMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        updateSelectedYear();
    }

    private String intToMonth(int month) {
        switch(month) {
            case 1 :return "January";
            case 2 :return "February";
            case 3 :return "March";
            case 4 :return "April";
            case 5 :return "May";
            case 6 :return "June";
            case 7 :return "July";
            case 8 :return "August";
            case 9 :return "September";
            case 10 :return "October";
            case 11:return "November";
            case 12 :return "December";
            default : return "etc";
        }
    }

    private void updateSelectedYear() {
        setSelectedItemPosition(mSelectedMonth - 1);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override
    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    @Override
    public void setSelectedMonth(int month) {
        mSelectedMonth = month;
        updateSelectedYear();
    }

    @Override
    public int getCurrentMonth() {
        return getCurrentItemPosition();//Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }
}