package com.example.mycontactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initItemClick();

        ContactDataSource ds = new ContactDataSource(this);
        ArrayList<String> names;

        try

        {
            ds.open();
            names = ds.getContactName();
            ds.close();
            ListView listView = (ListView) findViewById(R.id.lvContact);
            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
        }

        catch (Exception e)
        {
            Toast.makeText (this, "Error receiving contacts", Toast.LENGTH_LONG).show();
        }
    }
    private void initItemClick() {
        ListView listview = (ListView) findViewById(R.id.lvContact);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {

                Intent intent = new Intent(ContactListActivity.this, ContactActivity.class);

                startActivity(intent);
            }
        });
    }
}


