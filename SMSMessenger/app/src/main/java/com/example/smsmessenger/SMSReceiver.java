package com.example.smsmessenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Object[] pdus = (Object[]) intent.getExtras().get("pdus");
            StringBuilder messageBuilder = new StringBuilder();
            for (Object pdu : pdus) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                String message = smsMessage.getMessageBody();
                messageBuilder.append(message).append("\n");
            }
            // Show received message to the user (in your activity or use a BroadcastReceiver for the UI)
        }
    }
}
