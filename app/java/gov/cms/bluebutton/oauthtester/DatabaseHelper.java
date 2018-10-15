package gov.cms.bluebutton.oauthtester;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "TESTS";

    // Table columns
    public static final String _ID = "_id";
    public static final String LABEL = "label";
    public static final String DESC = "description";

    public static final String TESTTYPE = "test_type";
    public static final String CLID = "client_id";
    public static final String CLSEC = "client_secret";
    public static final String REDURI = "redirect_uri";

    public static final String AUTHURI = "authorization_endpoint_uri";
    public static final String TOKURI = "token_endpoint_uri";

    public static final String AUTHSCOPE = "authorization_scope";
    public static final String DISCURI = "discovery_uri";
    public static final String REGENDURI = "registration_endpoint_uri";
    public static final String USRINFOURI = "user_info_endpoint_uri";
    public static final String HTTPSREQ = "https_required";

    // Database Information
    static final String DB_NAME = "BB_TESTS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LABEL + " TEXT NOT NULL, " + DESC + " TEXT, "
	    + TESTTYPE + " TEXT, " + CLID + " TEXT, " + CLSEC + " TEXT, " + REDURI + " TEXT, " 
	    + AUTHURI + " TEXT, " + TOKURI + " TEXT, " + AUTHSCOPE + " TEXT, " + DISCURI + " TEXT, " 
	    + REGENDURI + " TEXT, " + USRINFOURI + " TEXT, " + HTTPSREQ + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
