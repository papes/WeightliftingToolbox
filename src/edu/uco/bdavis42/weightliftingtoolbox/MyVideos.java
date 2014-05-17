package edu.uco.bdavis42.weightliftingtoolbox;

import java.io.File;

import edu.uco.bdavis42.finalproject.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MyVideos extends Activity {
	
	
	ListView list;
    LazyAdapter adapter;
	public String[] mFileStrings;
	private File[] listFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_videos);
		final VideoView vd = (VideoView)findViewById(R.id.videoview);
		final MediaController mc = new MediaController(this);
		File file = new File("storage/sdcard0/VideoLogger/");

        if (file.isDirectory())
        {
            listFile = file.listFiles();
            mFileStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++)
            {
                mFileStrings[i] = listFile[i].getAbsolutePath();
                Log.d("list name: ", mFileStrings[i]);
            }
        }

        list = (ListView) findViewById(R.id.list);
        adapter = new LazyAdapter(this, mFileStrings);
        list.setAdapter(adapter);
       
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        	  @Override
        	  public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

        	    String st = mFileStrings[position];
        	    Log.d("temp name: ", st);


        	   
    	        Uri uri = Uri.parse(st);
    	        
    	        vd.setMediaController(mc);
    	        vd.setVideoURI(uri);
    	        vd.start();
        	  }
        	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_videos, menu);
		return true;
	}

	public static Object get(FragmentActivity activity) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public void onListItemClick(ListView list, View v, int position, long id) {
        
		VideoView vd = (VideoView)findViewById(R.id.videoview);
        Uri uri = Uri.parse("storage/sdcard0/VideoLogger/test.mp4");
        MediaController mc = new MediaController(this);
        vd.setMediaController(mc);
        vd.setVideoURI(uri);
        vd.start();
    }
    */
/*
	 private void showVideo()
	    {
	        VideoView vd = (VideoView)findViewById(R.id.videoview);
	        Uri uri = Uri.parse("storage/sdcard0/VideoLogger/test.mp4");
	        MediaController mc = new MediaController(this);
	        vd.setMediaController(mc);
	        vd.setVideoURI(uri);
	        vd.start();
	    }
	    */

	 public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.menu_item_new_video:
	            	 Intent intent = new Intent(MyVideos.this, VideoRecorderActivity.class);
		              startActivity(intent);
	             //   Intent i = new Intent(getActivity(), ContactActivity.class);
	             //   i.putExtra(ContactFragment.EXTRA_CONTACT_ID, contact.getmId());
	             //   startActivityForResult(i, 0);
	               
	                
	                return true;
	            
	            default:
	                return super.onOptionsItemSelected(item);
	        } 
	    }

}
