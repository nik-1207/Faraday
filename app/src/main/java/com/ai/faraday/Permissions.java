package com.ai.faraday;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

class Permissions
{
    private final int GRANT_CODE;

    Permissions() {
        GRANT_CODE =1;
    }

    boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    void grantPermission(Context context, String... permissions)
    {
        if (context != null && permissions != null)
        {
            ActivityCompat.requestPermissions((Activity) context,permissions,GRANT_CODE);
        }
    }
}
