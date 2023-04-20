package com.example.theto_dolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ReturnTask {

    RecyclerView recyclerView;
    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewLabel);
        textView.setText(new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date()));

        Button button = findViewById(R.id.buttonAddTask);
        button.setOnClickListener(view -> {
            Log.d(TAG, " Add Task Button Clicked");
            AddTaskDialogFragment  addTaskDialogFragment = new AddTaskDialogFragment();
            addTaskDialogFragment.show(getSupportFragmentManager(), "Add Task Dialog Fragment");
        });
    }

    @Override
    public void returnTask(String task, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday) {

    }
}