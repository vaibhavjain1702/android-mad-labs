package com.example.videorecorder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEO_REQUEST_CODE = 200;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private Uri capturedVideoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ask camera permission if not already given
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
        }
    }

    public void recordVideo(android.view.View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST_CODE);
        } else {
            Toast.makeText(this, "No compatible app found to record video", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VIDEO_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            capturedVideoUri = data.getData();
            Toast.makeText(this, "Video Recorded: " + capturedVideoUri.toString(), Toast.LENGTH_SHORT).show();

            // Play the recorded video using default media player
            Intent playIntent = new Intent(Intent.ACTION_VIEW, capturedVideoUri);
            playIntent.setDataAndType(capturedVideoUri, "video/mp4");
            startActivity(playIntent);
        } else {
            Toast.makeText(this, "Recording cancelled or failed", Toast.LENGTH_SHORT).show();
        }
    }
}
