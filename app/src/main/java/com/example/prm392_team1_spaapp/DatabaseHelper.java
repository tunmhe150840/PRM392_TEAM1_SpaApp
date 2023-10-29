package com.example.prm392_team1_spaapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;


public abstract class DatabaseHelper<T> extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "spa_app_android.db";
    private static final int DATABASE_VERSION = 1;
    private final String tableName;
    private final String idColumn;
    private final String[] columns;
    private String[] columnTypes;

    public DatabaseHelper(Context context, String tableName, String idColumn, String[] columns, String[] columnTypes) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.tableName = tableName;
        this.idColumn = idColumn;
        this.columns = columns;
        this.columnTypes = columnTypes;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + tableName + " ( " +
                idColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, ";

        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            String columnType = columnTypes[i];
            createTableSql += column + " " + columnType;
            if (i != columns.length - 1) {
                createTableSql += ", ";
            }
        }

        createTableSql += ")";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    abstract List<T> getAll();
    abstract T getById(String id);
    abstract void insert(T object);
    abstract void update(T t);
    abstract void delete(String id);}