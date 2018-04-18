package com.cs3398.sportsapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

// The database that operates user info given to it from app operation.

public class DBHandlerBracket extends SQLiteOpenHelper {
    // Initializing the database
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "bracket info";
    // Contacts table name
    private static final String TABLE_BRACKETS = "brackets";
    // Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String COLUMN_BRACKET_NAME = "bracket_name";
    private static final String COLUMN_PLAYER_1 = "player_1";
    private static final String COLUMN_PLAYER_2 = "player_2";
    private static final String COLUMN_PLAYER_3 = "player_3";
    private static final String COLUMN_PLAYER_4 = "player_4";
    private static final String COLUMN_PLAYER_5 = "player_5";
    private static final String COLUMN_PLAYER_6 = "player_6";
    private static final String COLUMN_PLAYER_7 = "player_7";
    private static final String COLUMN_PLAYER_8 = "player_8";
    private static final String COLUMN_R1WINNER_1 = "winner_1_round_1";
    private static final String COLUMN_R1WINNER_2 = "winner_2_round_1";
    private static final String COLUMN_R1WINNER_3 = "winner_3_round_1";
    private static final String COLUMN_R1WINNER_4 = "winner_4_round_1";
    private static final String COLUMN_R1LOSER_1 = "loser_1_round_1";
    private static final String COLUMN_R1LOSER_2 = "loser_2_round_1";
    private static final String COLUMN_R1LOSER_3 = "loser_3_round_1";
    private static final String COLUMN_R1LOSER_4 = "loser_4_round_1";
    private static final String COLUMN_R2WINNER_1 = "winner_1_round_2";
    private static final String COLUMN_R2WINNER_2 = "winner_2_round_2";
    private static final String COLUMN_R2LOSER_1 = "loser_1_round_2";
    private static final String COLUMN_R2LOSER_2 = "loser_2_round_2";
    private static final String COLUMN_R3WINNER = "winner_round_3";
    private static final String COLUMN_R3LOSER = "loser_round_3";
    private static final String COLUMN_ROUND = "round";

    // Exceptions and Overrides
    private String CREATE_BRACKET_TABLE = "CREATE TABLE "
            + TABLE_BRACKETS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_BRACKET_NAME + " TEXT, "
            + COLUMN_PLAYER_1 + " TEXT, "
            + COLUMN_PLAYER_2 + " TEXT, "
            + COLUMN_PLAYER_3 + " TEXT, "
            + COLUMN_PLAYER_4 + " TEXT, "
            + COLUMN_PLAYER_5 + " TEXT, "
            + COLUMN_PLAYER_6 + " TEXT, "
            + COLUMN_PLAYER_7 + " TEXT, "
            + COLUMN_PLAYER_8 + " TEXT, "
            + COLUMN_R1WINNER_1 + " TEXT, "
            + COLUMN_R1WINNER_2 + " TEXT, "
            + COLUMN_R1WINNER_3 + " TEXT, "
            + COLUMN_R1WINNER_4 + " TEXT, "
            + COLUMN_R1LOSER_1 + " TEXT, "
            + COLUMN_R1LOSER_2 + " TEXT, "
            + COLUMN_R1LOSER_3 + " TEXT, "
            + COLUMN_R1LOSER_4 + " TEXT, "
            + COLUMN_R2WINNER_1 + " TEXT, "
            + COLUMN_R2WINNER_2 + " TEXT, "
            + COLUMN_R2LOSER_1 + " TEXT, "
            + COLUMN_R2LOSER_2 + " TEXT, "
            + COLUMN_R3WINNER + " TEXT, "
            + COLUMN_R3LOSER + " TEXT, "
            + COLUMN_ROUND + " INTEGER)";

    public DBHandlerBracket(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BRACKET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRACKETS);
        //creating tables again
        onCreate(db);
    }

    public void addBracket(Bracket bracket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BRACKET_NAME, bracket.getBracketName());
        values.put(COLUMN_PLAYER_1, bracket.getPlayer1());
        values.put(COLUMN_PLAYER_2, bracket.getPlayer2());
        values.put(COLUMN_PLAYER_3, bracket.getPlayer3());
        values.put(COLUMN_PLAYER_4, bracket.getPlayer4());
        values.put(COLUMN_PLAYER_5, bracket.getPlayer5());
        values.put(COLUMN_PLAYER_6, bracket.getPlayer6());
        values.put(COLUMN_PLAYER_7, bracket.getPlayer7());
        values.put(COLUMN_PLAYER_8, bracket.getPlayer8());
        values.put(COLUMN_R1WINNER_1, bracket.getR1winner1());
        values.put(COLUMN_R1WINNER_2, bracket.getR1winner2());
        values.put(COLUMN_R1WINNER_3, bracket.getR1winner3());
        values.put(COLUMN_R1WINNER_4, bracket.getR1winner4());
        values.put(COLUMN_R1LOSER_1,  bracket.getR1loser1());
        values.put(COLUMN_R1LOSER_2,  bracket.getR1loser2());
        values.put(COLUMN_R1LOSER_3,  bracket.getR1loser3());
        values.put(COLUMN_R1LOSER_4,  bracket.getR1loser4());
        values.put(COLUMN_R2WINNER_1, bracket.getR2winner1());
        values.put(COLUMN_R2WINNER_2, bracket.getR2winner2());
        values.put(COLUMN_R2LOSER_1,  bracket.getR2loser1());
        values.put(COLUMN_R2LOSER_2,  bracket.getR2loser2());
        values.put(COLUMN_R3WINNER, bracket.getFinalWinner());
        values.put(COLUMN_R3LOSER,  bracket.getFinalLoser());
        values.put(COLUMN_ROUND,  bracket.getCurrentRound());

        //Inserting Row
        db.insert(TABLE_BRACKETS, null, values);
        db.close();
    }

    //Getting a bracket
    public Bracket getBracket(String name) {
        String [] columns = {
                KEY_ID, COLUMN_BRACKET_NAME, COLUMN_PLAYER_1, COLUMN_PLAYER_2,
                COLUMN_PLAYER_3, COLUMN_PLAYER_4, COLUMN_PLAYER_5,
                COLUMN_PLAYER_6, COLUMN_PLAYER_7, COLUMN_PLAYER_8,
                COLUMN_R1WINNER_1, COLUMN_R1WINNER_2, COLUMN_R1WINNER_3,
                COLUMN_R1WINNER_4, COLUMN_R1LOSER_1, COLUMN_R1LOSER_2,
                COLUMN_R1LOSER_3, COLUMN_R1LOSER_4, COLUMN_R2WINNER_1,
                COLUMN_R2WINNER_2, COLUMN_R2LOSER_1, COLUMN_R2LOSER_2,
                COLUMN_R3WINNER, COLUMN_R3LOSER, COLUMN_ROUND
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = COLUMN_BRACKET_NAME + " =?";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(TABLE_BRACKETS, columns, selectQuery, selectionArgs,
                null, null, null);
        cursor.moveToFirst();
        db.close();
        Bracket bracket = new Bracket();
        bracket.setbID(cursor.getInt(0));
        bracket.setBracketName(cursor.getString(1));
        bracket.setPlayer1(cursor.getString(2));
        bracket.setPlayer2(cursor.getString(3));
        bracket.setPlayer3(cursor.getString(4));
        bracket.setPlayer4(cursor.getString(5));
        bracket.setPlayer5(cursor.getString(6));
        bracket.setPlayer6(cursor.getString(7));
        bracket.setPlayer7(cursor.getString(8));
        bracket.setPlayer8(cursor.getString(9));
        bracket.setR1winner1(cursor.getString(10));
        bracket.setR1winner2(cursor.getString(11));
        bracket.setR1winner3(cursor.getString(12));
        bracket.setR1winner4(cursor.getString(13));
        bracket.setR1loser1(cursor.getString(14));
        bracket.setR1loser2(cursor.getString(15));
        bracket.setR1loser3(cursor.getString(16));
        bracket.setR1loser4(cursor.getString(17));
        bracket.setR2winner1(cursor.getString(18));
        bracket.setR2winner2(cursor.getString(19));
        bracket.setR2loser1(cursor.getString(20));
        bracket.setR2loser2(cursor.getString(21));
        bracket.setFinalWinner(cursor.getString(22));
        bracket.setFinalLoser(cursor.getString(23));
        bracket.setCurrentRound(cursor.getInt(24));
        cursor.close();

        return bracket;
    }

    public List<Bracket> getAllBrackets() {
        List<Bracket> bracketList = new ArrayList<Bracket>();
        //Select All Query
        String selectrQuery = "SELECT * FROM" + TABLE_BRACKETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectrQuery, null);
        if(cursor.moveToFirst()) {
            do {
                Bracket bracket = new Bracket();
                bracket.setbID(Integer.parseInt(cursor.getString(0)));
                bracket.setBracketName(cursor.getString(1));
                bracket.setPlayer1(cursor.getString(2));
                bracket.setPlayer2(cursor.getString(3));
                bracket.setPlayer3(cursor.getString(4));
                bracket.setPlayer4(cursor.getString(5));
                bracket.setPlayer5(cursor.getString(6));
                bracket.setPlayer6(cursor.getString(7));
                bracket.setPlayer7(cursor.getString(8));
                bracket.setPlayer8(cursor.getString(9));
                bracket.setR1winner1(cursor.getString(10));
                bracket.setR1winner2(cursor.getString(11));
                bracket.setR1winner3(cursor.getString(12));
                bracket.setR1winner4(cursor.getString(13));
                bracket.setR1loser1(cursor.getString(14));
                bracket.setR1loser2(cursor.getString(15));
                bracket.setR1loser3(cursor.getString(16));
                bracket.setR1loser4(cursor.getString(17));
                bracket.setR2winner1(cursor.getString(18));
                bracket.setR2winner2(cursor.getString(19));
                bracket.setR2loser1(cursor.getString(20));
                bracket.setR2loser2(cursor.getString(21));
                bracket.setFinalWinner(cursor.getString(22));
                bracket.setFinalLoser(cursor.getString(23));

                bracketList.add(bracket);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bracketList;
    }

    public int updateBracket(Bracket bracket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PLAYER_1, bracket.getPlayer1());
        values.put(COLUMN_PLAYER_2, bracket.getPlayer2());
        values.put(COLUMN_PLAYER_3, bracket.getPlayer3());
        values.put(COLUMN_PLAYER_4, bracket.getPlayer4());
        values.put(COLUMN_PLAYER_5, bracket.getPlayer5());
        values.put(COLUMN_PLAYER_6, bracket.getPlayer6());
        values.put(COLUMN_PLAYER_7, bracket.getPlayer7());
        values.put(COLUMN_PLAYER_8, bracket.getPlayer8());
        values.put(COLUMN_R1WINNER_1, bracket.getR1winner1());
        values.put(COLUMN_R1WINNER_2, bracket.getR1winner2());
        values.put(COLUMN_R1WINNER_3, bracket.getR1winner3());
        values.put(COLUMN_R1WINNER_4, bracket.getR1winner4());
        values.put(COLUMN_R1LOSER_1, bracket.getR1loser1());
        values.put(COLUMN_R1LOSER_2, bracket.getR1loser2());
        values.put(COLUMN_R1LOSER_3, bracket.getR1loser3());
        values.put(COLUMN_R1LOSER_4, bracket.getR1loser4());
        values.put(COLUMN_R2WINNER_1, bracket.getR2winner1());
        values.put(COLUMN_R2WINNER_2, bracket.getR2winner2());
        values.put(COLUMN_R2LOSER_1, bracket.getR2loser1());
        values.put(COLUMN_R2LOSER_2, bracket.getR2loser2());
        values.put(COLUMN_R3WINNER, bracket.getFinalWinner());
        values.put(COLUMN_R3LOSER, bracket.getFinalLoser());
        values.put(COLUMN_ROUND, bracket.getCurrentRound());

        return db.update(TABLE_BRACKETS, values, KEY_ID
                + "= ?", new String[]{String.valueOf(bracket.getbID())});
}

    public boolean checkBracket(String bracketName) {
        String [] columns ={
                KEY_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_BRACKET_NAME + " =?";
        String[] selectionArgs = {bracketName};
        Cursor cursor = db.query(TABLE_BRACKETS,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0) {
            return true;
        }
        return false;
    }
}
