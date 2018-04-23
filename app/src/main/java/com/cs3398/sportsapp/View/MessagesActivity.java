package com.cs3398.sportsapp.View;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.DBHandlerMsg;
import com.cs3398.sportsapp.Model.Message;
import com.cs3398.sportsapp.Model.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import com.cs3398.sportsapp.R;
import com.cs3398.sportsapp.Model.DBHandler;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);


        // Grab username through intent

        Intent intent = getIntent();
        final String userName = getIntent().getStringExtra("userName");
        final TextView message = findViewById(R.id.textView26);
        Button submit = findViewById(R.id.button4);
        Button refresh = findViewById(R.id.button5);
        final EditText toField = findViewById(R.id.editText2);
        final EditText msg = findViewById(R.id.editText3);




        //Create message database object to retrieve messages
        final DBHandlerMsg dbmsg = new DBHandlerMsg(MessagesActivity.this);



        //dbmsg.addMsg("t", "t2", "test message.");//hardcoded username test


        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dbmsg.addMsg(userName,toField.getText().toString(),msg.getText().toString());
            }
        });

        refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                refreshMessages();
            }
        });


    }

    public void refreshMessages() {
        final String userName = getIntent().getStringExtra("userName");
        TextView tv;
        LinearLayout linear = new LinearLayout(this);
        linear = (LinearLayout) findViewById(R.id.linear1);
        final DBHandlerMsg dbmsg = new DBHandlerMsg(MessagesActivity.this);
        List<Message> newMessages = dbmsg.getAllMsg(userName);
        for (Message msgs : newMessages) {
            tv = new TextView(this);
            tv.setText(msgs.getContent());
            linear.addView(tv);
        }
    }



}
