package com.example.ping_pongv1;

import android.graphics.Bitmap;

public class Player extends Obs implements Runnable{

	int num;
	private MyView vi;
	//private Obs Player;
	private int vx;
	private int avx;
	private int vy;
	private boolean tick;
	private int dist;
	private Bitmap bmp;
	
	public Player(int x, int y, MyView vi, Bitmap bmp, int vx) {
		super(x, y, bmp, vi);
		
	this.y = y;
	this.x = x;
	this.vi = vi;
	this.bmp = bmp;
	
	new Thread(this, "Killer").start();
	//BitmapFactory.decodeResource(vi.getResources(),R.drawable.ch_player);
	}
	
	public int getVX(){
		return this.vx;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getVY(){
		return this.vy;
	}
	public Bitmap getBmp(){
		return this.bmp;
	}
	
	/*public MyView getView(){
		return this.vi;
	}*/
	public void setBmp(Bitmap bmp){
		this.bmp = bmp;
	}
	public void setVX(int vx){
		this.vx = vx;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setVY(int vy){
		this.vy = vy;
	}
	
	
	@Override
	public void run() {
		while(true)
		{
			//AI-----------
			avx = 3;
			if(y == vi.getHeight()/4 && vi.getBall() != null){
				if((vi.getBall().getX() > x + 25) && (vi.getBall().getX() > x + 50)) x+=avx;
				else if((vi.getBall().getX() < x + 25) && (vi.getBall().getX() < x + 50)) x-=avx;
				else x += 0;
				
			}
			//AI-----------
			else{
			x+=vx;
			tick ^= true;
			if(vx>0 && tick){
				vx--;
			}
			else if(vx<0 && tick){
				vx++;
			}
			}
			//vy+=g;
			
			if(x<0 || x>vi.getWidth()-95){
				vx=-vx;
			}
/*			if(y<0 || y>600){
				vy=-vy;
			}
			
			if(((MyView)vi).getObs()!=null)
			{
			int x1 = x;
			int x2 = ((MyView)vi).getObs().getX();
			int y1 = y;
			int y2 = ((MyView)vi).getObs().getY();
			
			if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) < 1000)
			{
				((MyView)vi).KillBrick();
				((MyView)vi).CreateKiller();
			}
			}*/
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
	
	


