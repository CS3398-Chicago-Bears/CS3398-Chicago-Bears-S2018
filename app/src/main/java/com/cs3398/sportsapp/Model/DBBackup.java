package com.cs3398.sportsapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

//  backup database to store reserve users. Only uses the add, delete, and get all users function
//  expected to be used with write file operations as backup storage for user info.
//  backup database uses different version number and name to distinguish between main db.

public class DBBackup extends SQLiteOpenHelper{
    // Initializing the database
    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "backup database storage";
    // Contacts table name
    private static final String TABLE_USERS = "stored users";
    // Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_PASSWORD= "user_password";
    private static final String COLUMN_USER_SKILL= "user_skill";
    private static final String COLUMN_USER_LATITUDE= "user_latitude";
    private static final String COLUMN_USER_LONGITUDE= "user_longitude";

    // Exceptions and Overrides
    private String CREATE_USER_TABLE = "CREATE TABLE "
            + TABLE_USERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT, "
            + COLUMN_USER_SKILL + " INTEGER, "
            + COLUMN_USER_LATITUDE + " DOUBLE, "
            + COLUMN_USER_LONGITUDE + " DOUBLE)";

    public DBBackup(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // Creating tables again
        onCreate(db);
    }

    // Getting All Users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();

        // Select All Query
        String selectQuery = "SELECT * FROM" + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setuID(Integer.parseInt(cursor.getString(0)));
                user.setUserName(cursor.getString(1));
                user.setSkillLevel(cursor.getString(2));
                // Adding contact to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        return userList;
    }

    // Adding new user
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName()); // user Name
        values.put(COLUMN_USER_PASSWORD, user.getPassword()); // user preference
        values.put(COLUMN_USER_SKILL, user.getSkillLevel());
        values.put(COLUMN_USER_LATITUDE, user.getLatitude());
        values.put(COLUMN_USER_LONGITUDE, user.getLongitude());

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    // Deleting a user
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + "= ?",
                new String[] { String.valueOf(user.getuID()) });
        db.close();
    }

}
