package com.example.gooddeed;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

public class MyDBHandlerClass extends SQLiteOpenHelper {
    //information of database
    private static final String TAG = "MyDBHandlerClass";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GoodDeed.db";
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "userID";
    public static final String USER_NAME = "userName";
    public static final String DEED_DESCR = "deedDescription";

    public MyDBHandlerClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DEED_DESCR +" TEXT, " + USER_NAME + " Text"  + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String deedDesc, String usersName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + USER_NAME + ", " + DEED_DESCR + ") VALUES (\'" + usersName + "\', \'" + deedDesc + "\')");

        Log.d(TAG, "addData: Adding " + deedDesc + " and " + usersName + " to " + TABLE_NAME);
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
