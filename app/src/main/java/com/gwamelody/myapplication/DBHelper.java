package com.gwamelody.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.gwamelody.myapplication.Model.Animals;

import java.util.ArrayList;

/**
 * Created by Gwa Melody on 9/12/2560.
 */

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sql;

    private static final String DATABASE_NAME = "DBAnimal";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "animal";
    private static final String ID = BaseColumns._ID;
    private static final String COL_ENGNAME = "engName";
    private static final String COL_THAINAME = "thaiName";
    private static final String COL_PICTURE = "picture";
    private static final String COL_DETAILS = "details";



    public DBHelper(Context context) {
        super(context, TABLE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_ENGNAME + " TEXT, "
        +COL_THAINAME+ " TEXT, "+COL_PICTURE+" INTEGER, "+COL_DETAILS+" TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS "+ TABLE_NAME );
        onCreate(db);

   }

    public void addAnimal(Animals animal){

        sql = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COL_ENGNAME,animal.getEngName() );
       values.put(COL_ENGNAME,animal.getThaiName());
       values.put(COL_ENGNAME,animal.getPicture() );
       values.put(COL_ENGNAME,animal.getDetails() );

       sql.insert(TABLE_NAME,null,values);
       sql.close();

   }
   public ArrayList<Animals> getAnimal(){
       ArrayList<Animals> am = new ArrayList<>();
       Animals a = new Animals();
       sql = this.getWritableDatabase();

       Cursor c;
      c= sql.query(TABLE_NAME,null,null,null,null,null,null,null);
       if(c!=null)
       c.moveToFirst();
       while(!c.isAfterLast()){
           am.add(new Animals(c.getString(1),c.getString(2),c.getInt(3),c.getString(4)));
           c.moveToNext();
       }
       sql.close();
       return am;
   }
    public void deleteFriend(String id) {

        sql = this.getWritableDatabase();

    /*sqLiteDatabase.delete(Friend.TABLE, Friend.Column.ID + " = ? ",
            new String[] { String.valueOf(friend.getId()) });*/
       sql.delete(TABLE_NAME, ID + " = " + id, null);

        sql.close();
    }
}

//create table TABLE_NAME (COL_NAME TYPE +...)
