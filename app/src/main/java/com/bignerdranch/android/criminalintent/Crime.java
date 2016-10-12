package com.bignerdranch.android.criminalintent;

import android.widget.Button;
import android.widget.CheckBox;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Josh on 6/20/2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private int mHour = 0;
    private int mMinute = 0;

    public Crime(){
        //Generate unique ID
        mId = UUID.randomUUID();
        mDate = new Date();
        mHour = 0;
        mMinute = 0;
        mTitle = "";
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
        mHour = 0;
        mMinute = 0;
        mTitle = "";
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public int getmHour() {
        return mHour;
    }

    public void setmHour(int mHour) {
        this.mHour = mHour;
    }

    public int getmMinute() {
        return mMinute;
    }

    public void setmMinute(int mMinute) {
        this.mMinute = mMinute;
    }

}
