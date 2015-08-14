package com.siddhanta.wallpaperchangerversion2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Sidd.c on 14/8/2015.
 */
public class DatabaseManager extends SQLiteOpenHelper{ // Contract class


    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "Subreddits.db";

    public DatabaseManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("WCV2", "DB Class created");
    }


    //public  static abstract class SubredditsDB implements BaseColumns{
        public static final String TABLE_NAME = "SubredditList";
        public static final String KEY_ROWID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_POSITION = "position";
        public static final String KEY_STATE = "state";
    //}


    /*private static final String TABLE_CREATE = "create table " + SubredditsDB.TABLE_NAME + " ("
            + SubredditsDB.KEY_ROWID + " int primary key not null, "
            + SubredditsDB.KEY_NAME + " varchar(50) not null, "
            + SubredditsDB.KEY_POSITION + " int not null, "
            + SubredditsDB.KEY_STATE + " int default 0);";

      private static final String DELETE_TABLE = "drop table if exists " + SubredditsDB.TABLE_NAME;*/

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " ("
            + KEY_ROWID + " int primary key not null, "
            + KEY_NAME + " varchar(50) not null, "
            + KEY_POSITION + " int not null, "
            + KEY_STATE + " int default 0);";

    private static final String DELETE_TABLE = "drop table if exists " + TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.d("WCV2", "On create");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
}
