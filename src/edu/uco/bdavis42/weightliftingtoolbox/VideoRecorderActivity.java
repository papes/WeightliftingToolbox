package edu.uco.bdavis42.weightliftingtoolbox;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.uco.bdavis42.finalproject.R;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
 
public class VideoRecorderActivity extends Activity implements
		Camera.ErrorCallback, SurfaceHolder.Callback, OnClickListener {
 
	private static final String TAG = "VideoRecording";
 
	Handler handler = new Handler();
	private Camera mCamera;
	private CameraPreview mPreview;
	private MediaRecorder mMediaRecorder;
	private Button captureButton;
	private boolean isRecording = false;
	private List<Size> sizes;
	static String fileName = "eeeee";
    Dialog confirm;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recorder);
		confirm = new Dialog(VideoRecorderActivity.this);
	    confirm.setContentView(R.layout.video_name); 
	    
	    EditText videoName = (EditText) confirm.findViewById(R.id.video_name); 
	    Button saveButton = (Button) confirm.findViewById(R.id.SaveVideo); 
	    Button cancelButton = (Button) confirm.findViewById(R.id.CancelVideo); 
	    
	    saveButton.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  confirm.dismiss();
          }
          });
	    cancelButton.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  finish();
          }
          });
	    videoName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				
				if(c.length() > 0){
					fileName = c.toString();
					Log.d("string = ", fileName);
					}
				
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});
	    
	    confirm.show();
		// Create an instance of Camera.
		if (mCamera == null) {
			mCamera = getCameraInstance();
			// Create preview view and set it as the content of our activity.
			mPreview = new CameraPreview(this, mCamera);
		} else {
			mCamera.release();
			mCamera = getCameraInstance();
			// Create preview view and set it as the content of our activity.
			mPreview = new CameraPreview(this, mCamera);
 
		}
		int i = R.id.videoview;
		Object o = this.findViewById(i);
		FrameLayout preview = (FrameLayout) o;
		preview.addView(mPreview);
 
		Camera.Parameters params = mCamera.getParameters();
		params.set("cam_mode", 1);
		mCamera.setParameters(params);
 
		sizes = params.getSupportedPreviewSizes();
 
		// Add a listener to the Capture button
		captureButton = (Button) findViewById(R.id.mybutton);
		captureButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isRecording) {
					mMediaRecorder.stop();
					// TODO Auto-generated method stub
 
					// stop recording and release camera
					// stop the recording
					releaseMediaRecorder(); // release the MediaRecorder object
					mCamera.lock(); // take camera access back from
									// MediaRecorder
					// inform the user that recording has stopped
					setCaptureButtonText("Capture");
					isRecording = false;
					
					
				} else {
					
					// initialize video camera
					if (prepareVideoRecorder()) {
						// Camera is available and unlocked, MediaRecorder is
						// prepared,
						// now you can start recording
 
						mMediaRecorder.start();
						// inform the user that recording has started
						setCaptureButtonText("Stop");
 
						isRecording = true;
					} else {
						// prepare didn't work, release the camera
						releaseMediaRecorder();
 
					}
				}
			}
		});
	}
 
	public void setCaptureButtonText(String s) {
		captureButton.setText(s);
	}
 
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// The Surface has been created, now tell the camera where to draw the
		// preview.
		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
 
		} catch (IOException e) {
			Log.d(TAG, "Error setting camera preview: " + e.getMessage());
			Toast.makeText(this, "Device is not supported!", Toast.LENGTH_LONG)
					.show();
		}
	}
 
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}
 
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
	}
 
	private boolean prepareVideoRecorder() {
		
		
		// mCamera = getCameraInstance();
		mMediaRecorder = new MediaRecorder();
		// Step 1: Unlock and set camera to MediaRecorder
		mCamera.unlock();
		mMediaRecorder.setCamera(mCamera);
		// Step 2: Set sources
		// activate this for recording with sound
		// mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
 
		mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
 
		//mMediaRecorder.setVideoSize(getMaxSupportedVideoSize().width,
		//		getMaxSupportedVideoSize().height);
		mMediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
		// mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//
		// activate this for recording with sound
 
		// Step 4: Set output file
		mMediaRecorder.setOutputFile(getOutputMediaFile("movie"));
		// Step 5: Set the preview output
		mMediaRecorder.setPreviewDisplay(mPreview.getHolder().getSurface());
		// Step 6: Prepare configured MediaRecorder
		try {
			mMediaRecorder.prepare();
		} catch (IllegalStateException e) {
			Log.d(TAG,
					"IllegalStateException preparing MediaRecorder: "
							+ e.getMessage());
			Toast.makeText(this, "Device is not supported!", Toast.LENGTH_LONG)
					.show();
			releaseMediaRecorder();
			return false;
		} catch (IOException e) {
			Log.d(TAG, "IOException preparing MediaRecorder: " + e.getMessage());
			Toast.makeText(this, "Device is not supported!", Toast.LENGTH_LONG)
					.show();
			releaseMediaRecorder();
			return false;
		}
		return true;
	}
 
	@Override
	public void onClick(View v) {
		/*
		 * Log.i("onClick", "BEGIN"); if(!recording) { recording =
		 * startRecording(); } else { stopRecording(); recording = false; }
		 * Log.i("onClick", "END");
		 */
	}
 
	@Override
	protected void onPause() {
		super.onPause();
		if (isRecording) {
			mMediaRecorder.stop();
			releaseMediaRecorder();
			mCamera.lock();
			setCaptureButtonText("RECORD");
			isRecording = false;
		} else {
			releaseMediaRecorder();
		}
		// releaseCamera();
 
	}
 
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (isRecording) {
			mMediaRecorder.stop();
			releaseMediaRecorder();
			mCamera.lock();
			setCaptureButtonText("RECORD");
			isRecording = false;
		} else {
			releaseMediaRecorder();
			releaseCamera();
		}
		// releaseCamera();
 
	}
 
	private void releaseMediaRecorder() {
		if (mMediaRecorder != null) {
			mMediaRecorder.reset(); // clear recorder configuration
			mMediaRecorder.release(); // release the recorder object
			mMediaRecorder = null;
			mCamera.lock(); // lock camera for later use
		}
	}
 
	private void releaseCamera() {
		if (mCamera != null) {
			mCamera.release(); // release the camera for other applications
			mCamera = null;
		}
	}
 
	private Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(); // attempt to get a Camera instance
			// c = this.open(); // attempt to get a Camera instance
		} catch (Exception e) {
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}
 
	public Camera open() {
		return Camera.open();
	}
 
	@Override
	public void onError(int error, Camera camera) {
		// TODO Auto-generated method stub
		if (error == Camera.CAMERA_ERROR_SERVER_DIED
				|| error == Camera.CAMERA_ERROR_UNKNOWN) {
			releaseCamera();
			finish();
			Toast.makeText(this, "Camera has died", Toast.LENGTH_LONG).show();
		}
	}
 
	/*public Size getMaxSupportedVideoSize() {
		int maximum = sizes.get(0).width;
		int position = 0;
		for (int i = 0; i < sizes.size() - 1; i++) {
			if (sizes.get(i).width > maximum) {
				maximum = sizes.get(i).width; // new maximum
				position = i - 1;
			}
		}
		if (position == 0) {
			int secondMax = sizes.get(1).width;
			position = 1;
			for (int j = 1; j < sizes.size() - 1; j++) {
				if (sizes.get(j).width > secondMax) {
					secondMax = sizes.get(j).width; // new maximum
					position = j;
				}
 
			}
		}
 
		return sizes.get(position);
		// end method max
 
	}
	*/
 
	private static String getOutputMediaFile(String sufix) {
 
		String mediaFile;
		File mediaStorageDir = new File(
				Environment.getExternalStorageDirectory(), "/VideoLogger");
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d("VideoLogger", "failed to create directory");
				return null;
			}
		}
		if (!sufix.equals("movie")) {
			mediaFile = mediaStorageDir.getPath() + File.separator + fileName + "_" + sufix + ".txt";
		} else {
			mediaFile = mediaStorageDir.getPath() + File.separator + fileName + ".mp4";
 
		}
 
		return mediaFile;
	}
}