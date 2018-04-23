package com.cs3398.sportsapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

// The database that operates user info given to it from app operation.

public class DBHandlerFriends extends SQLiteOpenHelper {
    // Initializing the database
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "friendInfo";
    // Contacts table name
    private static final String TABLE_FRIENDS = "friends";
    private static final String KEY_ID = "id";
    private static final String COLUMN_SENDER = "sender";
    private static final String COLUMN_RECEIVER= "receiver";
    private static final String COLUMN_STATUS="status";
    private static final Integer PENDING = 0;
    private static final Integer ACCEPTED = 1;

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SENDER + " TEXT, "+
            COLUMN_RECEIVER +" TEXT, "+ COLUMN_STATUS + " INTEGER)";

    public DBHandlerFriends(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);
        // Creating tables again
        onCreate(db);
    }

    public void addRequest(User sender, User receiver) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SENDER, sender.getUserName()); // user Name
        values.put(COLUMN_RECEIVER, receiver.getUserName()); // user preference
        values.put(COLUMN_STATUS, PENDING);

        db.insert(TABLE_FRIENDS, null, values);
        db.close();
    }

    public boolean getStatus(User u, User f){
        String [] columns ={
                KEY_ID, COLUMN_SENDER, COLUMN_RECEIVER,
                COLUMN_STATUS
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = COLUMN_SENDER + " =? AND "+COLUMN_RECEIVER + " =?";
        String[] selectionArgs = {u.getUserName(), f.getUserName()};
        Cursor cursor = db.query(TABLE_FRIENDS,columns,selectQuery,selectionArgs,null,null,null);
        cursor.moveToFirst();
        db.close();
        int count = cursor.getCount();
        cursor.close();
        if(count > 0)
            return true;
        return false;
    }

    public boolean checkUser(String userName){
        String [] columns ={
                KEY_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_RECEIVER + " =?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query(TABLE_FRIENDS,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;
        }
        return false;
    }
    public int getSize(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM friends", null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount;
    }
}