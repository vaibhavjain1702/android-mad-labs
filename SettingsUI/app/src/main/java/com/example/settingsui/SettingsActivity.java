package com.yourpackage.yourapp; // CHANGE THIS to your actual package name

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity { // Rename class if needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file created above
        setContentView(R.layout.activity_settings);

        // Find clickable rows by their IDs from the layout
        LinearLayout languageRow = findViewById(R.id.row_language);
        LinearLayout userNameRow = findViewById(R.id.row_user_name);
        LinearLayout settingVoiceRow = findViewById(R.id.row_setting_voice);
        LinearLayout themeRow = findViewById(R.id.row_theme);

        // Find the Bottom Navigation View
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // --- Setup Bottom Navigation ---
        // Set the 'More' item as selected by default to match the image
        bottomNav.setSelectedItemId(R.id.navigation_more);

        // Add listener for item clicks on the bottom navigation
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_chat) {
                showToast("Chat Clicked");
                // TODO: Navigate to Chat screen/fragment
                return true; // Consume the event
            } else if (itemId == R.id.navigation_home) {
                showToast("Home Clicked");
                // TODO: Navigate to Home screen/fragment
                return true; // Consume the event
            } else if (itemId == R.id.navigation_more) {
                // Already on this screen (or handle refresh/logic)
                showToast("More Clicked (Current Screen)");
                return true; // Consume the event
            }
            return false; // Allow default behavior if item ID not handled
        });


        // --- Setup Click Listeners for the Setting Rows ---
        languageRow.setOnClickListener(v -> {
            showToast("Language Settings Clicked");
            // TODO: Add logic to change language (e.g., show dialog, open new activity)
        });

        userNameRow.setOnClickListener(v -> {
            showToast("User Name Clicked");
            // TODO: Add logic to view/edit user profile
        });

        settingVoiceRow.setOnClickListener(v -> {
            showToast("Voice Settings Clicked");
            // TODO: Add logic for voice settings
        });

        themeRow.setOnClickListener(v -> {
            showToast("Theme Settings Clicked");
            // TODO: Add logic to change app theme (e.g., show dialog)
        });
    }

    // Helper method for showing temporary messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}