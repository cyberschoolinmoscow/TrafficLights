package com.kkatia.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    //inner class
    class TestThread extends Thread {

        public void run() {
            Canvas canvas = null;
            while (drawing) {
                try {
                    Paint paint = new Paint();
                    canvas = getHolder().lockCanvas();
                    canvas.drawColor(Color.GREEN);
                    getHolder().unlockCanvasAndPost(canvas);
                    Thread.sleep(1000);

                    canvas = getHolder().lockCanvas();

                    canvas.drawColor(Color.YELLOW);
                    getHolder().unlockCanvasAndPost(canvas);

                    Thread.sleep(1000);
                    canvas = getHolder().lockCanvas();

                    canvas.drawColor(Color.RED);
                    getHolder().unlockCanvasAndPost(canvas);
                    Thread.sleep(1000);
                    synchronized (getHolder()) {
                    }
                } catch (Exception e) {
                } finally {
                }

            }
        }
    }


    private Thread t;


    private boolean drawing;
    private final SurfaceHolder holder;


    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        drawing = true;
        holder = getHolder();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        t = new TestThread();
        t.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawing = false;
        t.stop();
    }
}