package com.example.films;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    String[] movies;
    Vector vec1=new Vector();
    Vector vec2=new Vector();
    boolean[] used;
    int sum = 0;
    TextView films;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = getResources().getStringArray(R.array.Films);
        films=findViewById(R.id.film_title);
        used = new boolean[movies.length];
        Log.d("mytag", "function inCreate called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mytag", "function inResume called");
    }


    public void onClick(View view)
    {
        if (sum == movies.length && view.getId() != R.id.drop)
        {
            films.setText("Все фильмы просмотрены");
            return;
        }

        if (view.getId() == R.id.rand)
        {
            for(int i=0;i<movies.length;i++){
                vec1.add(movies[i]);
            }
            i = (int)(Math.random() * vec1.size());
            sum++;
            films.setText(vec1.get(i).toString());
            vec1.remove(i);
        }

        if (view.getId() == R.id.drop)
        {
            films.setText("Выберите фильм");
            for (int i = 0;i < movies.length;i++)
            {
                vec1.add(movies[i]);
            }
            sum = 0;
        }
    }
}
