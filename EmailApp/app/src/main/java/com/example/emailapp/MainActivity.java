package com.example.emailapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Email, Subject, Message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.Email);
        Subject = findViewById(R.id.Subject);
        Message = findViewById(R.id.Message);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String email = Email.getText().toString();
            String subject = Subject.getText().toString();
            String message = Message.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            try {
                startActivity(Intent.createChooser(intent, "Choose Email App"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "No email client installed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
