package com.dellead.exemplo_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper {

    private static final String NOME_DATABASE = "exsqlite.db";
    private static final int VERSAO_DATABASE = 1;
    private static final String Tabela_Cadastro = "CREATE TABLE IF NOT EXISTS CADASTRO(" +
            " ESPORTE TEXT," +
            " TIME TEXT," +
            " EQUIPE TEXT," +
            " JOGADORES TEXT)";

    public Sqlite(Context context){

        super(context,NOME_DATABASE,null,VERSAO_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Tabela_Cadastro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InserirInformacoes(String ESPORTE,String TIME, String EQUIPE, String JOGADORES){

        SQLiteDatabase db = getWritableDatabase();
        String comando = "insert into CADASTRO(ESPORTE,TIME,EQUIPE,JOGADORES)" +
                " values('"+ESPORTE+"','"+TIME+"','"+EQUIPE+"','"+JOGADORES+"'  )";
        db.execSQL(comando);
    }
}
