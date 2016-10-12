package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Josh on 10/2/2016.
 */

public class TimePickerFragment2 extends DialogFragment {
    private View form = null;
    public static final String EXTRA_MINUTE = "com.bignerdranch.android.criminalintent.hour";
    public static final String EXTRA_HOUR = "com.bignerdranch.android.criminalintent.minute";

    public static TimePickerFragment2 newInstance(Fragment fragment, int code, String title){
        Bundle args = new Bundle();
        args.putString("String",title);

        TimePickerFragment2 picker = new TimePickerFragment2();
        picker.setArguments(args);
        picker.setTargetFragment(fragment,code);
        return picker;
    }

    private void sendResult(int resultCode, int hour, int minute){
        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_HOUR,hour);
        intent.putExtra(EXTRA_MINUTE,minute);
        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,intent);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        form =
                getActivity().getLayoutInflater()
                        .inflate(R.layout.time_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return (builder.setTitle(getArguments().getString("String"))
                .setView(form)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int hour;
                        int minute;
                        if(Build.VERSION.SDK_INT>=23) {
                          //hour = .getCurrentHour();
                          //  minute = timePicker2.getCurrentMinute();
                        }else{
                          //  hour = timePicker.getCurrentHour();
                          //  minute = timePicker.getCurrentMinute();
                        }
                       // sendResult(Activity.RESULT_OK,hour,minute);
                    }
                })
                .setNegativeButton(android.R.string.cancel, null).create());
    }


    @Override
    public void onDismiss(DialogInterface unused) {
        super.onDismiss(unused);
        Log.d(getClass().getSimpleName(), "Goodbye!");
    }

    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
        Toast.makeText(getParentFragment().getContext(), "NAH", Toast.LENGTH_LONG).show();
    }
}

