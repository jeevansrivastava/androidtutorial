package samples.employeedirectory;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class EmployeeList extends Activity {
	
	protected String[] employees = {"Christophe Coenraets", "John Smith"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, employees);
    	ListView employeeList = (ListView) findViewById(R.id.list);
        employeeList.setAdapter(adapter);
    }
}