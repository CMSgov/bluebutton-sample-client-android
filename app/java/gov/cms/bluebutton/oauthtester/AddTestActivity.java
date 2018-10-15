package gov.cms.bluebutton.oauthtester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import gov.cms.bluebutton.oauthtester.R;

public class AddTestActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText labelEditText;
    private EditText descEditText;
    private EditText testtypeEditText;
    private EditText clidEditText;
    private EditText clsecEditText;
    private EditText reduriEditText;
    private EditText authuriEditText;
    private EditText tokuriEditText;
    private EditText authscopeEditText;
    private EditText discuriEditText;
    private EditText regenduriEditText;
    private EditText usrinfouriEditText;
    private EditText httpsreqEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_add_record);

        labelEditText = (EditText) findViewById(R.id.label_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);


        testtypeEditText = (EditText) findViewById(R.id.testtype_edittext);
        clidEditText = (EditText) findViewById(R.id.clid_edittext);
        clsecEditText = (EditText) findViewById(R.id.clsec_edittext);
        reduriEditText = (EditText) findViewById(R.id.reduri_edittext);
        authuriEditText = (EditText) findViewById(R.id.authuri_edittext);
        tokuriEditText = (EditText) findViewById(R.id.tokuri_edittext);
        authscopeEditText = (EditText) findViewById(R.id.authscope_edittext);
        discuriEditText = (EditText) findViewById(R.id.discuri_edittext);
        regenduriEditText = (EditText) findViewById(R.id.regenduri_edittext);
        usrinfouriEditText = (EditText) findViewById(R.id.usrinfouri_edittext);
        httpsreqEditText = (EditText) findViewById(R.id.httpsreq_edittext);




        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = labelEditText.getText().toString();
                final String desc = descEditText.getText().toString();


                final String testtype  = testtypeEditText.getText().toString();
                final String clid = clidEditText.getText().toString();
                final String clsec = clsecEditText.getText().toString();
                final String reduri = reduriEditText.getText().toString();
                final String authuri = authuriEditText.getText().toString();
                final String tokuri = tokuriEditText.getText().toString();
                final String authscope = authscopeEditText.getText().toString();
                final String discuri = discuriEditText.getText().toString();
                final String regenduri = regenduriEditText.getText().toString();
                final String usrinfouri = usrinfouriEditText.getText().toString();
                final String httpsreq = httpsreqEditText.getText().toString();



                dbManager.insert(name, desc, testtype, clid, clsec, reduri, authuri, tokuri, authscope, discuri,
				 regenduri, usrinfouri, httpsreq);

                Intent main = new Intent(AddTestActivity.this, TestListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}
