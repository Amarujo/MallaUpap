package com.gametest.www.mallaupap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by admin on 2/1/2017.
 */

public class AvisoDbAdapter {

    //estos son los nombres de las columnas
    public static final String COL_ID = "_id";
    public static final String COL_MATERIA = "materia";
    public static final String COL_ESTADO = "estado";

    //estos son los índices correspoindientes
    public static final int INDEX_ID = 0;
    public static final int INDEX_CONTENT = INDEX_ID + 1;
    public static final int INDEX_IMPORTANT = INDEX_ID + 2;

    //usado for logging
    private static final String TAG = "AvisosDbAdapter";

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "dba_materias";
    private static final String TABLE_NAME = "tbl_materias";
    private static final int DATABASE_VERSION = 1;

    private final Context mCtx;

    //declaración SQL usada para crear la base de datos
    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + TABLE_NAME + " ( " +
                    COL_ID + " INTEGER PRIMARY KEY autoincrement, " +
                    COL_MATERIA + " TEXT, " +
                    COL_ESTADO + " INTEGER );";


    public AvisoDbAdapter(Context context, boolean b) {

        this.mCtx = context;

        open();
    }

    public AvisoDbAdapter(Context context){
        
        this.mCtx = context;

        open();

        Toast.makeText(context, "Nueva carga",Toast.LENGTH_SHORT).show();

        createReminder("ALGEBRA I (MATEMATICA I)", 0);
        createReminder("ALGEBRA LINEAL I (MATEMATICA IV)", 0);
        createReminder("ALGORITMIA AVANZADA I", 0);
        createReminder("ALGORITMIA AVANZADA II", 0);
        createReminder("ALGORITMIA BASICA I", 0);
        createReminder("ALGORITMIA BASICA II", 0);
        createReminder("COMUNICACION ORAL Y ESCRITA CASTELLANA (COMUNICACION ORAL Y ESCRITA II)", 0);
        createReminder("EXPRESION CASTELLANA (COMUNICACION ORAL Y ESCRITA I)", 0);
        createReminder("FISICA I", 0);
        createReminder("FISICA II", 0);
        createReminder("GEOMETRIA I (MATEMATICA III)", 0);
        createReminder("INFORMATICA BASICA I", 0);
        createReminder("INFORMATICA BASICA II", 0);
        createReminder("INGLES I", 0);
        createReminder("INGLES II", 0);
        createReminder("INTRODUCCION A LA FISICA I", 0);
        createReminder("INTRODUCCION A LA FISICA II", 0);
        createReminder("INTRODUCCION A LA INGENIERIA", 0);
        createReminder("INTRODUCCION A LA TECNOLOGIA", 0);
        createReminder("METODOLOGIA DE LA INVESTIGACION", 0);
        createReminder("METODOLOGIA DEL APRENDIZAJE", 0);
        createReminder("TRIGONOMETRIA I (MATEMATICA II)", 0);
        createReminder("ALGEBRA LINEAL II(MATEMATICA VI)", 0);
        createReminder("CALCULO I", 0);
        createReminder("CALCULO II", 0);
        createReminder("CALCULO III", 0);
        createReminder("CALCULO IV", 0);
        createReminder("ECUACION I", 0);
        createReminder("ECUACION II", 0);
        createReminder("ESTRUCTURA DE DATOS I", 0);
        createReminder("ESTRUCTURA DE DATOS II", 0);
        createReminder("FISICA III", 0);
        createReminder("FISICA IV", 0);
        createReminder("GEOMETRIA ANALITICA I (MATEMATICA VII)", 0);
        createReminder("GEOMETRIA ANALITICA II (MATEMATICA VIII)", 0);
        createReminder("GEOMETRIA II (MATEMATICA V)", 0);
        createReminder("LENGUAJES DE PROGRAMACION I - SL", 0);
        createReminder("LENGUAJES DE PROGRAMACION II - SL", 0);
        createReminder("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS I", 0);
        createReminder("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS II", 0);
        createReminder("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS I", 0);
        createReminder("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS II", 0);
        createReminder("PROGRAMACION ORIENTADA A OBJETOS I", 0);
        createReminder("ANALISIS DE SISTEMAS I", 0);
        createReminder("ANALISIS DE SISTEMAS II", 0);
        createReminder("BASES DE DATOS I", 0);
        createReminder("BASES DE DATOS II", 0);
        createReminder("CALCULO AVANZADO I", 0);
        createReminder("CALCULO AVANZADO II", 0);
        createReminder("ELECTRONICA I", 0);
        createReminder("ELECTRONICA II", 0);
        createReminder("INSTALACIONES ELECTRICAS I", 0);
        createReminder("INSTALACIONES ELECTRICAS II", 0);
        createReminder("LENGUAJES DE PROGRAMACION III - SL", 0);
        createReminder("LENGUAJES DE PROGRAMACION IV - SL", 0);
        createReminder("LENGUAJES DE PROGRAMACION V - (DATAWAREHOUSEING)", 0);
        createReminder("LENGUAJES DE PROGRAMACION VI - (DATAWAREHOUSEING)", 0);
        createReminder("PROBABILIDAD Y ESTADISTICAS I", 0);
        createReminder("PROBABILIDAD Y ESTADISTICAS II", 0);
        createReminder("PROGRAMACION ORIENTADA A OBJETOS II", 0);
        createReminder("SISTEMAS OPERATIVOS I", 0);
        createReminder("SISTEMAS OPERATIVOS II", 0);
        createReminder("ANALISIS DE SISTEMAS III", 0);
        createReminder("ANALISIS DE SISTEMAS IV", 0);
        createReminder("ANALISIS ESTRUCTURADO MODERNO I", 0);
        createReminder("ANALISIS ESTRUCTURADO MODERNO II", 0);
        createReminder("BASE DE DATOS III", 0);
        createReminder("BASE DE DATOS IV (SQL)", 0);
        createReminder("BASE DE DATOS V (SQL)", 0);
        createReminder("BASE DE DATOS VI (SQL)", 0);
        createReminder("DESARROLLO DE SISTEMAS I", 0);
        createReminder("DESARROLLO DE SISTEMAS II", 0);
        createReminder("DESARROLLO DE SISTEMAS III", 0);
        createReminder("GESTION DE CALIDAD I", 0);
        createReminder("INGENIERIA DE SOFTWARE I", 0);
        createReminder("INGENIERIA DE SOFTWARE II", 0);
        createReminder("INGENIERIA DE SOFTWARE III", 0);
        createReminder("INGLES III", 0);
        createReminder("INGLES IV", 0);
        createReminder("INVESTIGACION OPERATIVA I", 0);
        createReminder("INVESTIGACION OPERATIVA II", 0);
        createReminder("LENGUAJES DE PROGRAMACION VII - (DATAWAREHOUSEING)", 0);
        createReminder("LENGUAJES DE PROGRAMACION VIII - (DATAWAREHOUSEING)", 0);
        createReminder("METROLOGIA DIMENSIONAL I", 0);
        createReminder("PROYECTO INFORMATICA I", 0);
        createReminder("PROYECTO INFORMATICA II", 0);
        createReminder("REDES DE COMPUTADORAS I", 0);
        createReminder("REDES DE COMPUTADORAS II", 0);
        createReminder("ADMINISTRACION, CONTABILIDAD Y PRESUPUESTO", 0);
        createReminder("AUDITORIA INFORMATICA I", 0);
        createReminder("AUDITORIA INFORMATICA II", 0);
        createReminder("CIENCIAS DEL AMBIENTE I", 0);
        createReminder("COMPILADORES I", 0);
        createReminder("COMPILADORES II", 0);
        createReminder("CONSERVACION DE ENERGIA", 0);
        createReminder("COSTOS INDUSTRIALES", 0);
        createReminder("ECONOMIA (ESTADISTICA Y CENSOS)", 0);
        createReminder("ESTADISTICA APLICADA", 0);
        createReminder("INGENIERIA ECONOMICA", 0);
        createReminder("INSTRUMENTOS Y SISTEMAS DE MEDIDAS I", 0);
        createReminder("INTELIGENCIA ARTIFICIAL I", 0);
        createReminder("INTELIGENCIA ARTIFICIAL II", 0);
        createReminder("PROYECTO FINAL I", 0);
        createReminder("PROYECTO FINAL II", 0);
        createReminder("SEGURIDAD INFORMATICA I", 0);
        createReminder("SEGURIDAD INFORMATICA II", 0);
        createReminder("SISTEMAS DE CONTROL I", 0);
        createReminder("SOCIOLOGIA GENERAL I", 0);
        createReminder("TECNOLOGIA INFORMATICA I", 0);
        createReminder("TECNOLOGIA INFORMATICA II", 0);
        createReminder("TESIS FINAL", 0);
        createReminder("TUTORIA DE TESIS I", 0);
        createReminder("TUTORIA DE TESIS II", 0);
        createReminder("TUTORIA DE TESIS III", 0);
        createReminder("TUTORIA DE TESIS IV", 0);
        createReminder(" TUTORIA DE TESIS V", 0);
    }

    public void open() throws SQLException{
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
    }

    public void close(){
        if (mDbHelper != null){
            mDbHelper.close();
        }
    }


    //CREATE
//ten en cuenta que la id será creada automáticamente
    public void createReminder(String name, int estado) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, name);
        values.put(COL_ESTADO, estado);
        mDb.insert(TABLE_NAME, null, values);
    }

    //sobrecargado para tomar un aviso
    public long createReminder(Aviso reminder) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, reminder.getMateria()); // Nombre Contacto
        values.put(COL_ESTADO, reminder.getEstado()); // Número teléfono Contacto

        // Insertar fila
        return mDb.insert(TABLE_NAME, null, values);
    }

    //READ
    public Aviso fetchReminderById(int id) {
        Cursor cursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO}, COL_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        return new Aviso(
                cursor.getInt(INDEX_ID),
                cursor.getString(INDEX_CONTENT),
                cursor.getInt(INDEX_IMPORTANT)
        );
    }

    public Cursor fetchAllReminders() {
        Cursor mCursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO},
                null, null, null, null, null
        );

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchFaltantes() {
        Cursor mCursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO},
                COL_ESTADO+" IN(?,?)",new String[]{"0","2"}, null, null, null
        );

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchAprobadas() {
        Cursor mCursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO},
                COL_ESTADO+" =?",new String[]{"1"}, null, null, null
        );

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchCanceladas() {
        Cursor mCursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO},
                COL_ESTADO+" =?",new String[]{"2"}, null, null, null
        );

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //UPDATE
    public void updateReminder(Aviso reminder) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, reminder.getMateria());
        values.put(COL_ESTADO, reminder.getEstado());
        mDb.update(TABLE_NAME, values,
                COL_ID + "=?", new String[]{String.valueOf(reminder.getId())});
    }

    public void updateReminder(int id) {
        ContentValues values = new ContentValues();

        values.put(COL_ESTADO, id);
        mDb.update(TABLE_NAME, values,
                COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void deleteReminderById(int nId) {
        mDb.delete(TABLE_NAME, COL_ID + "=?", new String[]{String.valueOf(nId)});
    }

    public void updateEstado(int nId, int estado){
        ContentValues values = new ContentValues();

        values.put(COL_ESTADO, estado);
        mDb.update(TABLE_NAME, values,
                COL_ID + "=?", new String[]{String.valueOf(nId)});
    }

    public int getEstado(int nId){

        Cursor res = mDb.rawQuery("select estado from " + TABLE_NAME+" where _id= "+nId, null);
//        res.moveToNext();
        res.moveToFirst();
        int estado = res.getInt(0);
        return estado;
    }

    public int getId(String materia){

//        mMateria = materia;
//        new GetIdTask().execute();
        Cursor res = mDb.rawQuery("select _id from " + TABLE_NAME+" where materia= '"+materia+"'", null);
//        res.moveToNext();
        res.moveToFirst();

        int estado = res.getInt(0);

        return estado;
    }
//    Cursor res = null;
//    String mMateria;
//    int estado;
//
//
//    private class GetIdTask extends AsyncTask<Void,Void,Void>{
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            res = mDb.rawQuery("select _id from " + TABLE_NAME+" where materia= '"+mMateria+"'", null);
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            res.moveToFirst();
//            estado = res.getInt(0);
//        }
//    }



//##################################################################################################
//##################################################################################################

    private static class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version: "+oldVersion+" to "+newVersion);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(db);
        }
    }

}
