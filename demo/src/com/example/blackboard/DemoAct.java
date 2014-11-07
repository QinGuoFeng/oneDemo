package com.example.blackboard;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;

@SuppressWarnings("deprecation")
public class DemoAct extends Activity {
	AbsoluteLayout layout;
	BGLayout bglayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		DisplayMetrics dm = getResources().getDisplayMetrics();		// 用于获取分辨率
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		int width = (int) (screenWidth * 1.5);
		int height = (int) (screenHeight * 1.5);
		
		layout = new AbsoluteLayout(this);
		bglayout = new BGLayout(this);
		bglayout.setBackgroundColor(Color.CYAN);
		bglayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(width, height);
		
		Button b1 = new Button(this);
		b1.setText("按  钮1");
		LinearLayout.LayoutParams bl1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		Button b2 = new Button(this);
		b2.setText("按  钮2");
		LinearLayout.LayoutParams bl2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		bl2.setMargins(width * 2 / 3 - 50, 0, 0, 0);
		Button b3 = new Button(this);
		b3.setText("按  钮3");
		LinearLayout.LayoutParams bl3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		Button b4 = new Button(this);
		b4.setText("按  钮4");
		LinearLayout.LayoutParams bl4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		bl4.setMargins(0, 600, 0, 0);
		
		bglayout.addView(b1, bl1);
		bglayout.addView(b2, bl2);
		bglayout.addView(b3, bl3);
		bglayout.addView(b4, bl4);
		layout.addView(bglayout, ll);
		
		setContentView(layout);
	}
}