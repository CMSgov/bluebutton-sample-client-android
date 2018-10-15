package gov.cms.bluebutton.oauthtester;

/**
 * Build upon example code by anupamchugh on 19/10/15.
 * https://anujarosha.wordpress.com/2012/01/06/how-to-update-and-delete-data-from-sqlite-database-in-android/
 * https://github.com/AnujAroshA/Android-SQLite
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;



public class ModifyTestActivity extends Activity implements OnClickListener {

    private static final String TAG = "ModifyTestActivity";

    private EditText labelText;
    private Button updateBtn, deleteBtn, connectBtn;
    private EditText descText;
    private EditText testtypeText;
    private EditText clidText;
    private EditText clsecText;
    private EditText reduriText;
    private EditText authuriText;
    private EditText tokuriText;
    private EditText authscopeText;
    private EditText discuriText;
    private EditText regenduriText;
    private EditText usrinfouriText;
    private EditText httpsreqText;
    private Context context;


    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.activity_modify_record);

        dbManager = new DBManager(this);
        dbManager.open();

        labelText = (EditText) findViewById(R.id.label_edittext);
        descText = (EditText) findViewById(R.id.description_edittext);

        testtypeText = (EditText) findViewById(R.id.testtype_edittext);
        clidText = (EditText) findViewById(R.id.clid_edittext);
        clsecText = (EditText) findViewById(R.id.clsec_edittext);
        reduriText = (EditText) findViewById(R.id.reduri_edittext);
        authuriText = (EditText) findViewById(R.id.authuri_edittext);
        tokuriText = (EditText) findViewById(R.id.tokuri_edittext);
        authscopeText = (EditText) findViewById(R.id.authscope_edittext);
        discuriText = (EditText) findViewById(R.id.discuri_edittext);
        regenduriText = (EditText) findViewById(R.id.regenduri_edittext);
        usrinfouriText = (EditText) findViewById(R.id.usrinfouri_edittext);
        httpsreqText = (EditText) findViewById(R.id.httpsreq_edittext);


        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        connectBtn = (Button) findViewById(R.id.btn_connect);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("label");
        String desc = intent.getStringExtra("desc");

        String testtype = intent.getStringExtra("testtype");
        String clid = intent.getStringExtra("clid");
        String clsec = intent.getStringExtra("clsec");
        String reduri = intent.getStringExtra("reduri");
        String authuri = intent.getStringExtra("authuri");
        String tokuri = intent.getStringExtra("tokuri");
        String authscope = intent.getStringExtra("authscope");
        String discuri = intent.getStringExtra("discuri");
        String regenduri = intent.getStringExtra("regenduri");
        String usrinfouri = intent.getStringExtra("usrinfouri");
        String httpsreq = intent.getStringExtra("httpsreq");

        _id = Long.parseLong(id);

        labelText.setText(name);
        descText.setText(desc);


        testtypeText.setText(testtype);
        clidText.setText(clid);
        clsecText.setText(clsec);
        reduriText.setText(reduri);
        authuriText.setText(authuri);
        tokuriText.setText(tokuri);
        authscopeText.setText(authscope);
        discuriText.setText(discuri);
        regenduriText.setText(regenduri);
        usrinfouriText.setText(usrinfouri);
        httpsreqText.setText(httpsreq);



        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        connectBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String label = labelText.getText().toString();
                String desc = descText.getText().toString();

                String testtype = testtypeText.getText().toString();
                String clid = clidText.getText().toString();
                String clsec = clsecText.getText().toString();
                String reduri = reduriText.getText().toString();
                String authuri = authuriText.getText().toString();
                String tokuri = tokuriText.getText().toString();
                String authscope = authscopeText.getText().toString();
                String discuri = discuriText.getText().toString();
                String regenduri = regenduriText.getText().toString();
                String usrinfouri = usrinfouriText.getText().toString();
                String httpsreq = httpsreqText.getText().toString();


                dbManager.update(_id, label, desc, testtype, clid, clsec, reduri, authuri, tokuri, authscope, discuri,
                                 regenduri, usrinfouri, httpsreq);
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;

            case R.id.btn_connect:
                this.connectTest();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), TestListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }




    public void connectTest() {

        Intent connect_intent = new Intent(getApplicationContext(), LoginActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        clidText = (EditText) findViewById(R.id.clid_edittext);
        clsecText = (EditText) findViewById(R.id.clsec_edittext);
        reduriText = (EditText) findViewById(R.id.reduri_edittext);
        authuriText = (EditText) findViewById(R.id.authuri_edittext);
        tokuriText = (EditText) findViewById(R.id.tokuri_edittext);
        authscopeText = (EditText) findViewById(R.id.authscope_edittext);
        discuriText = (EditText) findViewById(R.id.discuri_edittext);
        regenduriText = (EditText) findViewById(R.id.regenduri_edittext);
        usrinfouriText = (EditText) findViewById(R.id.usrinfouri_edittext);
        httpsreqText = (EditText) findViewById(R.id.httpsreq_edittext);


        String clid = clidText.getText().toString();
        String clsec = clsecText.getText().toString();
        String reduri = reduriText.getText().toString();
        String authuri = authuriText.getText().toString();
        String tokuri = tokuriText.getText().toString();
        String authscope = authscopeText.getText().toString();
        String discuri = discuriText.getText().toString();
        String regenduri = regenduriText.getText().toString();
        String usrinfouri = usrinfouriText.getText().toString();
        String httpsreq = httpsreqText.getText().toString();


	/* Build JSON auth_config object */
	JSONObject obj = new JSONObject();
        try {
            obj.put("client_id", clid);
            obj.put("client_secret", clsec);
            obj.put("redirect_uri", reduri);
            obj.put("authorization_endpoint_uri", authuri);
            obj.put("token_endpoint_uri", tokuri);
            /* obj.put("authorization_scope", authscope); */
            obj.put("discovery_uri", discuri);
            obj.put("registration_endpoint_uri", regenduri);
            obj.put("user_info_endpoint_uri", usrinfouri);
            obj.put("https_required", httpsreq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "auth_conf JSON: " + obj.toString());
        Log.i(TAG, "----client_secret: " + clsec);

        /* Write JSON auth_conf to file on internal storage */

        context = getApplicationContext();
        String filename = "auth_config.json";
	File directory = context.getFilesDir();
	File file = new File(directory,filename);

        Log.i(TAG, "Writing JSON config to auth_config.json file: " + "/" + file.toString());

        /* Read from raw resource auth_config file */
        try {
	    FileWriter writer = new FileWriter(file);

	    writer.append(obj.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /* Output file contents to log */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null)
            {
                Log.i(TAG, "Readline: " + line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        startActivity(connect_intent);
    }
}
