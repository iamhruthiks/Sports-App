package com.example.sports;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    List<Sport> sportList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.recyclerView);

        sportList=new ArrayList<>();

        Sport sport1=new Sport("Football",R.drawable.football);
        Sport sport2=new Sport("Basketball",R.drawable.basketball);
        Sport sport3=new Sport("Volleyball",R.drawable.volley);
        Sport sport4=new Sport("Tennis",R.drawable.tennis);
        Sport sport5=new Sport("Ping Pong",R.drawable.ping);

        sportList.add(sport1);
        sportList.add(sport2);
        sportList.add(sport3);
        sportList.add(sport4);
        sportList.add(sport5);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new CustomAdapter(sportList);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);


    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, ""+sportList.get(position).sportName, Toast.LENGTH_SHORT).show();
    }
}