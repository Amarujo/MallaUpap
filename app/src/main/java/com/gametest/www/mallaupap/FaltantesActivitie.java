package com.gametest.www.mallaupap;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class FaltantesActivitie extends AppCompatActivity {

    public static ListView mListFaltantes;
    private static MateriaSimpleCursorAdapter mCursorAdapter;
    static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltantes);

        mContext = this;

        mListFaltantes = (ListView)findViewById(R.id.lista_faltantes);

        Cursor cursor = MainActivity.mDbAdapter.fetchFaltantes();

        String[] from = new String[]{
                MateriaDbAdapter.COL_MATERIA
        };

        int[] to = new int[]{
                R.id.row_text
        };

        mCursorAdapter = new MateriaSimpleCursorAdapter(
                this,
                R.layout.layout_materia,
                cursor,
                from,
                //a las ids de views en el layout
                to,
                //flag - no usado
                0,
                MainActivity.mDbAdapter);



        mListFaltantes.setAdapter(mCursorAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filtros,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.backMenu){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    public static void refreshListView()  {
//        mListFaltantes.setAdapter(new AvisosSimpleCursorAdapter(
//                context,
//                R.layout.layout_materia,
//                MainActivity.mDbAdapter.fetchFaltantes(),
//                new String[]{AvisoDbAdapter.COL_MATERIA},
//                new int[]{R.id.row_text},
//                0,
//
//                MainActivity.mDbAdapter
//
//                ));
//        mListFaltantes.setSelection(pos);
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Toast.makeText(mContext, "Removida de faltantes", Toast.LENGTH_SHORT).show();
        mCursorAdapter.changeCursor(MainActivity.mDbAdapter.fetchFaltantes());//Salvadora
    }
}
