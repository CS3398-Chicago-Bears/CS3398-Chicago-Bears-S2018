package com.cs3398.sportsapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

// The database that operates user info given to it from app operation.

public class DBHandlerMsg extends SQLiteOpenHelper {
    // Initializing the database
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "userMessages";
    // Contacts table name
    private static final String TABLE_MESSAGES = "messages";
    // Users Table Columns names
    private static final String COLUMN_SENDER = "fromUser";
    private static final String COLUMN_RECEIVER = "toUser";
    private static final String COLUMN_CONTENT = "content";
    private static final String KEY_ID = "id";


    // Exceptions and Overrides
    private String CREATE_MESSAGE_TABLE = "CREATE TABLE " + TABLE_MESSAGES + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SENDER + " TEXT, "
            + COLUMN_RECEIVER + " TEXT, "
            + COLUMN_CONTENT + " TEXT)";

    public DBHandlerMsg(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MESSAGE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        //creating tables again
        onCreate(db);
    }

    public void addMsg(String from, String to, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SENDER, from);
        values.put(COLUMN_RECEIVER, to);
        values.put(COLUMN_CONTENT, content);

        //Inserting Row
        db.insert(TABLE_MESSAGES, null, values);
        db.close();
    }

    //Getting a bracket
    public Message getMsg(String name) {
        String [] columns = {
                COLUMN_SENDER, COLUMN_RECEIVER, COLUMN_CONTENT
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = COLUMN_RECEIVER + " =?";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(TABLE_MESSAGES, columns, selectQuery, selectionArgs, null, null, null);
        cursor.moveToFirst();
        db.close();
        Message m = new Message();
        m.setSender(cursor.getString(0));
        m.setReceiver(cursor.getString(1));
        m.setContent(cursor.getString(2));
        cursor.close();

        return m;
    }

    public List<Message> getAllMsg(String name) {
        List<Message> msgList = new ArrayList<Message>();
        String [] columns ={
                COLUMN_SENDER, COLUMN_RECEIVER, COLUMN_CONTENT
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = COLUMN_RECEIVER + " =?";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(TABLE_MESSAGES,columns,selectQuery,selectionArgs,null,null,null);
        while(cursor.moveToNext()) {
            Message msg = new Message();
            msg.setSender(cursor.getString(0));
            msg.setReceiver(cursor.getString(1));
            msg.setContent(cursor.getString(2));
            msgList.add(msg);
        }
        db.close();

        cursor.close();
        // return user
        return msgList;
    }
}
