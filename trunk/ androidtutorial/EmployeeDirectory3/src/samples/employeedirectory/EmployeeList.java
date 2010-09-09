package samples.employeedirectory;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class EmployeeList extends Activity {
	
	protected EditText searchText;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected ListView employeeList;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = (new DatabaseHelper(this)).getWritableDatabase();
        searchText = (EditText) findViewById (R.id.searchText);
        employeeList = (ListView) findViewById (R.id.list);
    }
    
    public void search(View view) {
    	// || is the concatenation operation in SQLite
		cursor = db.rawQuery("SELECT _id, firstName, lastName, title FROM employee WHERE firstName || ' ' || lastName LIKE ?", 
						new String[]{"%" + searchText.getText().toString() + "%"});
		adapter = new SimpleCursorAdapter(
				this, 
				R.layout.employee_list_item, 
				cursor, 
				new String[] {"firstName", "lastName", "title"}, 
				new int[] {R.id.firstName, R.id.lastName, R.id.title});
		employeeList.setAdapter(adapter);
    }
    
}