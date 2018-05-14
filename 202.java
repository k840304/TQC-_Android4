package COM.TQC.GDD02;
/*
題目說明：
英呎 = 公尺 * 3.28
公尺 = 英呎 * 0.3048
*/

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GDD02 extends Activity {

	protected String PREF_M = "pref_m";
	protected String PREF_FT = "pref_ft";
	protected String pref_m;
	protected String pref_ft;
	private EditText input_value;
	private Button button1;
	private Button button2;
	private TextView result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        input_value = (EditText) findViewById(R.id.input_value);
        result = (TextView) findViewById(R.id.result);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double m = Double.parseDouble(input_value.getText().toString());
				double ft = m * 3.8;
				result.setText(String.format("%.1f 公尺=%.2f 英呎", m, ft));
			}});
        
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double ft = Double.parseDouble(input_value.getText().toString());
				double m = ft * 0.3048;
				result.setText(String.format("%.1f 英呎=%.2f  公尺", ft, m));
			}});
    }

    @Override 
    public boolean 
    onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    public boolean 
    onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
        	case R.id.menu_reset:
        		ResetValue();
        		break;
        }
        return true;
    }
    
    private void
    ResetValue()
    {
    	input_value.setText("");
    	result.setText("");
    }

  
         

}