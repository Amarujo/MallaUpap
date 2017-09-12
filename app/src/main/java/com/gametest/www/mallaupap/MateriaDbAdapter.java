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

public class MateriaDbAdapter {

    //estos son los nombres de las columnas
    public static final String COL_ID = "_id";
    public static final String COL_MATERIA = "materia";
    public static final String COL_ESTADO = "estado";

    //estos son los índices correspoindientes
    public static final int INDEX_ID = 0;
    public static final int INDEX_CONTENT = INDEX_ID + 1;
    public static final int INDEX_IMPORTANT = INDEX_ID + 2;

    //usado for logging
    private static final String TAG = "MateriasDbAdapter";

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


    public MateriaDbAdapter(Context context, boolean b) {

        this.mCtx = context;

        open();
    }

    public MateriaDbAdapter(Context context){
        
        this.mCtx = context;

        open();

        Toast.makeText(context, "Nueva carga",Toast.LENGTH_SHORT).show();

        createMateria("ALGEBRA I (MATEMATICA I)", 0);
        createMateria("ALGEBRA LINEAL I (MATEMATICA IV)", 0);
        createMateria("ALGORITMIA AVANZADA I", 0);
        createMateria("ALGORITMIA AVANZADA II", 0);
        createMateria("ALGORITMIA BASICA I", 0);
        createMateria("ALGORITMIA BASICA II", 0);
        createMateria("COMUNICACION ORAL Y ESCRITA CASTELLANA (COMUNICACION ORAL Y ESCRITA II)", 0);
        createMateria("EXPRESION CASTELLANA (COMUNICACION ORAL Y ESCRITA I)", 0);
        createMateria("FISICA I", 0);
        createMateria("FISICA II", 0);
        createMateria("GEOMETRIA I (MATEMATICA III)", 0);
        createMateria("INFORMATICA BASICA I", 0);
        createMateria("INFORMATICA BASICA II", 0);
        createMateria("INGLES I", 0);
        createMateria("INGLES II", 0);
        createMateria("INTRODUCCION A LA FISICA I", 0);
        createMateria("INTRODUCCION A LA FISICA II", 0);
        createMateria("INTRODUCCION A LA INGENIERIA", 0);
        createMateria("INTRODUCCION A LA TECNOLOGIA", 0);
        createMateria("METODOLOGIA DE LA INVESTIGACION", 0);
        createMateria("METODOLOGIA DEL APRENDIZAJE", 0);
        createMateria("TRIGONOMETRIA I (MATEMATICA II)", 0);
        createMateria("ALGEBRA LINEAL II(MATEMATICA VI)", 0);
        createMateria("CALCULO I", 0);
        createMateria("CALCULO II", 0);
        createMateria("CALCULO III", 0);
        createMateria("CALCULO IV", 0);
        createMateria("ECUACION I", 0);
        createMateria("ECUACION II", 0);
        createMateria("ESTRUCTURA DE DATOS I", 0);
        createMateria("ESTRUCTURA DE DATOS II", 0);
        createMateria("FISICA III", 0);
        createMateria("FISICA IV", 0);
        createMateria("GEOMETRIA ANALITICA I (MATEMATICA VII)", 0);
        createMateria("GEOMETRIA ANALITICA II (MATEMATICA VIII)", 0);
        createMateria("GEOMETRIA II (MATEMATICA V)", 0);
        createMateria("LENGUAJES DE PROGRAMACION I - SL", 0);
        createMateria("LENGUAJES DE PROGRAMACION II - SL", 0);
        createMateria("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS I", 0);
        createMateria("ORGANIZACION DE ARCHIVOS Y BASES DE DATOS II", 0);
        createMateria("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS I", 0);
        createMateria("ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS II", 0);
        createMateria("PROGRAMACION ORIENTADA A OBJETOS I", 0);
        createMateria("ANALISIS DE SISTEMAS I", 0);
        createMateria("ANALISIS DE SISTEMAS II", 0);
        createMateria("BASES DE DATOS I", 0);
        createMateria("BASES DE DATOS II", 0);
        createMateria("CALCULO AVANZADO I", 0);
        createMateria("CALCULO AVANZADO II", 0);
        createMateria("ELECTRONICA I", 0);
        createMateria("ELECTRONICA II", 0);
        createMateria("INSTALACIONES ELECTRICAS I", 0);
        createMateria("INSTALACIONES ELECTRICAS II", 0);
        createMateria("LENGUAJES DE PROGRAMACION III - SL", 0);
        createMateria("LENGUAJES DE PROGRAMACION IV - SL", 0);
        createMateria("LENGUAJES DE PROGRAMACION V - (DATAWAREHOUSEING)", 0);
        createMateria("LENGUAJES DE PROGRAMACION VI - (DATAWAREHOUSEING)", 0);
        createMateria("PROBABILIDAD Y ESTADISTICAS I", 0);
        createMateria("PROBABILIDAD Y ESTADISTICAS II", 0);
        createMateria("PROGRAMACION ORIENTADA A OBJETOS II", 0);
        createMateria("SISTEMAS OPERATIVOS I", 0);
        createMateria("SISTEMAS OPERATIVOS II", 0);
        createMateria("ANALISIS DE SISTEMAS III", 0);
        createMateria("ANALISIS DE SISTEMAS IV", 0);
        createMateria("ANALISIS ESTRUCTURADO MODERNO I", 0);
        createMateria("ANALISIS ESTRUCTURADO MODERNO II", 0);
        createMateria("BASE DE DATOS III", 0);
        createMateria("BASE DE DATOS IV (SQL)", 0);
        createMateria("BASE DE DATOS V (SQL)", 0);
        createMateria("BASE DE DATOS VI (SQL)", 0);
        createMateria("DESARROLLO DE SISTEMAS I", 0);
        createMateria("DESARROLLO DE SISTEMAS II", 0);
        createMateria("DESARROLLO DE SISTEMAS III", 0);
        createMateria("GESTION DE CALIDAD I", 0);
        createMateria("INGENIERIA DE SOFTWARE I", 0);
        createMateria("INGENIERIA DE SOFTWARE II", 0);
        createMateria("INGENIERIA DE SOFTWARE III", 0);
        createMateria("INGLES III", 0);
        createMateria("INGLES IV", 0);
        createMateria("INVESTIGACION OPERATIVA I", 0);
        createMateria("INVESTIGACION OPERATIVA II", 0);
        createMateria("LENGUAJES DE PROGRAMACION VII - (DATAWAREHOUSEING)", 0);
        createMateria("LENGUAJES DE PROGRAMACION VIII - (DATAWAREHOUSEING)", 0);
        createMateria("METROLOGIA DIMENSIONAL I", 0);
        createMateria("PROYECTO INFORMATICA I", 0);
        createMateria("PROYECTO INFORMATICA II", 0);
        createMateria("REDES DE COMPUTADORAS I", 0);
        createMateria("REDES DE COMPUTADORAS II", 0);
        createMateria("ADMINISTRACION, CONTABILIDAD Y PRESUPUESTO", 0);
        createMateria("AUDITORIA INFORMATICA I", 0);
        createMateria("AUDITORIA INFORMATICA II", 0);
        createMateria("CIENCIAS DEL AMBIENTE I", 0);
        createMateria("COMPILADORES I", 0);
        createMateria("COMPILADORES II", 0);
        createMateria("CONSERVACION DE ENERGIA", 0);
        createMateria("COSTOS INDUSTRIALES", 0);
        createMateria("ECONOMIA (ESTADISTICA Y CENSOS)", 0);
        createMateria("ESTADISTICA APLICADA", 0);
        createMateria("INGENIERIA ECONOMICA", 0);
        createMateria("INSTRUMENTOS Y SISTEMAS DE MEDIDAS I", 0);
        createMateria("INTELIGENCIA ARTIFICIAL I", 0);
        createMateria("INTELIGENCIA ARTIFICIAL II", 0);
        createMateria("PROYECTO FINAL I", 0);
        createMateria("PROYECTO FINAL II", 0);
        createMateria("SEGURIDAD INFORMATICA I", 0);
        createMateria("SEGURIDAD INFORMATICA II", 0);
        createMateria("SISTEMAS DE CONTROL I", 0);
        createMateria("SOCIOLOGIA GENERAL I", 0);
        createMateria("TECNOLOGIA INFORMATICA I", 0);
        createMateria("TECNOLOGIA INFORMATICA II", 0);
        createMateria("TESIS FINAL", 0);
        createMateria("TUTORIA DE TESIS I", 0);
        createMateria("TUTORIA DE TESIS II", 0);
        createMateria("TUTORIA DE TESIS III", 0);
        createMateria("TUTORIA DE TESIS IV", 0);
        createMateria(" TUTORIA DE TESIS V", 0);
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
    public void createMateria(String name, int estado) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, name);
        values.put(COL_ESTADO, estado);
        mDb.insert(TABLE_NAME, null, values);
    }

    //sobrecargado para tomar un Materia
    public long createMateria(Materia Materia) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, Materia.getMateria()); // Nombre Contacto
        values.put(COL_ESTADO, Materia.getEstado()); // Número teléfono Contacto

        // Insertar fila
        return mDb.insert(TABLE_NAME, null, values);
    }

    //READ
    public Materia fetchMateriaById(int id) {
        Cursor cursor = mDb.query(TABLE_NAME, new String[]{COL_ID,
                        COL_MATERIA, COL_ESTADO}, COL_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        return new Materia(
                cursor.getInt(INDEX_ID),
                cursor.getString(INDEX_CONTENT),
                cursor.getInt(INDEX_IMPORTANT)
        );
    }

    public Cursor fetchAllMaterias() {
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
    public void updateMateria(Materia Materia) {
        ContentValues values = new ContentValues();
        values.put(COL_MATERIA, Materia.getMateria());
        values.put(COL_ESTADO, Materia.getEstado());
        mDb.update(TABLE_NAME, values,
                COL_ID + "=?", new String[]{String.valueOf(Materia.getId())});
    }

    public void updateMateria(int id) {
        ContentValues values = new ContentValues();

        values.put(COL_ESTADO, id);
        mDb.update(TABLE_NAME, values,
                COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void deleteMateriaById(int nId) {
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
