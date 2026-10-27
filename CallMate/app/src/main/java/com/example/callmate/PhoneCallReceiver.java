package com.example.callmate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                showToast(context, "Incoming Call From: " + (phoneNumber != null ? phoneNumber : "Unknown"));
            } else if (phoneState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                showToast(context, "Call Started");
            } else if (phoneState.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                showToast(context, "Call Ended");
            }
        }
    }

    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
