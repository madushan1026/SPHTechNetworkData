package com.kasundesilva.sphtechnetworkdata.Utills;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtills {

    public static boolean isNetworkAvailable(Context context) {
        boolean isConnexted = false;
        // get Connectivity Manager object to check connection
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connect.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                isConnexted = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                isConnexted = true;
            }
        } else {
            // not connected to the internet
            isConnexted = false;
        }
        return isConnexted;
    }
}
