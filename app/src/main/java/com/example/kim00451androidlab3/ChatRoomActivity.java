package com.example.kim00451androidlab3;

import android.database.DataSetObserver;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class ChatRoomActivity extends AppCompatActivity{
    ChatMessageAdapter chatMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        chatMessageAdapter = new ChatMessageAdapter(this.getApplicationContext(),R.layout.chatting_message);
        final ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(chatMessageAdapter);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        // When message is added, it makes listview to scroll last message
        chatMessageAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatMessageAdapter.getCount()-1);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sendBtn) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void send(View view){
        EditText etMsg = (EditText)findViewById(R.id.entermessage);
        String strMsg = (String)etMsg.getText().toString();
        chatMessageAdapter.add(new ChatMessage(strMsg));
    }
}
