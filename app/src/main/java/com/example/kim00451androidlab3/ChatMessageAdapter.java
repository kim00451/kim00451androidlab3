package com.example.kim00451androidlab3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class ChatMessageAdapter extends ArrayAdapter {

    List msgs = new ArrayList();

    public ChatMessageAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    //@Override
    public void add(ChatMessage object){
        msgs.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public ChatMessage getItem(int index) {
        return (ChatMessage) msgs.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.chatting_message, parent, false);
        }
        ChatMessage msg = (ChatMessage) msgs.get(position);

        TextView msgText = row.findViewById(R.id.listView1);
        msgText.setText(msg.getMessage());
        msgText.setTextColor(Color.parseColor("#000000"));

        return row;

    }
}




