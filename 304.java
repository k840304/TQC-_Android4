package COM.TQC.GDD03 ;

import android.content.BroadcastReceiver; 
import android.content.Context; 
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast; 

public class GDD03_SM_Receiver extends BroadcastReceiver 
{ 
  @Override 
  public void onReceive(Context context, Intent intent) 
  { 
    // TODO Auto-generated method stub 
    Bundle bundle = intent.getExtras();
    Object[] pdus = (Object[]) bundle.get("pdus");
    SmsMessage sms;
    String str = "";
    for(Object pdu : pdus){
        sms = SmsMessage.createFromPdu((byte[]) pdu);
        str += "接收到來自:\n";
        str += sms.getOriginatingAddress().toString() + "\n";
        str += "------傳來的簡訊------\n";
        str += sms.getDisplayMessageBody();
    }
    Toast.makeText(context, str, Toast.LENGTH_LONG).show();  
  } 
} 

