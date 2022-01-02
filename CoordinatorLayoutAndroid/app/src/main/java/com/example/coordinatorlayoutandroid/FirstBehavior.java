package com.example.coordinatorlayoutandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class FirstBehavior extends CoordinatorLayout.Behavior<TextView> {
    public FirstBehavior() {

    }

    public FirstBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent,
                                         TextView child, MotionEvent ev) {
        //Hàm này nhận sự kiện Touch (down) ban đầu nếu nhấn trong CoordinatorLayout
        //Nếu thiết lập trả về true thì onToucheEvent sẽ nhận các sự kiện
        //Tiếp theo và các View con khác không nhận được Touch

        child.setText(ev.getAction()+"|"+(int)ev.getX()+"|"+(int)ev.getY());
        return true;

    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent,
                                TextView child, MotionEvent ev) {
        child.setText(ev.getAction()+"|"+(int)ev.getX()+"|"+(int)ev.getY());
        return true;
    }


}