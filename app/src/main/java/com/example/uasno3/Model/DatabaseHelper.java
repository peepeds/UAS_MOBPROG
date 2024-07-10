package com.example.uasno3.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mahasiswa1.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MAHASISWA = "mahasiswa";
    private static final String COLUMN_NO = "no";  // Changed from int to String
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_NIM = "nim";
    private static final String COLUMN_IPK = "ipk";
    private static final String COLUMN_MATKUL = "matkul";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_MAHASISWA + " ("
                + COLUMN_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, "  // Added space after COLUMN_NO
                + COLUMN_NAMA + " TEXT, "
                + COLUMN_NIM + " TEXT, "
                + COLUMN_IPK + " TEXT, "
                + COLUMN_MATKUL + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        onCreate(db);
    }

    public boolean addMahasiswa(String nama, String NIM, String IPK, String matkul) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_NIM, NIM);
        values.put(COLUMN_IPK, IPK);
        values.put(COLUMN_MATKUL, matkul);
        long result = db.insert(TABLE_MAHASISWA, null, values);
        return result != -1;
    }

    public List<Mahasiswa> getMahasiswa() {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MAHASISWA, null);
        if (cursor.moveToFirst()) {
            do {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNo(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NO)));
                mahasiswa.setNama(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA)));
                mahasiswa.setNim(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NIM)));
                mahasiswa.setIpk(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IPK)));
                mahasiswa.setMatkul(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MATKUL)));
                mahasiswaList.add(mahasiswa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mahasiswaList;
    }

    public boolean deleteMahasiswa(String NIM) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_MAHASISWA, COLUMN_NIM + "=?", new String[]{NIM});
        return result > 0;
    }
}
