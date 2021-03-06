package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.DBHandlerFriends;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.Model.UserAdapter;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class FriendsListActivity extends AppCompatActivity {
    Button back, cancel;
    ListView listView, friendsListView;
    ArrayList<User> userList = new ArrayList<>();
    UserAdapter adapter, friendAdapter;
    TextView tv;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        back = (Button)findViewById(R.id.back);
        cancel = (Button)findViewById(R.id.cancel);
        listView= (ListView)findViewById(R.id.list);
        listView.setVisibility(View.INVISIBLE);
        friendsListView= (ListView)findViewById(R.id.friendsListView);
        tv = (TextView)findViewById(R.id.TV);
        //friendsListView.setVisibility(View.GONE);
        final String userName = getIntent().getStringExtra("userName");
        final EditText search = (EditText)findViewById(R.id.editText);
        final DBHandler db = new DBHandler(this);
        //fdb.addRequest(sender,receiver);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendsListActivity.this,HomeActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(FriendsListActivity.this.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                search.setText("");
                listView.setVisibility(View.INVISIBLE);
                friendsListView.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
            }
        });

          //test code

          listView.setTextFilterEnabled(true);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  User ListViewClickData = (User) adapterView.getItemAtPosition(i);
                  Intent intent = new Intent(FriendsListActivity.this,ProfileActivity.class);
                  intent.putExtra("userName",userName);
                  intent.putExtra("friendName",ListViewClickData.getUserName() );
                  intent.putExtra("flag", "Friend");
                  intent.putExtra("FriendFlag", "False");
                  intent.putExtra("mapFlag", "False");
                  startActivity(intent);
              }
          });

          friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  User ListViewClickData = (User) adapterView.getItemAtPosition(i);
                  Intent intent = new Intent(FriendsListActivity.this,ProfileActivity.class);
                  intent.putExtra("userName",userName);
                  intent.putExtra("friendName",ListViewClickData.getUserName() );
                  intent.putExtra("flag", "Friend");
                  intent.putExtra("FriendFlag", "True");
                  intent.putExtra("mapFlag", "False");
                  startActivity(intent);
              }
          });

          search.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

              }

              @Override
              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                  adapter.getFilter().filter(charSequence.toString());
                  friendsListView.setVisibility(View.INVISIBLE);
                  listView.setVisibility(View.VISIBLE);
                  tv.setVisibility(View.INVISIBLE);
              }

              @Override
              public void afterTextChanged(Editable editable) {

              }
          });
          search.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  friendsListView.setVisibility(View.INVISIBLE);
                  listView.setVisibility(View.VISIBLE);
                  tv.setVisibility(View.INVISIBLE);
              }
          });



    }

    public void DisplayDataInToListView(){
          DBHandler dbh = new DBHandler(this);
          SQLiteDatabase db = dbh.getWritableDatabase();
          DBHandlerFriends fdb = new DBHandlerFriends(this);
          cursor = db.rawQuery("SELECT name FROM users",null);
          User u;
          userList = new ArrayList<User>();
          if(cursor.moveToFirst()){
              do{
                  u = dbh.getUser(cursor.getString(0));
                  if(!(u.getUserName().equals(getIntent().getStringExtra("userName")))&& !(fdb.getStatus(dbh.getUser(getIntent().getStringExtra("userName")),u))){
                      userList.add(u);
                  }
              }while(cursor.moveToNext());
          }
          adapter = new UserAdapter(FriendsListActivity.this,R.layout.custom_layout, userList);
          listView.setAdapter(adapter);
          cursor.close();
    }

    public void DisplayFriendsList(){
        DBHandler dbh = new DBHandler(this);
        DBHandlerFriends fdbh = new DBHandlerFriends(this);
        SQLiteDatabase db = fdbh.getWritableDatabase();
        //Cursor fc = db.rawQuery("SELECT receiver FROM friends", null);
        String [] columns ={
                "receiver"
        };
        String selectQuery = "sender =?";
        String[] selectionArgs = {dbh.getUser(getIntent().getStringExtra("userName")).getUserName()};
        Cursor fc = db.query("friends",columns,selectQuery,selectionArgs,null,null,null);
        fc.moveToFirst();
        db.close();
        User friend;
        ArrayList<User> friendList = new ArrayList<>();
        if(fc.moveToFirst()){
            do{
                friend = dbh.getUser(fc.getString(0));
                if(!(friend.getUserName().equals(getIntent().getStringExtra("userName")))){
                    friendList.add(friend);
                }
            }while(fc.moveToNext());
        }
        friendAdapter = new UserAdapter(this,R.layout.custom_layout,friendList);
        friendsListView.setAdapter(friendAdapter);
        fc.close();
    }

     @Override
     protected void onResume(){
        DisplayDataInToListView();
        DisplayFriendsList();
        super.onResume();
    }


}
