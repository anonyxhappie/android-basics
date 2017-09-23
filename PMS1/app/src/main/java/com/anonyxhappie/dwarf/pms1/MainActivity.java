package com.anonyxhappie.dwarf.pms1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String IMDBURL = "https://api.themoviedb.org/3/movie/popular?api_key="+ BuildConfig.THEMOVIEDB_ORG_API_KEY +"&language=en-US&page=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieAsyncTask movieAsyncTask = new MovieAsyncTask(this);
        movieAsyncTask.execute(IMDBURL);

    }


    public class MovieAsyncTask extends AsyncTask<String, Void, ArrayList<MovieModel>> {

        Context context;
        GridView view;

        public MovieAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected ArrayList<MovieModel> doInBackground(String... params) {

            if (params.length < 1 || params[0]==null){
                return null;
            }
            try {
                 return  Utils.extractDataFromJSON(Utils.makeHttpRequest(Utils.generateUrl(params[0])));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<MovieModel> movieList) {
            super.onPostExecute(movieList);
            updateUi(movieList);
        }

        public void updateUi(final ArrayList<MovieModel> movieList){
            view = (GridView) findViewById(R.id.grid_view);

            GridAdapter adapter = new GridAdapter(context, movieList);
            adapter.notifyDataSetChanged();
            view.setAdapter(adapter);

            view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    MovieModel movieModel = (MovieModel) parent.getAdapter().getItem(position);
                    intent.putExtra("i_key", movieModel);
                    startActivity(intent);
                }
            });
        }


    }

}
