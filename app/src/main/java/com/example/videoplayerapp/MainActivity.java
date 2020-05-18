package com.example.videoplayerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;//this is used for start stop play pause
    ListView listView;

    ArrayList<String> videoList;
    ArrayAdapter adapter;//calling object to string and used for list view


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoView);//r.file is automatically created
        listView=findViewById(R.id.videoView1);

        videoList= new ArrayList<>();
        videoList.add("video1");
        videoList.add("video2");
        videoList.add("video3");
        videoList.add("video4");



        //adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);//order to dilsplayin the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Intent intent=new Intent(MainActivity.this,Example.class);
                switch (position) {
                    case 0:
                        //videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1));
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));
                        break;//uniform resource identife the string of character  URL=for location
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2));
                        break;

                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
                        break;

                    default:
                        break;

                }
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.requestFocus();//focus to specific view
                videoView.start();//to start the playback video file
            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();//easily added menu items by using this method
        menuInflater.inflate(R.menu.example,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(this,"videoApp Selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.i2:
                Toast.makeText(this,"starred video Selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
