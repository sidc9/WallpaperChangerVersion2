package com.siddhanta.wallpaperchangerversion2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Sidd.c on 14/8/2015.
 */
public class DatabaseManager { // Contract class

    public DatabaseManager(){};

    public  static abstract class SubredditsDB implements BaseColumns{
        private static final String TABLE_NAME = "SubredditList";
        private static final String KEY_ROWID = "id";
        private static final String KEY_NAME = "name";
        private static final String KEY_POSITION = "position";
        private static final String KEY_STATE = "state";
    }




public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "Subreddits.db";

    private static final String TABLE_CREATE = "create table " + SubredditsDB.TABLE_NAME + " ("
            + SubredditsDB.KEY_ROWID + " int primary key not null, "
            + SubredditsDB.KEY_NAME + " varchar(50) not null, "
            + SubredditsDB.KEY_POSITION + " int not null, "
            + SubredditsDB.KEY_STATE + " int default 0);";

    private static final String DELETE_TABLE = "drop table if exists " + SubredditsDB.TABLE_NAME;

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
}
}
