package com.midhilaj.newshoping.Milla;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by midhilaj on 5/6/17.
 */

public class Millamon {
    public static void startnewActivity(Activity mActivity,Class classname){
        try{
            Intent myIntent = new Intent(mActivity, classname);
            mActivity.startActivity(myIntent);
            //MainProcess.setDefaultsGson("firstpage",mDataSet.get(position),mActivity);
        }
        catch (Exception e){
            Log.e("start new activity",e.toString());

        }
    }

    public static int calculateNoOfColumns(Activity mainActivity) {


        DisplayMetrics displayMetrics = mainActivity.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 130);
        //   int noOfColumns = (int) (dpWidth / 220);
        return noOfColumns;


    }



    public static int calculateNoOfColumns(Activity mainActivity,int Count) {


        DisplayMetrics displayMetrics = mainActivity.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / Count);
        //   int noOfColumns = (int) (dpWidth / 220);
        return noOfColumns;


    }
    public static  Double MakePrize(String str){
        return  Double.parseDouble(str.replaceAll("[^\\d.]", ""));
    }
}
