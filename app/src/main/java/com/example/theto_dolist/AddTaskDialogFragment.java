package com.example.theto_dolist;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AddTaskDialogFragment extends androidx.fragment.app.DialogFragment {

    private static final String TAG = "Add Task Dialog Fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View viewAddTask = inflater.inflate(R.layout.add_task_dialog_fragment, container, false);

        EditText editTextAddTask = viewAddTask.findViewById(R.id.editTextAddTask);

        Button buttonClose = viewAddTask.findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(view -> dismiss());

        Button buttonSave = viewAddTask.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, " Task Saved.");
                dismiss();
            }
        });

        return viewAddTask;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
