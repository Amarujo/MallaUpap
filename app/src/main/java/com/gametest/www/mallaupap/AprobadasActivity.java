package com.gametest.www.mallaupap;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class AprobadasActivity extends AppCompatActivity {

    public static ListView mListAprobadas;
    private static AvisosSimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprobadas);

        mListAprobadas = (ListView)findViewById(R.id.lista_aprobadas);

        Cursor cursor = MainActivity.mDbAdapter.fetchAprobadas();

        String[] from = new String[]{
                AvisoDbAdapter.COL_MATERIA
        };

        int[] to = new int[]{
                R.id.row_text
        };

        mCursorAdapter = new AvisosSimpleCursorAdapter(
                this,
                R.layout.layout_materia,
                cursor,
                from,
                //a las ids de views en el layout
                to,
                //flag - no usado
                0,
                MainActivity.mDbAdapter);



        mListAprobadas.setAdapter(mCursorAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filtros, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.backMenu) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public static void refreshListView(){


        mCursorAdapter.changeCursor(MainActivity.mDbAdapter.fetchAprobadas());

    }


}
