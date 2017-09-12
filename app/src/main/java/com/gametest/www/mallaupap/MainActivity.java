package com.gametest.www.mallaupap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static ListView mListView;
    public static MateriaDbAdapter mDbAdapter;
    public static MateriaSimpleCursorAdapter mCursorAdapter;
    private Cursor cursor;

    ImageButton cancelar;
    TextView materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Todas las materias");


        cancelar = (ImageButton)findViewById(R.id.btn_cancelado) ;
        materia = (TextView) findViewById(R.id.row_text);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mListView = (ListView)findViewById(R.id.lista_materias_main);
//        mListView.setDivider(null);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if (!prefs.getBoolean("FIRSTRUN", false)) {
            mDbAdapter = new MateriaDbAdapter(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("FIRSTRUN", true);

            editor.commit();
        }else mDbAdapter = new MateriaDbAdapter(this, true);
//        mDbAdapter.open();//FOV

        if (savedInstanceState==null){
            //limpiar todos los datos
//            mDbAdapter.deleteAllReminders();
            //add algunos datos
//            mDbAdapter.createReminder("ALGEBRA I (MATEMATICA I)", 0);
//            mDbAdapter.createReminder("ALGEBRA LINEAL I (MATEMATICA IV)", 0);
//            mDbAdapter.createReminder("ALGORITMIA AVANZADA I", 0);
//            mDbAdapter.createReminder("ALGORITMIA AVANZADA II", 0);
//            mDbAdapter.createReminder("ALGORITMIA BASICA I", 0);
//            mDbAdapter.createReminder("ALGORITMIA BASICA II", 0);
//            mDbAdapter.createReminder("COMUNICACION ORAL Y ESCRITA CASTELLANA (COMUNICACION ORAL Y ESCRITA II)", 0);
//            mDbAdapter.createReminder("EXPRESION CASTELLANA (COMUNICACION ORAL Y ESCRITA I)", 0);
//            mDbAdapter.createReminder("FISICA I", 0);
//            mDbAdapter.createReminder("FISICA II", 0);
//            mDbAdapter.createReminder("GEOMETRIA I (MATEMATICA III)", 0);
//            mDbAdapter.createReminder("INFORMATICA BASICA I", 0);
//            mDbAdapter.createReminder("INFORMATICA BASICA II", 0);
//            mDbAdapter.createReminder("INGLES I", 0);
//            mDbAdapter.createReminder("INGLES II", 0);
//            mDbAdapter.createReminder("INTRODUCCION A LA FISICA I", 0);
//            mDbAdapter.createReminder("INTRODUCCION A LA FISICA II", 0);
//            mDbAdapter.createReminder("INTRODUCCION A LA INGENIERIA", 0);
//            mDbAdapter.createReminder("INTRODUCCION A LA TECNOLOGIA", 0);
//            mDbAdapter.createReminder("METODOLOGIA DE LA INVESTIGACION", 0);
//            mDbAdapter.createReminder("METODOLOGIA DEL APRENDIZAJE", 0);
//            mDbAdapter.createReminder("TRIGONOMETRIA I (MATEMATICA II)", 0);
//            mDbAdapter.createReminder("ALGEBRA LINEAL II(MATEMATICA VI)", 0);
//            mDbAdapter.createReminder("CALCULO I", 0);
//            mDbAdapter.createReminder("CALCULO II", 0);
//            mDbAdapter.createReminder("CALCULO III", 0);
//            mDbAdapter.createReminder("CALCULO IV", 0);
//            mDbAdapter.createReminder("ECUACION I", 0);
//            mDbAdapter.createReminder("ECUACION II", 0);
//            mDbAdapter.createReminder("ESTRUCTURA DE DATOS I", 0);
//            mDbAdapter.createReminder("ESTRUCTURA DE DATOS II", 0);
//            mDbAdapter.createReminder("FISICA III", 0);
//            mDbAdapter.createReminder("FISICA IV", 0);
//            mDbAdapter.createReminder("GEOMETRIA ANALITICA I (MATEMATICA VII)", 0);
//            mDbAdapter.createReminder("GEOMETRIA ANALITICA II (MATEMATICA VIII)", 0);
//            mDbAdapter.createReminder("GEOMETRIA II (MATEMATICA V)", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION I - SL", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION II - SL", 0);
//            mDbAdapter.createReminder("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS I", 0);
//            mDbAdapter.createReminder("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS II", 0);
//            mDbAdapter.createReminder("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS I", 0);
//            mDbAdapter.createReminder("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS II", 0);
//            mDbAdapter.createReminder("PROGRAMACION ORIENTADA A OBJETOS I", 0);
//            mDbAdapter.createReminder("ANALISIS DE SISTEMAS I", 0);
//            mDbAdapter.createReminder("ANALISIS DE SISTEMAS II", 0);
//            mDbAdapter.createReminder("BASES DE DATOS I", 0);
//            mDbAdapter.createReminder("BASES DE DATOS II", 0);
//            mDbAdapter.createReminder("CALCULO AVANZADO I", 0);
//            mDbAdapter.createReminder("CALCULO AVANZADO II", 0);
//            mDbAdapter.createReminder("ELECTRONICA I", 0);
//            mDbAdapter.createReminder("ELECTRONICA II", 0);
//            mDbAdapter.createReminder("INSTALACIONES ELECTRICAS I", 0);
//            mDbAdapter.createReminder("INSTALACIONES ELECTRICAS II", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION III - SL", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION IV - SL", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION V - (DATAWAREHOUSEING)", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION VI - (DATAWAREHOUSEING)", 0);
//            mDbAdapter.createReminder("PROBABILIDAD Y ESTADISTICAS I", 0);
//            mDbAdapter.createReminder("PROBABILIDAD Y ESTADISTICAS II", 0);
//            mDbAdapter.createReminder("PROGRAMACION ORIENTADA A OBJETOS II", 0);
//            mDbAdapter.createReminder("SISTEMAS OPERATIVOS I", 0);
//            mDbAdapter.createReminder("SISTEMAS OPERATIVOS II", 0);
//            mDbAdapter.createReminder("ANALISIS DE SISTEMAS III", 0);
//            mDbAdapter.createReminder("ANALISIS DE SISTEMAS IV", 0);
//            mDbAdapter.createReminder("ANALISIS ESTRUCTURADO MODERNO I", 0);
//            mDbAdapter.createReminder("ANALISIS ESTRUCTURADO MODERNO II", 0);
//            mDbAdapter.createReminder("BASE DE DATOS III", 0);
//            mDbAdapter.createReminder("BASE DE DATOS IV (SQL)", 0);
//            mDbAdapter.createReminder("BASE DE DATOS V (SQL)", 0);
//            mDbAdapter.createReminder("BASE DE DATOS VI (SQL)", 0);
//            mDbAdapter.createReminder("DESARROLLO DE SISTEMAS I", 0);
//            mDbAdapter.createReminder("DESARROLLO DE SISTEMAS II", 0);
//            mDbAdapter.createReminder("DESARROLLO DE SISTEMAS III", 0);
//            mDbAdapter.createReminder("GESTION DE CALIDAD I", 0);
//            mDbAdapter.createReminder("INGENIERIA DE SOFTWARE I", 0);
//            mDbAdapter.createReminder("INGENIERIA DE SOFTWARE II", 0);
//            mDbAdapter.createReminder("INGENIERIA DE SOFTWARE III", 0);
//            mDbAdapter.createReminder("INGLES III", 0);
//            mDbAdapter.createReminder("INGLES IV", 0);
//            mDbAdapter.createReminder("INVESTIGACION OPERATIVA I", 0);
//            mDbAdapter.createReminder("INVESTIGACION OPERATIVA II", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION VII - (DATAWAREHOUSEING)", 0);
//            mDbAdapter.createReminder("LENGUAJES DE PROGRAMACION VIII - (DATAWAREHOUSEING)", 0);
//            mDbAdapter.createReminder("METROLOGIA DIMENSIONAL I", 0);
//            mDbAdapter.createReminder("PROYECTO INFORMATICA I", 0);
//            mDbAdapter.createReminder("PROYECTO INFORMATICA II", 0);
//            mDbAdapter.createReminder("REDES DE COMPUTADORAS I", 0);
//            mDbAdapter.createReminder("REDES DE COMPUTADORAS II", 0);
//            mDbAdapter.createReminder("ADMINISTRACION, CONTABILIDAD Y PRESUPUESTO", 0);
//            mDbAdapter.createReminder("AUDITORIA INFORMATICA I", 0);
//            mDbAdapter.createReminder("AUDITORIA INFORMATICA II", 0);
//            mDbAdapter.createReminder("CIENCIAS DEL AMBIENTE I", 0);
//            mDbAdapter.createReminder("COMPILADORES I", 0);
//            mDbAdapter.createReminder("COMPILADORES II", 0);
//            mDbAdapter.createReminder("CONSERVACION DE ENERGIA", 0);
//            mDbAdapter.createReminder("COSTOS INDUSTRIALES", 0);
//            mDbAdapter.createReminder("ECONOMIA (ESTADISTICA Y CENSOS)", 0);
//            mDbAdapter.createReminder("ESTADISTICA APLICADA", 0);
//            mDbAdapter.createReminder("INGENIERIA ECONOMICA", 0);
//            mDbAdapter.createReminder("INSTRUMENTOS Y SISTEMAS DE MEDIDAS I", 0);
//            mDbAdapter.createReminder("INTELIGENCIA ARTIFICIAL I", 0);
//            mDbAdapter.createReminder("INTELIGENCIA ARTIFICIAL II", 0);
//            mDbAdapter.createReminder("PROYECTO FINAL I", 0);
//            mDbAdapter.createReminder("PROYECTO FINAL II", 0);
//            mDbAdapter.createReminder("SEGURIDAD INFORMATICA I", 0);
//            mDbAdapter.createReminder("SEGURIDAD INFORMATICA II", 0);
//            mDbAdapter.createReminder("SISTEMAS DE CONTROL I", 0);
//            mDbAdapter.createReminder("SOCIOLOGIA GENERAL I", 0);
//            mDbAdapter.createReminder("TECNOLOGIA INFORMATICA I", 0);
//            mDbAdapter.createReminder("TECNOLOGIA INFORMATICA II", 0);
//            mDbAdapter.createReminder("TESIS FINAL", 0);
//            mDbAdapter.createReminder("TUTORIA DE TESIS I", 0);
//            mDbAdapter.createReminder("TUTORIA DE TESIS II", 0);
//            mDbAdapter.createReminder("TUTORIA DE TESIS III", 0);
//            mDbAdapter.createReminder("TUTORIA DE TESIS IV", 0);
//            mDbAdapter.createReminder(" TUTORIA DE TESIS V", 0);


        }

        new MainTask().execute();

        /*****************************************************************
         * MOVIDO A SEGUNDO PLANO
         */
//        cursor = mDbAdapter.fetchAllReminders();
//
//        //desde las columnas definidas en la base de datos
//        String[] from = new String[]{
//                AvisoDbAdapter.COL_MATERIA
//        };
//
//        //a la id de views en el layout
//        int[] to = new int[]{
//                R.id.row_text
//        };
//
//        mCursorAdapter = new AvisosSimpleCursorAdapter(
//                //context
//                MainActivity.this,
//                //el layout de la fila
//                R.layout.layout_materia,
//                //cursor
//                cursor,
//                //desde columnas definidas en la base de datos
//                from,
//                //a las ids de views en el layout
//                to,
//                //flag - no usado
//                0,
//                mDbAdapter);

//        mListView.setAdapter(mCursorAdapter);//MOVIDO A SEGUNDO PLANO

        // to avoid: Cursor window allocation of 2048 kb failed. # Open Cursors=964 (# cursors opened by this proc=964)

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Button boton = (Button)view;
//                Toast.makeText(getApplicationContext(), "Id "+boton.getId(), Toast.LENGTH_SHORT).show();
//            }
//        });


//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView<?> parent, View view, final int masterListPosition, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                ListView modeListView = new ListView(MainActivity.this);
//                String[] modes = new String[]{"Editar Aviso", "Borrar Aviso"};
//                ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(MainActivity.this,
//                        android.R.layout.simple_list_item_1, android.R.id.text1, modes);
//                modeListView.setAdapter(modeAdapter);
//                builder.setView(modeListView);
//                final Dialog dialog = builder.create();
//                dialog.show();
//                modeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        //editar aviso
//                        if (position == 0) {
//                            int nId = getIdFromPosition(masterListPosition);
//                            Aviso aviso = mDbAdapter.fetchReminderById(nId);
////                            fireCustomDialog(aviso);
//
////                            Toast.makeText(MainActivity.this, "Editar Aviso " + masterListPosition, Toast.LENGTH_SHORT).show();
//
//                            //borrar aviso
//                        } else {
//                            mDbAdapter.deleteReminderById(getIdFromPosition(masterListPosition));
//                            mCursorAdapter.changeCursor(mDbAdapter.fetchAllReminders());
//
////                            Toast.makeText(MainActivity.this, "Borrar Aviso " + masterListPosition, Toast.LENGTH_SHORT).show();
//                        }
//                        dialog.dismiss();
//                    }
//                });
//            }
//        });



//        cancel();


    }

    private int getIdFromPosition(int nC) {
        return (int)mCursorAdapter.getItemId(nC);
    }


    /****************************************************************************
     * SEGUNDO PLANO
     */

    public static void refreshListView(Context context, int pos){
//        Cursor cursor = mDbAdapter.fetchAllReminders();
//
//        //desde las columnas definidas en la base de datos
//        String[] from = new String[]{
//                AvisoDbAdapter.COL_MATERIA
//        };
//
//        //a la id de views en el layout
//        int[] to = new int[]{
//                R.id.row_text
//        };
//
//        mCursorAdapter = new AvisosSimpleCursorAdapter(
//                //context
//                context,
//                //el layout de la fila
//                R.layout.layout_materia,
//                //cursor
//                cursor,
//                //desde columnas definidas en la base de datos
//                from,
//                //a las ids de views en el layout
//                to,
//                //flag - no usado
//                0,
//                mDbAdapter);
//        mListView.setAdapter(mCursorAdapter);
//        mListView.setSelection(pos);//set the ListView scrolling position. You get it from getFirstVisiblePosition()
        mCursorAdapter.changeCursor(mDbAdapter.fetchAllMaterias());

//        mCursorAdapter.notifyDataSetChanged();
//        mListView.invalidateViews();
    }

    private class MainTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            cursor = mDbAdapter.fetchAllMaterias();

            //desde las columnas definidas en la base de datos
            String[] from = new String[]{
                    MateriaDbAdapter.COL_MATERIA
            };

            //a la id de views en el layout
            int[] to = new int[]{
                    R.id.row_text
            };

            mCursorAdapter = new MateriaSimpleCursorAdapter(
                    //context
                    MainActivity.this,
                    //el layout de la fila
                    R.layout.layout_materia,
                    //cursor
                    cursor,
                    //desde columnas definidas en la base de datos
                    from,
                    //a las ids de views en el layout
                    to,
                    //flag - no usado
                    0,
                    mDbAdapter);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mListView.setAdapter(mCursorAdapter);
        }
    }





//    private void fireCustomDialog(final Aviso aviso) {
//        // custom dialog
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_custom);
//
//        TextView titleView = (TextView) dialog.findViewById(R.id.custom_title);
//        final EditText editCustom = (EditText) dialog.findViewById(R.id.custom_edit_reminder);
//        Button commitButton = (Button) dialog.findViewById(R.id.custom_button_commit);
//        final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.custom_check_box);
//        LinearLayout rootLayout = (LinearLayout) dialog.findViewById(R.id.custom_root_layout);
//        final boolean isEditOperation = (aviso != null);
//
//        //esto es para un edit
//        if (isEditOperation) {
//            titleView.setText("Editar Aviso");
//            checkBox.setChecked(aviso.getEstado() == 1);
//            editCustom.setText(aviso.getMateria());
//            rootLayout.setBackgroundColor(getResources().getColor(R.color.azul_neutro));
//        }
//
//        commitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String reminderText = editCustom.getText().toString();
//                if (isEditOperation) {
//                    Aviso reminderEdited = new Aviso(aviso.getId(),
//                            reminderText, checkBox.isChecked() ? 1 : 0);
//                    mDbAdapter.updateReminder(reminderEdited);
//                    //esto es para nuevo aviso
//                } else {
//                    mDbAdapter.createReminder(reminderText, checkBox.isChecked());
//                }
//                mCursorAdapter.changeCursor(mDbAdapter.fetchAllReminders());
//                dialog.dismiss();
//            }
//        });
//
//        Button buttonCancel = (Button) dialog.findViewById(R.id.custom_button_cancel);
//        buttonCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }


//    public void cancel(){
//        mListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        int p = parent.getPositionForView(view);
//                        TextView t = (TextView)findViewById(R.id.row_text);
//                        Toast.makeText(getApplicationContext(),t.getText()+" "+p,Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//    }


//    public void cancel(){
//        cancelar.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        AvisosSimpleCursorAdapter.ViewHolder holder = (AvisosSimpleCursorAdapter.ViewHolder) v.getTag();
//                        if (holder == null) {
//                            holder = new AvisosSimpleCursorAdapter.ViewHolder();
////                            holder.colImp = cursor.getColumnIndexOrThrow(AvisoDbAdapter.COL_ESTADO);
//                            holder.listTab =  v.findViewById(R.id.row_tab);
//                            v.setTag(holder);
//                        }
//
//                        View tab = findViewById(R.id.row_tab);
//                        tab.setBackgroundColor(getResources().getColor(R.color.colorCancelado));
//                    }
//                }
//        );
//    }

//    public void cancel(View view){
//        mDbAdapter.updateReminder(view.getId());
//        Toast.makeText(getApplicationContext(),"Cancelar",Toast.LENGTH_SHORT).show();
//
//    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    Fragment fragment;
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_todas) {
//            Toast.makeText(getApplicationContext(), "Todas las materias", Toast.LENGTH_SHORT).show();

            if (fragment!=null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
            setTitle("Todas las materias");
        } else if (id == R.id.nav_faltan) {
//            intent = new Intent(this, FaltantesActivitie.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            fragment = new FaltantesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            setTitle("Materias que me faltan");
        } else if (id == R.id.nav_aprobadas) {
//            intent = new Intent(this, AprobadasActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            fragment = new AprobadasFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
//            item.setChecked(true);
            setTitle("Materias aprobadas");

        }else if (id == R.id.nav_canceladas) {
//            intent = new Intent(this, CanceladasActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            fragment = new CanceladasFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            setTitle("Materias canceladas");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    class AvisosSimpleCursorAdapter extends SimpleCursorAdapter {
//        int layout;
//        public AvisosSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
//            super(context, layout, c, from, to, flags);
//            this.layout = layout;
//        }
//
////        @Override
////        public View getView(final int position, View convertView, ViewGroup parent) {
////            ViewHolder mainViewholder = null;
////            if(convertView == null) {
////                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
////                convertView = inflater.inflate(layout, parent, false);
////                ViewHolder viewHolder = new ViewHolder();
//////                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
//////                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
//////                viewHolder.button = (Button) convertView.findViewById(R.id.list_item_btn);
////
////                viewHolder.btn_cancel= (ImageButton)convertView.findViewById(R.id.btn_cancelado);
////                viewHolder.btn_aprobado= (ImageButton)convertView.findViewById(R.id.btn_aprobado);
////                viewHolder.btn_cancel.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        Toast.makeText(getApplicationContext(),"Element : "+position, Toast.LENGTH_SHORT).show();
////                    }
////                });
////                convertView.setTag(viewHolder);
////            }
////            mainViewholder = (ViewHolder) convertView.getTag();
////
////            return convertView;
////        }
//
//        //para usar un viewholder, debemos sobrescribir los dos métodos siguientes y definir una clase ViewHolder
//        @Override
//        public View newView(Context context, Cursor cursor, ViewGroup parent) {
//            return super.newView(context, cursor, parent);
//        }
//
//        @Override
//        public void bindView(View view, Context context, Cursor cursor) {
//            super.bindView(view, context, cursor);
//
//            com.gametest.www.mallaupap.AvisosSimpleCursorAdapter.ViewHolder holder = (com.gametest.www.mallaupap.AvisosSimpleCursorAdapter.ViewHolder) view.getTag();
//            if (holder == null) {
//                holder = new com.gametest.www.mallaupap.AvisosSimpleCursorAdapter.ViewHolder();
//                holder.colImp = cursor.getColumnIndexOrThrow(AvisoDbAdapter.COL_ESTADO);
//                holder.listTab =  view.findViewById(R.id.row_tab);
//                view.setTag(holder);
//            }
//
//            if (cursor.getInt(holder.colImp) == 1) {
//                holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorAprobado));
//            } else if(cursor.getInt(holder.colImp) == 2){
//                holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorCancelado));
//            }else {
//                holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.colorLimpio));
//            }
//        }
//
//        class ViewHolder {
//            //almacena el index de la columna
//            int colImp;
//            //store the view
//            View listTab;
//
//            ImageButton btn_cancel;
//            ImageButton btn_aprobado;
//
//        }
//    }
}


