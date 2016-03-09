package com.example.ping_pongv1;


//import java.util.Random;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("DrawAllocation") public class MyView extends ImageView {
	
	private Bitmap bitmap_p1;
	private Bitmap bitmap_h1;
	private Bitmap bitmap_b1;
	private Obs obs;
	private int score;
	private int prevScore;
	private Player userPlayer;
	private Player host;
	private Ball bl;
	private int width;
	private int height;
	private boolean firstDraw = true;
	public MainActivity activity;
	private Random rnd;
	private int tick;
	public Player getUserPlayer() {
		return userPlayer;
	}
	
	public Player getHost(){
		return host;
	}
	
	public Ball getBall(){
		return bl;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore() {
		score++;
	}



	public MyView(Context context) {
		super(context);
		activity = (MainActivity) context;
		tick = 0;
		//width = getWidth();
		//height = getHeight();
		//Context menu = context;
		bitmap_p1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.ch_player);
		bitmap_h1 = BitmapFactory.decodeResource(getResources(), R.drawable.ch_host);
		bitmap_b1 = BitmapFactory.decodeResource(getResources(), R.drawable.bl_ball);
		
		
		//obs = new Obs(200, 300,bitmap, this);
		if((userPlayer == null)&&(host == null)&&(bl == null)){
		userPlayer = new Player(0,0, this, bitmap_p1, 2);
		host = new Player(0,0,this,bitmap_h1,2);
		bl = new Ball(0,0,5,bitmap_b1,10,this);
		}

		//player width/2,height-height/4
		//host width/2,height/4
		//bl width/2,height-height/4
		
	}
	/*public void CreateObs(){
		obs = new Obs(200, 300,bitmap, this);
	}*/
	
	public Obs getObs(){
		return obs;
	}
	public void Redraw1(){
		firstDraw = true;
	}
	public void goMenu(){
		
	}
	
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
			
		if(firstDraw){
			userPlayer.setX(getWidth()/2-80);
			host.setX(getWidth()/2-80);
			bl.SetX(getWidth()/2);
			bl.setVy(10);
			
			userPlayer.setY(getHeight()-getHeight()/4);
			host.setY(getHeight()/4);
			bl.SetY(getHeight()/3);
			
			firstDraw = false;
			tick ++;
		}
		
		rnd = new Random();
		int r = rnd.nextInt(256);
		int g = rnd.nextInt(256);
		int b = rnd.nextInt(256);
		//Color col = new Color();

		canvas.drawColor(0xFF000000+r*1+g*10+b*100);

		//canvas.drawBitmap(bitmap_p1, 50, 100, null);
		//canvas.drawBitmap(bitmap_h1,50,1000,null);
		userPlayer.draw(canvas);
		host.draw(canvas);
		bl.draw(canvas);

		if(score > prevScore){//  strange place:)
			String msg = "Score = " + score;
			activity.myToast(msg);
			prevScore = score;
		}
		if(tick == 5){
			tick = 0;
			activity.goMenu();
		}
		invalidate();
	}
	}
//}
