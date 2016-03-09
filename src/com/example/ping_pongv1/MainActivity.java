package com.example.ping_pongv1;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final String  DEBUG_TAG = "Touch test";
	private MyView myView;
	private int x0;
	private int x1;
	public static final String PREFS_NAME = "MyPrefsFile";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_main);

		requestWindowFeature(Window.FEATURE_NO_TITLE);// hide statusbar of Android
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
								WindowManager.LayoutParams.FLAG_FULLSCREEN);
		myView = new MyView(this);
		setContentView(R.layout.activity_main);

		String scorStr = Store.get(this);

		myToast("Your total score is " + scorStr);
		if (!scorStr.equals("")) {
			myView.setScore(Integer.parseInt(scorStr));
		}
	}
	public void goLevel1(View view){
		setContentView(myView);
	}
	public void goMenu(){
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		  SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	      SharedPreferences.Editor editor = settings.edit();
	      
	      String scoreStr = myView.getScore() + "" ;
	      
	      editor.putString("scoreKey", scoreStr);

	      // Commit the edits!
	      editor.commit();
	}
	public void myToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){ 
	        
	    int action = MotionEventCompat.getActionMasked(event);
	    
	    switch(action) {
	        case (MotionEvent.ACTION_DOWN) :
	            Log.d(DEBUG_TAG,"Action was DOWN");
	        	x0= (int) event.getX();
	        //	myView.getUserPlayer().setX(x0);
	        	myView.getUserPlayer().setVX(0);
	        	//y0 = (int) event.getY();
	        	
//	        	myView.getKiller().setVy(5);
//	        	myView.getKiller().setVx(5);
	            return true;
	        case (MotionEvent.ACTION_MOVE) :
	           Log.d(DEBUG_TAG,"Action was MOVE");
	            return true;
	        case (MotionEvent.ACTION_UP) :
	            Log.d(DEBUG_TAG,"Action was UP");
        		x1= (int) event.getX();
        		//y1 = (int) event.getY();
        		if(x0<x1 && (x1-x0)> 20){
        		myView.getUserPlayer().setVX(20);
        		}
        		else if(x1<x0 && (x0-x1)> 20){
        			myView.getUserPlayer().setVX(-20);
        		}
	            return true;
	        case (MotionEvent.ACTION_CANCEL) :
	            Log.d(DEBUG_TAG,"Action was CANCEL");
	            return true;
	        case (MotionEvent.ACTION_OUTSIDE) :
	            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
	                   "of current screen element");
	            return true;      
	        default : 
	            return super.onTouchEvent(event);
	    }      
	}
	
}
