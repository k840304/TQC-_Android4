package COM.TQC.GDD03;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class GDD03 extends Activity
{
  private MediaPlayer mediaplayer;
  private Boolean bPause;
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    mediaplayer = MediaPlayer.create(this, R.raw.light);
    mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

		@Override
		public void onCompletion(MediaPlayer arg0) {
			// TODO Auto-generated method stub
		    if(mediaplayer != null){
		    	if(bPause == false)
		    		mediaplayer.start();
		    }
		}});

  }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 if(mediaplayer != null){
	    	mediaplayer.release();
	    }
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		 if(mediaplayer != null){
	    	mediaplayer.pause();
	    	bPause = true;
	    }
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		 if(mediaplayer != null){
	    	mediaplayer.start();
	    	bPause = false;
	    }
	}
}