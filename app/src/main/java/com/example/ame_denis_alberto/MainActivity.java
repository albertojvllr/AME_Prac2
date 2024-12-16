package com.example.ame_denis_alberto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ame_denis_alberto.model.DataSource;
import com.example.ame_denis_alberto.model.DataSourceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource data = DataSourceFactory.getDataSource(DataSource.DataSourceType.HARDCODED);
        data.loadModel();
        // Referencias a las vistas
        EditText edUserName = findViewById(R.id.edUserName);
        EditText edPasswd = findViewById(R.id.edPasswd);
        Button btnLogin = findViewById(R.id.btnLogin);

        // Listener para el botón
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener usuario y contraseña
                String username = edUserName.getText().toString();
                String password = edPasswd.getText().toString();

                // Validar credenciales
                if (username.equals("admin") && password.equals("1234")) {
                    // Cambiar a SectionsActivity
                    Intent intent = new Intent(MainActivity.this, SectionsActivity.class);
                    startActivity(intent);
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
