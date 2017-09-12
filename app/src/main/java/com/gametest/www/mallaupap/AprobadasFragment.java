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
 * Activities that contain this fragment must implement the
 * {@link AprobadasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AprobadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AprobadasFragment extends Fragment {

    public static ListView mList;
    private static MateriaSimpleCursorAdapter mCursorAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_aprobados, container, false);

        mList = (ListView)rootView.findViewById(R.id.lista_fragment);

        Cursor cursor = MainActivity.mDbAdapter.fetchAprobadas();

        String[] from = new String[]{
                MateriaDbAdapter.COL_MATERIA
        };

        int[] to = new int[]{
                R.id.row_text
        };

        mCursorAdapter = new MateriaSimpleCursorAdapter(
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

//        ListView lista = (ListView)rootView.findViewById(R.id.lista_fragment);
//        lista.setAdapter(new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1,
//                new String[]{
//                        "Juan",
//                        "Carlos",
//                        "Amoroso"
//                }
//                ));
        return rootView;
    }

    public static void refreshListView(){


        mCursorAdapter.changeCursor(MainActivity.mDbAdapter.fetchAprobadas());

    }

}
