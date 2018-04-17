package com.cs3398.sportsapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

// The database that operates user info given to it from app operation.

public class DBHandler extends SQLiteOpenHelper {
    // Initializing the database
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "users info";
    // Contacts table name
    private static final String TABLE_USERS = "users";
    // Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_PASSWORD= "user_password";
    private static final String COLUMN_USER_SKILL= "user_skill";
    private static final String COLUMN_USER_LATITUDE= "user_latitude";
    private static final String COLUMN_USER_LONGITUDE= "user_longitude";

    // Exceptions and Overrides
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_SKILL + " INTEGER, " + COLUMN_USER_LATITUDE
            + " DOUBLE, " + COLUMN_USER_LONGITUDE + " DOUBLE)";

    public DBHandler(Context context) {
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
    public boolean checkUser(String userName){
        String [] columns ={
                KEY_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_NAME + " =?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query(TABLE_USERS,
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

    public boolean checkUser(String userName, String password){
        String [] columns ={
                KEY_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_NAME + " =?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = {userName, password};

        Cursor cursor = db.query(TABLE_USERS,
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
    
    // Getting one user
    public User getUser(String name) {
        String [] columns ={
                KEY_ID, COLUMN_USER_NAME, COLUMN_USER_SKILL,
                COLUMN_USER_LATITUDE, COLUMN_USER_LONGITUDE
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = COLUMN_USER_NAME + " =?";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(TABLE_USERS,columns,selectQuery,selectionArgs,null,null,null);
        cursor.moveToFirst();
        db.close();
        User user = new User();
        user.setuID(cursor.getInt(0));
        user.setUserName(cursor.getString(1));
        user.setSkillLevel(cursor.getString(2));
        user.setLatitude(cursor.getDouble(3));
        user.setLongitude(cursor.getDouble(4));
        cursor.close();
        // return user
        return user;
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

    // Getting users Count
    public int getUsersCount() {
        String countQuery = "SELECT * FROM" + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
    // return count
        return cursor.getCount();
    }

    // Updating a user
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_SKILL, user.getSkillLevel());
    // updating row
        return db.update(TABLE_USERS, values, KEY_ID + "= ?",
        new String[]{String.valueOf(user.getuID())});
    }

    // Deleting a user
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + "= ?",
        new String[] { String.valueOf(user.getuID()) });
        db.close();
    }
}
