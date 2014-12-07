package com.example.demo_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
    ImageView imageView;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        bar=(ProgressBar) findViewById(R.id.progressBar);
    }

    private class MyAsyncTask extends AsyncTask<String,Integer,Integer>{

		@Override
		protected Integer doInBackground(String... params) {
			for(int i=0;i<=100;i+=10){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publishProgress(i);
			}
			return R.drawable.ic_launcher;
		}
    	@Override
    	protected void onPostExecute(Integer result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		imageView.setImageResource(result);
    	}
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		Toast.makeText(MainActivity.this, "¿ªÊ¼ÏÂÔØ¡£¡£¡£", Toast.LENGTH_SHORT).show();
    	}
    	@Override
    	protected void onCancelled() {
    		// TODO Auto-generated method stub
    		super.onCancelled();
    		Log.i("info", "onCancelled");
    	}
    	@Override
    	protected void onProgressUpdate(Integer... values) {
    		// TODO Auto-generated method stub
    		super.onProgressUpdate(values);
    		bar.setProgress(values[0]);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void doClick(View v){
    	MyAsyncTask asyncTask=new MyAsyncTask();
    	asyncTask.execute("Lauchingai");
    }
}
