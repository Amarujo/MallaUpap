package com.gametest.www.mallaupap;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class CanceladasActivity extends AppCompatActivity {

    public static ListView mListCanceladas;
    private static AvisosSimpleCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canceladas);

        mListCanceladas = (ListView)findViewById(R.id.lista_canceladas);

        mCursorAdapter = new AvisosSimpleCursorAdapter(
                this,
                R.layout.layout_materia,
                MainActivity.mDbAdapter.fetchCanceladas(),
                new String[]{AvisoDbAdapter.COL_MATERIA},
                new int[]{R.id.row_text},
                0,
                MainActivity.mDbAdapter
        );

        mListCanceladas.setAdapter(mCursorAdapter);

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
        mCursorAdapter.changeCursor(MainActivity.mDbAdapter.fetchCanceladas());
    }
}
