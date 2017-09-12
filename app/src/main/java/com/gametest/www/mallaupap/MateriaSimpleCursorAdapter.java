package com.gametest.www.mallaupap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 2/1/2017.
 */

public class MateriaSimpleCursorAdapter extends SimpleCursorAdapter {
    int layoutResourceId;
    ViewHolder holder;
    Context mContext;
    MateriaDbAdapter myDb;

    public MateriaSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags, MateriaDbAdapter db) {
        super(context, layout, c, from, to, flags);
        this.layoutResourceId = layout;
        this.mContext = context;
        this.myDb = db;

    }

    //para usar un viewholder, debemos sobrescribir los dos métodos siguientes y definir una clase ViewHolder
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        final int position = cursor.getPosition();



        holder = (ViewHolder) view.getTag();
//        holder = null;
        if (holder == null) {
            holder = new ViewHolder();
            holder.colInd = cursor.getColumnIndexOrThrow(MateriaDbAdapter.COL_ID);
            holder.colImp = cursor.getColumnIndexOrThrow(MateriaDbAdapter.COL_ESTADO);

//            holder.colInd = position+1;
//            holder.colImp = MainActivity.mDbAdapter.getEstado(position+1);

//            holder.listTab =  view.findViewById(R.id.row_text);
            holder.listTab =  view.findViewById(R.id.materia_layout);
//            holder.aprobado = (ImageButton)view.findViewById(R.id.btn_aprobado);
//            holder.cancelado = (ImageButton)view.findViewById(R.id.btn_cancelado);


            holder.materia = (TextView)view.findViewById(R.id.row_text);



            view.setTag(holder);








        }else {
            holder = (ViewHolder) view.getTag();
        }
//        final ViewHolder finalHolder = holder;

//        final int id = MainActivity.mDbAdapter.getId(holder.materia.getText().toString());
            final String materia = holder.materia.getText().toString();

        ImageButton boton_aprobado = (ImageButton)view.findViewById(R.id.btn_aprobado);
        boton_aprobado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = MainActivity.mDbAdapter.getId(materia);
//                Toast.makeText(context, ""+finalHolder.colInd+" estado: "+finalHolder.colImp, Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, ""+holder.listTab.getId(), Toast.LENGTH_SHORT).show();
//                    System.out.println("A "+finalHolder.colImp);
                if (MainActivity.mDbAdapter.getEstado(id)!=1) {
                    MainActivity.mDbAdapter.updateEstado(id, 1);
                }else MainActivity.mDbAdapter.updateEstado(id, 0);

//                notifyDataSetChanged();

//                Activity host = (Activity) view.getContext();
//                Toast.makeText(context, host.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
//                String activityName = host.getClass().getSimpleName();

                MainActivity.refreshListView(mContext, MainActivity.mListView.getFirstVisiblePosition());
                if (AprobadasFragment.mList !=null) AprobadasFragment.refreshListView();
                if (FaltantesFragment.mList!=null) FaltantesFragment.refreshListView();
                if (CanceladasFragment.mList!=null) CanceladasFragment.refreshListView();
//                if(activityName.equalsIgnoreCase("FaltantesActivitie"))FaltantesActivitie.refreshListView();
//                else if(activityName.equalsIgnoreCase("AprobadasActivity"))AprobadasActivity.refreshListView();
//                else if(activityName.equalsIgnoreCase("CanceladasActivity"))CanceladasActivity.refreshListView();
//                view.refreshDrawableState();



            }
        });

        ImageButton boton_cancelado = (ImageButton)view.findViewById(R.id.btn_cancelado);
        boton_cancelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = MainActivity.mDbAdapter.getId(materia);
//                Toast.makeText(context, ""+id+"cancel", Toast.LENGTH_SHORT).show();
//                    System.out.println("A "+finalHolder.colImp);

//                Toast.makeText(context, ""+id+" cancel", Toast.LENGTH_SHORT).show();
                if (MainActivity.mDbAdapter.getEstado(id)!=2) {
                    MainActivity.mDbAdapter.updateEstado(id, 2);
                }else MainActivity.mDbAdapter.updateEstado(id, 0);
//                notifyDataSetChanged();
                MainActivity.refreshListView(mContext, MainActivity.mListView.getFirstVisiblePosition());
                if (AprobadasFragment.mList !=null) AprobadasFragment.refreshListView();
                if (FaltantesFragment.mList!=null) FaltantesFragment.refreshListView();
                if (CanceladasFragment.mList!=null) CanceladasFragment.refreshListView();
//                if (FaltantesActivitie.mListFaltantes!=null)FaltantesActivitie.refreshListView();
//                if (AprobadasActivity.mListAprobadas!=null)AprobadasActivity.refreshListView();
//                if (CanceladasActivity.mListCanceladas !=null)CanceladasActivity.refreshListView();



            }
        });

        if (cursor.getInt(holder.colImp) == 1) {
            holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorAprobado));
//            holder.aprobado.setBackgroundColor(context.getResources().getColor(R.color.colorAprobado));
//            holder.cancelado.setBackgroundColor(context.getResources().getColor(R.color.colorAprobado));
        } else if(cursor.getInt(holder.colImp) == 2){
            holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorCancelado));
//            holder.aprobado.setBackgroundColor(context.getResources().getColor(R.color.colorCancelado));
//            holder.cancelado.setBackgroundColor(context.getResources().getColor(R.color.colorCancelado));
        }else {
            holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorLimpio));
//            holder.aprobado.setBackgroundColor(context.getResources().getColor(R.color.colorLimpio));
//            holder.cancelado.setBackgroundColor(context.getResources().getColor(R.color.colorLimpio));
        }
//        notifyDataSetChanged();




    }





//        @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        View row = convertView;
////        holder = null;
//
//        if (row==null){
//            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
//            row = inflater.inflate(layoutResourceId, parent, false);
//
//
//            holder = new ViewHolder();
//            holder.listTab =  row.findViewById(R.id.row_text);
//            holder.aprobado = (ImageButton)row.findViewById(R.id.btn_aprobado);
//            holder.materia = (TextView)row.findViewById(R.id.row_text);
//
//            row.setTag(holder);
//
//            ImageButton boton = (ImageButton) row.findViewById(R.id.btn_aprobado);
//            final ViewHolder finalHolder = holder;
//            boton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(mContext, ""+myDb.getEstado(position) ,Toast.LENGTH_SHORT).show();
////                    System.out.println(finalHolder.colImp);
////                    myDb.updateEstado(position+1, 1);
////                    myDb.getEstado(position);
////                    holder.colImp = 1;
//                    notifyDataSetChanged();
//                }
//            });
//
//
//        }else {
//            holder = (ViewHolder) row.getTag();
//        }
//
//            if (holder.colImp == 1) {
//                holder.listTab.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_green_dark));
//            } else if(holder.colImp == 2){
//                holder.listTab.setBackgroundColor(mContext.getResources().getColor(R.color.colorCancelado));
//            }else {
//                holder.listTab.setBackgroundColor(mContext.getResources().getColor(R.color.colorLimpio));
//            }
//
//
//
////
//////        if (listaMaterias==null) {
//////            Materia materia = mMaterias[position];
//////            holder.textoView.setText(materia.getNombre());
//////            if (materia.getEstado()==0){
//////                holder.estadoView.setBackgroundColor(android.R.color.holo_green_light);
//////            }
//////        }else{
//////            Materia materia = listaMaterias.get(position);
//////            holder.textoView.setText(materia.getNombre());
//////            if (materia.getEstado()==0){
//////                holder.estadoView.setBackgroundColor(android.R.color.holo_green_light);
//////            }
//////        }
////
////
//        return row;
//
//    }

    static class ViewHolder {
        //almacena el index de la columna
        int colImp;

        int colInd;
        //store the view
        View listTab;
        //ImageButtons
        ImageButton cancelado;
        ImageButton aprobado;

        TextView materia;
    }
}