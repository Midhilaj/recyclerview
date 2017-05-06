package com.midhilaj.newshoping.recycleview.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.midhilaj.newshoping.R;

import java.util.List;
import java.util.Random;

/**
 * Created by midhilaj on 5/6/17.
 */


public class MillaAdapter    extends RecyclerView.Adapter<MillaAdapter.ViewHolder>{
    private List mDataSet;
    private Context mContext;
    Activity mActivity;
    private static Random mRandom = new Random();

    public MillaAdapter(Activity activity,Context context,List DataSet){
        mDataSet = DataSet;
        mContext = context;
        mActivity=activity;
    }





    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mproduct_name,out_of_stoke;


        public ViewHolder(View v){
            super(v);

            //mrp.setPaintFlags(mrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


            int color = Color.argb(255, getRandomHSVColor(), getRandomHSVColor(), getRandomHSVColor());

            // linearLayout.setBackgroundColor(color);
            mproduct_name=(TextView)v.findViewById(R.id.textView1);
            mproduct_name.setBackgroundColor(color);



        }

    }
    public static Bitmap createImage(int width, int height, int color) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(0F, 0F, (float) width, (float) height, paint);
        return bitmap;
    }
    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getLayout() {
        return layout;
    }

    public int layout=R.layout.listiteam;//productlist;

    @Override
    public MillaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(layout,parent,false);
        {
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
    }
    String isadmin=null;
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){

            String pn="milla ";//mDataSet.get(position).getP_name().substring(0, 1).toUpperCase() + mDataSet.get(position).getP_name().substring(1);
            holder.mproduct_name.setText(mDataSet.get(position).toString());

    }
    private void onclick(int position){

    }

    @Override
    public int getItemCount(){
        if(mDataSet!=null) {
            return mDataSet.size();
        }
        else return 0;
    }

    // Custom method to get a random number between a range
    //  protected int getRandomIntInRange(int max, int min){
    //    return mRandom.nextInt((max-min)+min)+min;
    //}

    // Custom method to generate random HSV color
    protected static int getRandomHSVColor(){
        // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);
        // We make the color depth full
        float saturation = 1.0f;
        // We make a full bright color
        float value = 1.0f;
        // We avoid color transparency
        int alpha = 255;
        // Finally, generate the color
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color
        return color;
    }
    private int mycolors(){
        int color;
        int r1=255,r2=229,r3=204;
        color= Color.argb(255,r1,r2,r3);
        return color;
    }
    public void removeAt(int position) {
        mDataSet.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataSet.size());

    }
}
