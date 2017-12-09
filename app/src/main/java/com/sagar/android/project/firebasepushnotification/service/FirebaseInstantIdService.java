package com.sagar.android.project.firebasepushnotification.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.sagar.android.project.firebasepushnotification.Const;

public class FirebaseInstantIdService extends FirebaseInstanceIdService {
    public FirebaseInstantIdService() {
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(Const.LOG_TAG, "Refreshed token: " + refreshedToken);
//        sendRegistrationToServer(refreshedToken);
    }
}
