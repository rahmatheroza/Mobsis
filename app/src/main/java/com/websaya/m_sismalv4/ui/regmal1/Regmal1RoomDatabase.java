package com.websaya.m_sismalv4.ui.regmal1;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Regmal1.class}, version = 1, exportSchema = false)
public abstract class Regmal1RoomDatabase extends RoomDatabase {
    public abstract Regmal1Dao regmal1Dao();
    private static Regmal1RoomDatabase INSTANCE;

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                }
            };

    static Regmal1RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Regmal1RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Regmal1RoomDatabase.class, "regmal1_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
