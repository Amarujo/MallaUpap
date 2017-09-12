package com.gametest.www.mallaupap;

/**
 * Created by admin on 2/1/2017.
 */

public class Materia {

    private int mId;
    private String mMateria;
    private int mEstado;

    public Materia(int id, String content, int important) {
        mId = id;
        mMateria = content;
        mEstado = important;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getMateria() {
        return mMateria;
    }

    public void setMateria(String content) {
        mMateria = content;
    }

    public int getEstado() {
        return mEstado;
    }

    public void setEstado(int important) {
        mEstado = important;
    }
}
