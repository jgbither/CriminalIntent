package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import java.util.zip.Inflater;


/**
 * Created by Josh on 9/30/2016.
 */

public class TimePickerFragment extends DialogFragment {

    private static final String ARG_HOUR = "hour";
    private static final String ARG_MINUTE  = "minute";
    public static final String EXTRA_MINUTE = "com.bignerdranch.android.criminalintent.hour";
    public static final String EXTRA_HOUR = "com.bignerdranch.android.criminalintent.minute";
    private static TimePicker timePicker;

    public static TimePickerFragment newInstance(int hour, int minute){
        Bundle args = new Bundle();
        args.putSerializable(ARG_HOUR,hour);
        args.putSerializable(ARG_MINUTE,minute);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour = (int) getArguments().getSerializable(ARG_HOUR);
        int minute = (int) getArguments().getSerializable(ARG_MINUTE);


        View v = View.inflate(getActivity(),R.layout.time_dialog,null);
        timePicker = (TimePicker) v.findViewById(R.id.time_dialog_picker);
        if(Build.VERSION.SDK_INT>=23) {
            //timePicker.setCurrentHour(hour);
            //timePicker.setCurrentMinute(minute);
        }else{
            //timePicker.setCurrentHour(hour);
            //timePicker.setCurrentMinute(minute);
        }

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("TIME BOYYY")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int hour;
                        int minute;
                        if(Build.VERSION.SDK_INT>=23) {
                            hour = timePicker.getCurrentHour();
                            minute = timePicker.getCurrentMinute();
                        }else{
                            hour = timePicker.getCurrentHour();
                            minute = timePicker.getCurrentMinute();
                        }
                        sendResult(Activity.RESULT_OK,hour,minute);
                    }
                })
                .create();
    }
}
