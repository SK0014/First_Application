package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    //String []a={"Spiderman","Iron man","captain america","Flash","Loki","Thor","Groot"};
    ListView list_item;
    GridView gridView;
    RecyclerView recyclerView;
    EditText edthero,edtteam;
    Button btnupdate;
    ArrayList<Hero>heros;
    MyRecycleAdapter myRecycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        recyclerView=findViewById(R.id.Recycler_view);
        edthero=findViewById(R.id.edt_hero);
        edtteam=findViewById(R.id.edt_team);
        btnupdate=findViewById(R.id.btn_update);
        //list_item=findViewById(R.id.item_list);
        //gridView=findViewById(R.id.item_grid);
        //MyHomepageAdapter myHomepage=new MyHomepageAdapter(this,a);
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.home_layout,R.id.txt_listItem,a);
        //gridView.setAdapter(myHomepage);
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.home_layout,R.id.txt_listItem,a); // this is default adapter
        //MyHomepageAdapter myHomepage=new MyHomepageAdapter(this,a);                               //  this is custom adapter
       //list_item.setAdapter(myHomepage);
       heros=new ArrayList<>();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hero=edthero.getText().toString();
                String team=edtteam.getText().toString();
                heros.add(new Hero(hero,team));
                myRecycleAdapter.notifyDataSetChanged();

            }
        });
        /*list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=myHomepage.getItem(position).toString();
                Toast.makeText(HomePage.this, value, Toast.LENGTH_SHORT).show();
            }
        });*/
         myRecycleAdapter=new MyRecycleAdapter(this,heros);
        recyclerView.setHasFixedSize(true);
       // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.setAdapter(myRecycleAdapter);


    }
}