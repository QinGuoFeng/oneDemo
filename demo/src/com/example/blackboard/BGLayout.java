package com.example.blackboard;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BGLayout extends LinearLayout {
	Context mContext;
	int screenWidth, screenHeight;
	int lastX, lastY, left, top, right, bottom;

	public BGLayout(Context context) {
		super(context);

		DisplayMetrics dm = getResources().getDisplayMetrics(); // 用于获取分辨率
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;

		int width = (int) (screenWidth * 1.5);
		int height = (int) (screenHeight * 1.5);
		Log.e("-----", "屏幕宽度：" + screenWidth);
		Log.e("-----", "屏幕高度：" + screenHeight);
		Log.e("-----", "1.5屏幕宽度：" + width);
		Log.e("-----", "1.5屏幕高度：" + height);
	}

	
	
	// 如果拦截则返回true
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.e("-----", "11");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.e("-----", "12");
			break;
		case MotionEvent.ACTION_UP:
			Log.e("-----", "13");
			break;
		default:
			break;
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.e("-----", "31");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.e("-----", "32");
			break;
		case MotionEvent.ACTION_UP:
			Log.e("-----", "33");
			break;

		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			lastX = (int) event.getRawX();
			lastY = (int) event.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:
			int dx =(int)event.getRawX() - lastX;
			int dy =(int)event.getRawY() - lastY;
			left = getLeft() + dx;
			top = getTop() + dy;
			right = getRight() + dx;
			bottom = getBottom() + dy;
			
			if(top > 0){
				top = 0;
				bottom = top + getHeight();
			}					
			if(bottom < screenHeight){
				bottom = screenHeight;
				top = bottom - getHeight();
			}
			if(left > 0){
				left = 0;
				right = left + getWidth();
			}
			if(right < screenWidth){
				right = screenWidth;
				left = right - getWidth();
			}
			layout(left, top, right, bottom);	// 重新布局
			lastX = (int) event.getRawX();
			lastY = (int) event.getRawY();
			break;
		default:
			break;
		}
		return true;
	}

	
	// 当前不允许拦截，即设置disallowIntercept =true，
	@Override
	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		Log.e("-----", "44");
		super.requestDisallowInterceptTouchEvent(disallowIntercept);
	}
}