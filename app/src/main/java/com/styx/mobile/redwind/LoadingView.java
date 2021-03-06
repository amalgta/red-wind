package com.styx.mobile.redwind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

/**
 * Created by amal.george on 23-03-2017
 */

public class LoadingView extends View {
    private static final String FPS = "FPS: %d";
    LoadingComputations loadingComputations;
    FramesManager framesManager;
    Paint dotPaint, fpsPaint;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        framesManager = new FramesManager();
        loadingComputations = new LoadingComputations(getResources().getDisplayMetrics().density);
        dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fpsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dotPaint.setColor(0xFFB0B0B0);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) loadingComputations.dpToPx(100), (int) loadingComputations.dpToPx(100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // if (framesManager.canGo()) {
            canvas.drawText(String.format(Locale.getDefault(), FPS, framesManager.fps()), 0.f, fpsPaint.getTextSize(), fpsPaint);
            canvas.drawCircle(
                    loadingComputations.dpToPx(50) - loadingComputations.dpToPx(12),
                    loadingComputations.dpToPx(50) - loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 0),
                    loadingComputations.dpToPx(3), dotPaint);
            canvas.drawCircle(
                    loadingComputations.dpToPx(50),
                    loadingComputations.dpToPx(50) - loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 125),
                    loadingComputations.dpToPx(3), dotPaint);
            canvas.drawCircle(
                    loadingComputations.dpToPx(50) + loadingComputations.dpToPx(12),
                    loadingComputations.dpToPx(50) - loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 250),
                    loadingComputations.dpToPx(3), dotPaint);
        //}
        framesManager.frame();
        invalidate();
    }

}
