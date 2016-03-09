package com.example.ping_pongv1;

import java.util.Random;

import android.graphics.Bitmap;
import android.view.View;

public class Ball extends Obs implements Runnable{
    private int vx;
    private int vy;
    private View v;
    private Random rnd;
    public MainActivity main;
    private int count = 0;
    //private int g=2;
        
	public Ball(int x, int y, int vx,Bitmap bmp, int vy, View v) {
		super(x, y, bmp, v);
		this.vx = vx;
		this.vy = vy;
		this.v = v;
		rnd = new Random();
		new Thread(this, "Killer").start();
	}
	public void SetY(int y){
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	
	public void SetX(int x){
		this.x = x;
	}
	
	
	public int getVx() {
		return vx;
	}
	
	public void setVx(int vx) {
		this.vx = vx;
	}
	
	
	public int getVy() {
		return vy;
	}
	
	public void setVy(int vy) {
		this.vy = vy;
	}
	@Override
	public void run() {
		while(true)
		{
			x+=vx;
			y+=vy;
			//vy+=g;
			
			if(x < 0 || x > (v.getWidth() - bmpGetWidth())){
				vx=-vx;
			}
			if(y < 0 || y > (v.getHeight() - bmpGetHeight())){
				vy=-vy;
			}
			//start of impact check:
			Player pl = ((MyView)v).getUserPlayer();
			Player host = ((MyView)v).getHost();
				//for(int i = 0 ; i < obs.size() ; i++){
					//int x1 = x;
					int x2 = pl.getX();
					int x3 = host.getX();
					int width = pl.bmpGetWidth();
					//int Hwidth = host.bmpGetWidth();
					//int y1 = y;
					int y2 = pl.getY();
					int y3 = host.getY();
					//int height = pl.bmpGetHeight();
					//int Hheight = host.bmpGetHeight();

					

						//תנאי של השחקן
					if(((y2 - 15) < y) && (y2 > y) && (x > x2) && (x < (x2 + width)) || //שחקן
							((y3 + 15) > y) && (y3 < y) && (x > x3) && (x < (x3 + width))){//מחשב
						//vx = -vx;
						vy = -vy;
						//----------------------------
						vx = (rnd.nextInt(10)-5);
						//vy = -(rnd.nextInt(5)+3);
						//-----------------------------
						/*if(vx > 0) vx = -(rnd.nextInt(5-3)+3);
						if(vx < 0) vx = rnd.nextInt(5-3)+3;
						if(vy > 0) vy = -(rnd.nextInt(5-3)+3);
						if(vy < 0) vy = rnd.nextInt(5-3)+3;*/
						//((MyView)v).killBrick(i);
						//((MyView)v).createKiller();
					}
					if(x == 0 || x == v.getWidth()){
						vx = -vx;
					}
					if(y<v.getHeight()/10 || y>v.getHeight()-v.getHeight()/10){
						count++;
						if(y<v.getHeight()/10){
						((MyView) v).addScore();
						}
						((MyView) v).Redraw1();
						if(count == 5){
							count = 0;
							//main.goMenu();
						}
					}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of impact check
	}
}
}
	




