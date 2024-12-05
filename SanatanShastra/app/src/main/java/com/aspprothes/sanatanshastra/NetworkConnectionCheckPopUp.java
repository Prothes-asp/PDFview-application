package com.aspprothes.sanatanshastra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import soup.neumorphism.NeumorphButton;

public class NetworkConnectionCheckPopUp extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!CommonNetworkCheck.isConnectedNetwork(context)){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.internet_popup_design,null);
            NeumorphButton retryBtn = view.findViewById(R.id.retryBtn);
            builder.setView(view);
            AlertDialog alertDialog = builder.create();
            alertDialog.setCancelable(false);
            alertDialog.getWindow().setGravity(Gravity.CENTER);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();
            retryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    onReceive(context,intent);
                }
            });
        }
    }
}
