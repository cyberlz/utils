package com.catnull.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  Name : ToastUtil
 *  description :
 *
 *  @author catnull
 *  created at 2018/5/25
 */

public class ToastUtil{

    private static Toast mToast;

    @SuppressLint("NewApi")
    public static void showShortToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    @SuppressLint("NewApi")
    public static void showLongToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
    public static void showToast(Context context, CharSequence text, int duration) {
        if(mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }

        LinearLayout view = (LinearLayout) mToast.getView();
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.anim_toast);
        view.setAnimation(anim);
        view.setBackgroundResource(R.drawable.bg_toast);
        view.setPadding(8,6,8,6);
        TextView fonts = (TextView)view.getChildAt(0);
        fonts.setTextSize(12);
        fonts.setTextColor(context.getColor(R.color.white));
        mToast.setView(view);
        mToast.setGravity(Gravity.BOTTOM , 0, 160);
        mToast.show();
    }
}