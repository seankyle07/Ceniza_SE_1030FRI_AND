package com.ceniza.listviewapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<String> itemList;
    private Context context;

    public CustomAdapter(Context context, List<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        CheckBox checkBox = convertView.findViewById(R.id.itemCheckBox);
        TextView textView = convertView.findViewById(R.id.itemTextView);
        ImageView imageView = convertView.findViewById(R.id.itemImageView);

        textView.setText(itemList.get(position));


        convertView.setOnClickListener(new View.OnClickListener() {
            private static final long DOUBLE_CLICK_TIME_DELTA = 300;
            long lastClickTime = 0;

            @Override
            public void onClick(View v) {
                long clickTime = System.currentTimeMillis();
                if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {

                    showOptionsDialog(position);
                }
                lastClickTime = clickTime;
            }
        });

        return convertView;
    }

    private void showOptionsDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option")
                .setItems(new String[]{"Edit", "Delete"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {

                            showEditDialog(position);
                        } else {

                            itemList.remove(position);
                            notifyDataSetChanged();
                        }
                    }
                });
        builder.show();
    }

    private void showEditDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit Item");

        final EditText input = new EditText(context);
        input.setText(itemList.get(position));
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                itemList.set(position, input.getText().toString());
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);

        builder.show();
    }
}