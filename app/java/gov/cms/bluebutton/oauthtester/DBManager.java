package gov.cms.bluebutton.oauthtester;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc, String test_type, String client_id,
                       String client_secret, String redirect_uri, String authorization_endpoint_uri,
		       String token_endpoint_uri, String authorization_scope, String discovery_uri,
		       String registration_endpoint_uri, String user_info_endpoint_uri, String https_required) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.LABEL, name);
        contentValue.put(DatabaseHelper.DESC, desc);
        contentValue.put(DatabaseHelper.TESTTYPE, test_type);
        contentValue.put(DatabaseHelper.CLID, client_id);
        contentValue.put(DatabaseHelper.CLSEC, client_secret);
        contentValue.put(DatabaseHelper.REDURI, redirect_uri);
        contentValue.put(DatabaseHelper.AUTHURI, authorization_endpoint_uri);
        contentValue.put(DatabaseHelper.TOKURI, token_endpoint_uri);
        contentValue.put(DatabaseHelper.AUTHSCOPE, authorization_scope);
        contentValue.put(DatabaseHelper.DISCURI, discovery_uri);
        contentValue.put(DatabaseHelper.REGENDURI, registration_endpoint_uri);
        contentValue.put(DatabaseHelper.USRINFOURI, user_info_endpoint_uri);
        contentValue.put(DatabaseHelper.HTTPSREQ, https_required);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.LABEL, DatabaseHelper.DESC,
                                          DatabaseHelper.TESTTYPE, DatabaseHelper.CLID, DatabaseHelper.CLSEC,
                                          DatabaseHelper.REDURI, DatabaseHelper.AUTHURI, DatabaseHelper.TOKURI, 
					  DatabaseHelper.AUTHSCOPE, DatabaseHelper.DISCURI,
                                          DatabaseHelper.REGENDURI, DatabaseHelper.USRINFOURI, DatabaseHelper.HTTPSREQ };

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc, String test_type, String client_id,
                      String client_secret, String redirect_uri, String authorization_endpoint_uri,
		      String token_endpoint_uri, String authorization_scope, String discovery_uri, 
		      String registration_endpoint_uri, String user_info_endpoint_uri, String https_required) {
        ContentValues ContentValues = new ContentValues();
        ContentValues.put(DatabaseHelper.LABEL, name);
        ContentValues.put(DatabaseHelper.DESC, desc);
        ContentValues.put(DatabaseHelper.TESTTYPE, test_type);
        ContentValues.put(DatabaseHelper.CLID, client_id);
        ContentValues.put(DatabaseHelper.CLSEC, client_secret);
        ContentValues.put(DatabaseHelper.REDURI, redirect_uri);
        ContentValues.put(DatabaseHelper.AUTHURI, authorization_endpoint_uri);
        ContentValues.put(DatabaseHelper.TOKURI, token_endpoint_uri);
        ContentValues.put(DatabaseHelper.AUTHSCOPE, authorization_scope);
        ContentValues.put(DatabaseHelper.DISCURI, discovery_uri);
        ContentValues.put(DatabaseHelper.REGENDURI, registration_endpoint_uri);
        ContentValues.put(DatabaseHelper.USRINFOURI, user_info_endpoint_uri);
        ContentValues.put(DatabaseHelper.HTTPSREQ, https_required);

        int i = database.update(DatabaseHelper.TABLE_NAME, ContentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
