package COM.TQC.GDD01;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class GDD01 extends Activity {
  private EditText mPassword;
  private CheckBox mCheck;
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    mPassword = (EditText) findViewById(R.id.mPassword);
    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
    mCheck = (CheckBox) findViewById(R.id.mCheck);
    mCheck.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			if(arg1){
				mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			}
			else{
				mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
			}
		}});

  }
}