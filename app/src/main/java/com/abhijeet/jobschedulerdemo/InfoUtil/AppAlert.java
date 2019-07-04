package com.abhijeet.jobschedulerdemo.InfoUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.View;

public class AppAlert {

    /**
     * Show Alert Message in Snackbar.
     *
     * @param view
     * @param message
     */
    public static void showAlert(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    /**
     * Show Alert Message in Dialog.
     *
     * @param context
     * @param message
     */
    public static AlertDialog showAlertDialog(Context context, String message) {
        if (context != null) {
            return new AlertDialog.Builder(context).setMessage(message).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
        return null;
    }

    /**
     * Show Alert Message in Dialog.
     *
     * @param context
     * @param message
     */
    public static AlertDialog showAlertDialog(Context context, String message, final DialogListionars dialogListionars) {
        if (context != null) {
            return new AlertDialog.Builder(context).setMessage(message).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    dialogListionars.onClickOK();
                }
            }).show();
        }
        return null;
    }


    public interface DialogListionars {
        void onClickOK();
    }

}
