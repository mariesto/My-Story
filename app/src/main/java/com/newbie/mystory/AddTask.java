package com.newbie.mystory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class AddTask extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myReference;
    EditText textTitle;
    EditText textContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        database = FirebaseDatabase.getInstance();
    }

    public void addStoryButton(View view) {
        textTitle = findViewById(R.id.title);
        textContent = findViewById(R.id.content);

        String title = textTitle.getText().toString();
        String content = textContent.getText().toString();
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyy h:mm a");
        String dateString = sdf.format(date);

        myReference = database.getInstance().getReference().child("Story");
        DatabaseReference newStory = myReference.push();

        newStory.child("title").setValue(title);
        newStory.child("content").setValue(content);
        newStory.child("time").setValue(dateString);

    }
}
