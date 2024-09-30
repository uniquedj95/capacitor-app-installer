package com.mycompany.capacitor.app.installer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.File;

@CapacitorPlugin(name = "CapacitorAppInstaller")
public class CapacitorAppInstallerPlugin extends Plugin {

    @PluginMethod
    public void install(PluginCall call) {
        String apkPath = call.getString("file");

        if (apkPath == null) {
            call.reject("APK path must be provided");
            return;
        }

        Context context = getContext();
        File apkFile = new File(apkPath);

        Uri apkUri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            apkUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", apkFile);
        } else {
            apkUri = Uri.fromFile(apkFile);
        }

        Log.i("CapacitorAppInstaller", "APK URI: " + apkUri);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(intent);

        Log.i("CapacitorAppInstaller", "APK installation started");
        call.resolve();
    }
}
