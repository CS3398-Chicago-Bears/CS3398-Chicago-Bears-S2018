package com.cs3398.sportsapp.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
        // Database Version
        private static final int DATABASE_VERSION = 1;
        // Database Name
        private static final String DATABASE_NAME = "User Database";
        // Contacts table name
        private static final String TABLE_USERS = "users";
        // Users Table Columns names
        private static final String KEY_ID = "id";
        private static final String KEY_NAME = "name";
        private static final String KEY_SH_ADDR = "address";
        public DBHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_USERS +"("
            + KEY_ID +  "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT,"
            + KEY_SH_ADDR + "TEXT" + ")";
            db.execSQL(CREATE_CONTACTS_TABLE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS);
        // Creating tables again
            onCreate(db);
        }
}
