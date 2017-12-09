package com.sagar.android.project.firebasepushnotification.service;

import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.sagar.android.project.firebasepushnotification.Const;

import org.json.JSONObject;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    public FirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.e(Const.LOG_TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage == null)
            return;

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.e(Const.LOG_TAG, "Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e(Const.LOG_TAG, "Data Payload: " + remoteMessage.getData().toString());

            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
            } catch (Exception e) {
                Log.e(Const.LOG_TAG, "Exception: " + e.getMessage());
            }
        }
    }
}
