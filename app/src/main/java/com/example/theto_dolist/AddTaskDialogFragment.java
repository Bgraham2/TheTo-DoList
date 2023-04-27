package com.example.theto_dolist;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AddTaskDialogFragment extends androidx.fragment.app.DialogFragment {

    private static final String TAG = "Add Task Dialog Fragment";

    private ReturnTask returnTask;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View viewAddTask = inflater.inflate(R.layout.add_task_dialog_fragment, container, false);

        EditText editTextAddTask = viewAddTask.findViewById(R.id.editTextAddTask);
        CheckBox checkBoxSunday = viewAddTask.findViewById(R.id.checkBoxSunday);
        CheckBox checkBoxMonday = viewAddTask.findViewById(R.id.checkBoxMonday);
        CheckBox checkBoxTuesday = viewAddTask.findViewById(R.id.checkBoxTuesday);
        CheckBox checkBoxWednesday = viewAddTask.findViewById(R.id.checkBoxWednesday);
        CheckBox checkBoxThursday = viewAddTask.findViewById(R.id.checkBoxThursday);
        CheckBox checkBoxFriday = viewAddTask.findViewById(R.id.checkBoxFriday);
        CheckBox checkBoxSaturday = viewAddTask.findViewById(R.id.checkBoxSaturday);

        Button buttonClose = viewAddTask.findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(view -> dismiss());

        Button buttonSave = viewAddTask.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(view -> {
            Log.d(TAG, " Task Saved.");
            DailyTask dailyTask = new DailyTask(editTextAddTask.getText().toString(), checkBoxSunday.isChecked(), checkBoxMonday.isChecked(), checkBoxTuesday.isChecked(),
                    checkBoxWednesday.isChecked(), checkBoxThursday.isChecked(), checkBoxFriday.isChecked(), checkBoxSaturday.isChecked());
            returnTask.returnTask(dailyTask);
            dismiss();
        });

        return viewAddTask;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            returnTask = (ReturnTask)getActivity();
        } catch (ClassCastException e) {
            Log.e(TAG, " " + e);
        }
    }
}
