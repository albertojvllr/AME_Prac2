package com.example.ame_denis_alberto;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ame_denis_alberto.model.DataSource;

public class SectionsActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                String section_id = result.getData().getStringExtra("id");
                double level = DataSource.getInstance().Recalculate(section_id);
            }
        });
    }

    public void OpenObjectives (String section_id) {
        Intent intent = new Intent(this, ObjectivesActivity.class);
        intent.putExtra("id", section_id);
        activityResultLauncher.launch(intent);
    }
}
