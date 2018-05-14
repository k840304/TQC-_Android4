package COM.TQC.GDD01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GDD01 extends Activity {
 
	protected TextView MyOutcome;
	protected int volt;
	private int[] voltage = {110, 220};
	private Spinner input_v;
	private EditText input_a;
	private EditText input_hr;
	private EditText input_m;
	private Button btn;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        input_v = (Spinner) findViewById(R.id.input_v);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.option_vs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input_v.setAdapter(adapter);
        input_v.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				volt = voltage[arg2];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
        
        MyOutcome = (TextView) findViewById(R.id.response);
        input_a = (EditText) findViewById(R.id.input_a);
        input_hr = (EditText) findViewById(R.id.input_hr);
        input_m = (EditText) findViewById(R.id.input_m);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int a = Integer.parseInt(input_a.getText().toString());
				int hr = Integer.parseInt(input_hr.getText().toString());
				int m = Integer.parseInt(input_m.getText().toString());
				MyOutcome.setText("$" + String.format("%.0f", (double) volt * a * hr * m * 30 / 1000));
			}});
    }

}