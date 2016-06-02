package com.game.timer;

/**
 * Created by faisaljaffer on 2016-05-30.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class CustomView extends View {

    private Rect rectangle;
    private Paint paint;
    public String num="";
    int x = 50;
    int y = 50;
    public int sec = 0;
    public int height;
    public int v=0;



    public int sideLength = 400;
    public CustomView(Context context) {
        super(context);
        sec = SecondActivity.text;
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(metrics);
        int width1 = metrics.widthPixels;
        int height1 = metrics.heightPixels;

        rectangle = new Rect(x, y, 200, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
        final CounterClass timer = new CounterClass(sec*1000, 1000);
        Log.i(num, String.valueOf(sec));
        timer.start();
        View view;
        sideLength = height1;
        height = height1;


    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(0,v,canvas.getWidth(),sideLength,paint);

        Paint paint = new Paint();


        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText(num, canvas.getWidth()/2, canvas.getHeight()/2, paint);
        invalidate();




    }




    public class CounterClass extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;

            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toHours(millis)));
            System.out.println(hms);
            num = hms;
           v = v + height/sec;
        }

        @Override
        public void onFinish() {
            num = "Finished";
            SecondActivity.text = 0;
            Context context = getContext();
            Intent i = new Intent(context, ThirdActivity.class);
            context.startActivity(i);
        }
    }
}
