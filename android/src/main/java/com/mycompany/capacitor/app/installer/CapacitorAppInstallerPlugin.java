package com.mycompany.capacitor.app.installer;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapacitorAppInstaller")
public class CapacitorAppInstallerPlugin extends Plugin {

    @PluginMethod
    public void install(PluginCall call) {
        String apkPath = call.getString("path");

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

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(intent);

        call.resolve();
    }
}
