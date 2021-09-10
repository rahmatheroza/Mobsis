package com.websaya.m_sismalv4.ui.regmal1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Regmal1DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    public Regmal1DatePickerFragment DatePickerFragment(){
        return null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker,
                          int year, int month, int day) {
        Regmal1InputActivity activity = (Regmal1InputActivity) getActivity();
        activity.processDatePickerResult(year, month, day, activity.datePickerIdx);
    }

}
