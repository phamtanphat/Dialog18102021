package com.example.dialog18102021;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatButton;

public class AppDialog {

    public static void setDialogConfirm(Context context, OnListenerConfirmDialog onListenerConfirmDialog){
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        // set vi trí hiển thị dialog
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;

        // kich thước chiều ngang và chiều cao dialog
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        //set màu nền khi hiện dialog
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Ánh xạ
        AppCompatButton btnDelete = dialog.findViewById(R.id.buttonDelete);
        AppCompatButton btnCancel = dialog.findViewById(R.id.buttonCancel);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerConfirmDialog.onCancel();
                dialog.cancel();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerConfirmDialog.onDelete();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
