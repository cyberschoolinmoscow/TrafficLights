package com.kkatia.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class Oicture extends SurfaceView
{
    @Override
    protected void onDraw
            (Canvas
                    can){
        super.onDraw(can);
    }

    public Oicture(Context context) {
        super(context);
    }
}