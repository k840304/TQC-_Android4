package COM.TQC.GDD02;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class GDD02 extends Activity {
	private static final String DATABASENAME = "notes.db";
	private static final String TABLENAME = "notes";
	private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS "
	+ TABLENAME + " (_id INTEGER PRIMARY KEY, note TEXT NOT NULL, created INTEGER);"; 
	private SQLiteDatabase database;
	private android.database.Cursor cursor;
	private String[] arrNote;
	private Boolean[] arrCheck;
	private ListView lvNote;
	private Button button1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        database = openOrCreateDatabase(DATABASENAME, MODE_WORLD_WRITEABLE, null);
        database.execSQL(CREATE_SQL);
        cursor = database.query(TABLENAME, null, null, null, null, null, null);
        
        //database.execSQL("insert into notes values(1, 'BOOK', 10)");
        //database.execSQL("insert into notes values(2, 'FOOD', 10)");
        //database.execSQL("insert into notes values(3, 'TOOL', 10)");
        
        arrNote = new String[cursor.getCount()];
        arrCheck = new Boolean[cursor.getCount()];
        int i;
        for(i = 0; i < arrNote.length; i++){
        	cursor.moveToPosition(i);
        	arrNote[i] = cursor.getString(1);
        	arrCheck[i] = false;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, arrNote);
        lvNote = (ListView) findViewById(R.id.lvNote);
        lvNote.setAdapter(adapter);
        
        lvNote.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvNote.setOnItemClickListener(new ListView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				arrCheck[arg2] = !arrCheck[arg2];
			}});
        
        for(i = 0; i < arrNote.length; i++){
        	cursor.moveToPosition(i);
        	arrNote[i] = cursor.getString(1);
        	arrCheck[i] = false;
        }
        
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub				
				Boolean flag = false;
				String str = "{";
				int i;
				for(i = 0; i < arrNote.length; i++){
		        	if(arrCheck[i]){
		        		str += arrNote[i] + " ";
		        		flag = true;
		        	}
		        	
		        }
				str += "}";
				if(flag == false) str = "¸ê®Æ®wÅª¨ú";
				setTitle(str);
			}});
    }
}