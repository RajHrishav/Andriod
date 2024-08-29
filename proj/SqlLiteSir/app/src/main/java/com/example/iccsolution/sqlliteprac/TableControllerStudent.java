package com.example.iccsolution.sqlliteprac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iccsolution.sqlliteprac.DatabaseHandler;
import com.example.iccsolution.sqlliteprac.Student;

import java.util.ArrayList;
import java.util.List;

public class TableControllerStudent extends DatabaseHandler {

    public TableControllerStudent(Context context)
    {
        super(context);
    }

    public boolean create(Student objectStudent)
    {

        ContentValues values = new ContentValues();

        values.put("firstname", objectStudent.getFirstname());
        values.put("email", objectStudent.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("students", null, values) > 0;
        db.close();

        return createSuccessful;
    }
    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM students";
        int recordCount = db.rawQuery(sql, null).getCount();//getCount will return no. of row
        db.close();

        return recordCount;

    }
    public List<Student> read() {

        List<Student> recordsList = new ArrayList<Student>();

        String sql = "SELECT * FROM students ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String studentFirstname = cursor.getString(cursor.getColumnIndex("firstname"));
                String studentEmail = cursor.getString(cursor.getColumnIndex("email"));

                Student objectStudent = new Student();
                objectStudent.setId( id);
                objectStudent.setFirstname(studentFirstname);
                objectStudent.setEmail(studentEmail);

                recordsList.add(objectStudent);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }
    public Student readSingleRecord(int studentId) {

        Student objectStudent = null;

        String sql = "SELECT * FROM students WHERE id = " + studentId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            String email = cursor.getString(cursor.getColumnIndex("email"));

            objectStudent = new Student();
            objectStudent.setId( id);
            objectStudent.setFirstname(firstname);
            objectStudent.setEmail(email);

        }

        cursor.close();
        db.close();

        return objectStudent;

    }
    public boolean update(Student objectStudent) {

        ContentValues values = new ContentValues();

        values.put("firstname", objectStudent.getFirstname());
        values.put("email", objectStudent.getEmail());

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectStudent.id) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("students", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }
    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("students", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }
}