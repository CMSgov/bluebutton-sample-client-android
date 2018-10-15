package gov.cms.bluebutton.oauthtester;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class TestListActivity extends AppCompatActivity {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.LABEL, DatabaseHelper.DESC,
                                         DatabaseHelper.TESTTYPE, DatabaseHelper.CLID, DatabaseHelper.CLSEC,
                                         DatabaseHelper.REDURI, DatabaseHelper.AUTHURI, DatabaseHelper.TOKURI, 
					 DatabaseHelper.AUTHSCOPE, DatabaseHelper.DISCURI, DatabaseHelper.REGENDURI,
					 DatabaseHelper.USRINFOURI, DatabaseHelper.HTTPSREQ };

    final int[] to = new int[] { R.id.id, R.id.label, R.id.desc, R.id.testtype, R.id.clid, R.id.clsec,
                                 R.id.reduri, R.id.authuri, R.id.tokuri, R.id.authscope, R.id.discuri, 
				 R.id.regenduri, R.id.usrinfouri, R.id.httpsreq };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView labelTextView = (TextView) view.findViewById(R.id.label);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);

                TextView testtypeTextView = (TextView) view.findViewById(R.id.testtype);
                TextView clidTextView = (TextView) view.findViewById(R.id.clid);
                TextView clsecTextView = (TextView) view.findViewById(R.id.clsec);
                TextView reduriTextView = (TextView) view.findViewById(R.id.reduri);
                TextView authuriTextView = (TextView) view.findViewById(R.id.authuri);
                TextView tokuriTextView = (TextView) view.findViewById(R.id.tokuri);
                TextView authscopeTextView = (TextView) view.findViewById(R.id.authscope);
                TextView discuriTextView = (TextView) view.findViewById(R.id.discuri);
                TextView regenduriTextView = (TextView) view.findViewById(R.id.regenduri);
                TextView usrinfouriTextView = (TextView) view.findViewById(R.id.usrinfouri);
                TextView httpsreqTextView = (TextView) view.findViewById(R.id.httpsreq);


                String id = idTextView.getText().toString();
                String label = labelTextView.getText().toString();
                String desc = descTextView.getText().toString();

                String testtype = testtypeTextView.getText().toString();
                String clid = clidTextView.getText().toString();
                String clsec = clsecTextView.getText().toString();
                String reduri = reduriTextView.getText().toString();
                String authuri = authuriTextView.getText().toString();
                String tokuri = tokuriTextView.getText().toString();
                String authscope = authscopeTextView.getText().toString();
                String discuri = discuriTextView.getText().toString();
                String regenduri = regenduriTextView.getText().toString();
                String usrinfouri = usrinfouriTextView.getText().toString();
                String httpsreq = httpsreqTextView.getText().toString();



                Intent modify_intent = new Intent(getApplicationContext(), ModifyTestActivity.class);
                modify_intent.putExtra("label", label);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                modify_intent.putExtra("testtype", testtype);
                modify_intent.putExtra("clid", clid);
                modify_intent.putExtra("clsec", clsec);
                modify_intent.putExtra("reduri", reduri);
                modify_intent.putExtra("authuri", authuri);
                modify_intent.putExtra("tokuri", tokuri);
                modify_intent.putExtra("authscope", authscope);
                modify_intent.putExtra("discuri", discuri);
                modify_intent.putExtra("regenduri", regenduri);
                modify_intent.putExtra("usrinfouri", usrinfouri);
                modify_intent.putExtra("httpsreq", httpsreq);

                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddTestActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}
