package com.gametest.www.mallaupap;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanceladasFragment extends Fragment {

    public static ListView mList;
    private static AvisosSimpleCursorAdapter mCursorAdapter;

    public CanceladasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_aprobados, container, false);

        mList = (ListView)rootView.findViewById(R.id.lista_fragment);

        Cursor cursor = MainActivity.mDbAdapter.fetchCanceladas();

        String[] from = new String[]{
                AvisoDbAdapter.COL_MATERIA
        };

        int[] to = new int[]{
                R.id.row_text
        };

        mCursorAdapter = new AvisosSimpleCursorAdapter(
                getContext(),
                R.layout.layout_materia,
                cursor,
                from,
                //a las ids de views en el layout
                to,
                //flag - no usado
                0,
                MainActivity.mDbAdapter);



        mList.setAdapter(mCursorAdapter);


        return rootView;
    }

    public static void refreshListView(){


        mCursorAdapter.changeCursor(MainActivity.mDbAdapter.fetchCanceladas());

    }

}
