package com.websaya.m_sismalv4.ui.desa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.websaya.m_sismalv4.ui.regmal1.Regmal1InputActivity;

import java.util.Calendar;

public class DesaDatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    public DesaDatePickerFragment DatePickerFragment(){
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
        InputDesaActivity activity = (InputDesaActivity) getActivity();
        activity.processDatePickerResult(year, month, day, activity.datePickerIdx);
    }

}
