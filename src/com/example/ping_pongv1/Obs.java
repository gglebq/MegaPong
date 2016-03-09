package com.example.ping_pongv1;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class Obs {

	protected int x;
	protected int y;
	
	private Bitmap bmp;
	
	
	public Obs(int x ,int y ,Bitmap bmp ,View v)
	{
		super();
		this.x = x;
		this.y = y;
		this.bmp = bmp;
		
	//	bmp = BitmapFactory.decodeResource(v.getResources(),R.drawable.ic_launcher);
		
	}
	public void draw(Canvas canvas){
		canvas.drawBitmap(bmp, x, y, null);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int bmpGetWidth(){
		return this.bmp.getWidth();
	}
	
	public int bmpGetHeight(){
		return this.bmp.getHeight();
	}
	
}

