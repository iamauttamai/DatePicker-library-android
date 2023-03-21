package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * 年份选择器
 * <p>
 * Picker for Years
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelYearPickerTH extends WheelPicker implements IWheelYearPicker {
    private int mYearStart = 1970, mYearEnd = 3000;
    private int mSelectedYear;
    private Locale locale;

    public WheelYearPickerTH(Context context) {
        this(context, null);
    }

    public WheelYearPickerTH(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        }else locale = context.getResources().getConfiguration().locale;

        updateYears();
        mSelectedYear = Calendar.getInstance().get(Calendar.YEAR);
        updateSelectedYear();
    }

    private void updateYears() {
        List<Integer> data = new ArrayList<>();
        for (int i = mYearStart; i <= mYearEnd; i++)
            data.add(i+(locale.getISO3Language().startsWith("th") ? 543:0));
        super.setData(data);
    }

    private void updateSelectedYear() {
        setSelectedItemPosition(mSelectedYear - mYearStart);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelYearPicker");
    }

    @Override
    public void setYearFrame(int start, int end) {
        mYearStart = start;
        mYearEnd = end;
        mSelectedYear = getCurrentYear();
        updateYears();
        updateSelectedYear();
    }

    @Override
    public int getYearStart() {
        return mYearStart;
    }

    @Override
    public void setYearStart(int start) {
        mYearStart = start;
        mSelectedYear = getCurrentYear();
        updateYears();
        updateSelectedYear();
    }

    @Override
    public int getYearEnd() {
        return mYearEnd;
    }

    @Override
    public void setYearEnd(int end) {
        mYearEnd = end;
        updateYears();
    }

    @Override
    public int getSelectedYear() {
        return mSelectedYear;
    }

    @Override
    public void setSelectedYear(int year) {
        mSelectedYear = year;
        updateSelectedYear();
    }

    @Override
    public int getCurrentYear() {
        if(locale.getISO3Language().startsWith("th")){
            return Integer.parseInt(String.valueOf(getData().get(getCurrentItemPosition()))) - 543;
        }else {
            return Integer.parseInt(String.valueOf(getData().get(getCurrentItemPosition())));
        }
//        return Integer.parseInt(String.valueOf(getData().get(getCurrentItemPosition())))+ (locale.getISO3Language().startsWith("th") ? 543:0);
    }
}