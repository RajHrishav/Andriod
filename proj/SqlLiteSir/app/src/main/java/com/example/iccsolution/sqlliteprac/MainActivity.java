package com.example.iccsolution.sqlliteprac;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countRecords();
        readRecords();
    }

    public void CreateRecord(View view)
    {
        //Get the application context, this is needed to inflate an XML layout file
       final Context context = view.getRootView().getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.student_input_form, null, false);
        final EditText editTextStudentFirstname = (EditText) formElementsView.findViewById(R.id.editTextStudentFirstname);
        final EditText editTextStudentEmail = (EditText) formElementsView.findViewById(R.id.editTextStudentEmail);
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Student")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String studentFirstname = editTextStudentFirstname.getText().toString();
                                String studentEmail = editTextStudentEmail.getText().toString();

                                Student objectStudent = new Student();
                                objectStudent.setFirstname( studentFirstname);
                                objectStudent.setEmail(studentEmail);
                                boolean createSuccessful = new TableControllerStudent(context).create(objectStudent);

                                if(createSuccessful){
                                    Toast.makeText(context, "Student information was saved.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to save student information.", Toast.LENGTH_SHORT).show();
                                }
                                dialog.cancel();
                            }

                        }).show();
    }

    public void countRecords() {
        int recordCount = new TableControllerStudent(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " records found.");
    }

    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<Student> students = new TableControllerStudent(this).read();

        if (students.size() > 0) {

            for (Student obj : students) {

                int id = obj.id;
                String studentFirstname = obj.firstname;
                String studentEmail = obj.email;

                String textViewContents = studentFirstname + " - " + studentEmail;

                TextView textViewStudentItem= new TextView(this);
                textViewStudentItem.setPadding(0, 10, 0, 10);
                textViewStudentItem.setText(textViewContents);
                textViewStudentItem.setTag(Integer.toString(id));
                textViewStudentItem.setOnClickListener(new OnClickListenerStudentRecord());

                linearLayoutRecords.addView(textViewStudentItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }

    }

    public class OnClickListenerStudentRecord implements View.OnClickListener {

        Context context;
        String id;

        @Override
        public void onClick(View v) {
            context = v.getContext();
            id = v.getTag().toString();
            final CharSequence[] items = { "Edit", "Delete" };

            new AlertDialog.Builder(context).setTitle("Student Record")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            if (item == 0) {
                                editRecord(Integer.parseInt(id));
                            }
                            else if (item == 1) {

                                boolean deleteSuccessful = new TableControllerStudent(context).delete(Integer.parseInt(id));

                                if (deleteSuccessful){
                                    Toast.makeText(context, "Student record was deleted.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to delete student record.", Toast.LENGTH_SHORT).show();
                                }

                                ((MainActivity) context).countRecords();
                                ((MainActivity) context).readRecords();

                            }
                            dialog.dismiss();

                        }
                    }).show();
        }
        public void editRecord(final int studentId) {
            final TableControllerStudent tableControllerStudent = new TableControllerStudent(context);
            Student objectStudent = tableControllerStudent.readSingleRecord(studentId);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.student_input_form, null, false);
            final EditText editTextStudentFirstname = (EditText) formElementsView.findViewById(R.id.editTextStudentFirstname);
            final EditText editTextStudentEmail = (EditText) formElementsView.findViewById(R.id.editTextStudentEmail);
            editTextStudentFirstname.setText(objectStudent.firstname);
            editTextStudentEmail.setText(objectStudent.email);
            new AlertDialog.Builder(context)
                    .setView(formElementsView)
                    .setTitle("Edit Record")
                    .setPositiveButton("Save Changes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Student objectStudent = new Student();
                                    objectStudent.setId(studentId);
                                    objectStudent.setFirstname( editTextStudentFirstname.getText().toString());
                                    objectStudent.setEmail(editTextStudentEmail.getText().toString());
                                    boolean updateSuccessful = tableControllerStudent.update(objectStudent);

                                    if(updateSuccessful){
                                        Toast.makeText(context, "Student record was updated.", Toast.LENGTH_SHORT).show();
                                        ((MainActivity) context).countRecords();
                                        ((MainActivity) context).readRecords();
                                    }else{
                                        Toast.makeText(context, "Unable to update student record.", Toast.LENGTH_SHORT).show();
                                    }
                                    dialog.cancel();
                                }

                            }).show();
        }
    }

}
