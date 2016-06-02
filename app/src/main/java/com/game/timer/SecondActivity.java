package com.game.timer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by faisaljaffer on 2016-05-25.
 */
public class SecondActivity extends Activity {
    Canvas canvas;
    Paint paint;
    public static int text;
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String c = "0";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("new_variable_name");
            text = Integer.valueOf(value);
            Log.i(c, value);


        }
        if (text == 0){
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            //intent.putExtra("new_variable_name", txt.getText());
            startActivity(intent);
        }
        setContentView(new CustomView(this));


    }

}
