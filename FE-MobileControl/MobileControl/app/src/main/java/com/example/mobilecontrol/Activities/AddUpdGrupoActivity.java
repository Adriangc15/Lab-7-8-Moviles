package com.example.mobilecontrol.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobilecontrol.LogicaNegocio.Carrera;
import com.example.mobilecontrol.LogicaNegocio.Ciclo;
import com.example.mobilecontrol.LogicaNegocio.Curso;
import com.example.mobilecontrol.LogicaNegocio.Grupo;
import com.example.mobilecontrol.LogicaNegocio.Profesor;
import com.example.mobilecontrol.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddUpdGrupoActivity extends AppCompatActivity {
    private FloatingActionButton fBtn;
    private boolean editable = true;
    private EditText codFld;
    private Spinner cursos, profesores;
    private EditText horarioFld;
    private List<Curso> cursoList;
    private List<Profesor> profesorList;

    //String apiUrl = "http://192.168.0.18:8080/BE-LabConnection/ServiceCurso?";
    String apiUrl = "http://10.20.106.109:8080/BE-LabConnection/ServiceGrupo?";
    String apiUrlTemporal = "";
    String apiUrlTemporal2 = "";
    //String apiUrl2 = "http://192.168.0.18:8080/BE-LabConnection/ServiceProfesor?";
//    String apiUrl2 = "http://10.20.105.143:8080/BE-LabConnection/ServiceProfesor?";
//    String apiUrlTemporal2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upd_grupo);
        editable = true;

        // button check
        fBtn = findViewById(R.id.addUpdGrupoBtn);

        //cleaning stuff
        codFld = findViewById(R.id.codigoAddUpdGrupo);
        cursos = (Spinner) findViewById(R.id.sp_cursos);
        profesores = (Spinner) findViewById(R.id.sp_profesores);
        horarioFld = findViewById(R.id.horarioAddUpdGrupo);
        codFld.setText("");
        horarioFld.setText("");


        //Cursos
        apiUrlTemporal = apiUrl + "opc=5";
        MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
        myAsyncTasks.execute();
        //Profesores
        apiUrlTemporal2 = apiUrl + "opc=6";
        MyAsyncTasks2 myAsyncTasks2 = new MyAsyncTasks2();
        myAsyncTasks2.execute();



//        loadCursos();
//        loadProfesores();

        //receiving data from admCursoActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Grupo aux = (Grupo) getIntent().getSerializableExtra("grupo");
                codFld.setText(aux.getCodigo());
                codFld.setEnabled(false);
                horarioFld.setText(aux.getHorario());
                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editGrupo();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addGrupo();
                    }
                });
            }
        }
    }

    public void addGrupo() {
        if (validateForm()) {
            //do something
            Curso cur = buscarCurso(cursoList, (Curso)cursos.getSelectedItem());
            Profesor prof = buscarProfesor(profesorList,(Profesor)profesores.getSelectedItem());
            //Grupo gru = new Grupo(codFld.getText().toString(),cur.getCodigo(),prof.getCedula(),horarioFld.getText().toString());
            Grupo gru = new Grupo(codFld.getText().toString(),cur,prof,horarioFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmGrupoActivity.class);
            //sending curso data
            intent.putExtra("addGrupo", gru);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public void editGrupo() {
        if (validateForm()) {
            Curso cur = buscarCurso(cursoList, (Curso)cursos.getSelectedItem());
            Profesor prof = buscarProfesor(profesorList,(Profesor)profesores.getSelectedItem());
            //Grupo gru = new Grupo(codFld.getText().toString(),cur.getCodigo(),prof.getCedula(),horarioFld.getText().toString());
            Grupo gru = new Grupo(codFld.getText().toString(),cur,prof,horarioFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmGrupoActivity.class);
            //sending curso data
            intent.putExtra("editGrupo", gru);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public Curso buscarCurso(List<Curso> cursoList, Curso curso){
        for (Curso c : cursoList) {
            if (c.getCodigo().equals(curso.getCodigo())) {
                return c;
            }
        }
        return null;
    }

    public Profesor buscarProfesor(List<Profesor> profesorList, Profesor profesor){
        for (Profesor p : profesorList) {
            if (p.getCedula().equals(profesor.getCedula())) {
                return p;
            }
        }
        return null;
    }


//    public Curso buscarCurso(List<Curso> cursoList, String cursoCodigo){
//        for (Curso curso : cursoList) {
//            if (curso.getCodigo().equals(cursoCodigo)) {
//                return curso;
//            }
//        }
//        return null;
//    }
//
//    public Profesor buscarProfesor(List<Profesor> profesorList, String profesorCedula){
//        for (Profesor profesor : profesorList) {
//            if (profesor.getCedula().equals(profesorCedula)) {
//                return profesor;
//            }
//        }
//        return null;
//    }


    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.codFld.getText())) {
            codFld.setError("Codigo requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.horarioFld.getText())) {
            horarioFld.setError("Horario requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Algunos errores", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void loadCursos(List cursoList) {
        // im not sure about this
        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this, R.layout.support_simple_spinner_dropdown_item, cursoList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cursos.setAdapter(adapter);
    }

    private void loadProfesores(List profesorList) {
        // im not sure about this
        ArrayAdapter<Profesor> adapter = new ArrayAdapter<Profesor>(this, R.layout.support_simple_spinner_dropdown_item, profesorList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        profesores.setAdapter(adapter);
    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {

            // implement API in background and store the response in current variable
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiUrlTemporal);

                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();

                    }
                    // return the data to onPostExecute method
                    Log.w("JSON", current);
                    return current;


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return current;
        }


        @Override
        protected void onPostExecute(String s) {
            //S tiene la lista Actualizada que recibe del web service
            //Se actualiza el recycler view
            try {
                Gson gson = new Gson();
                ArrayList<Curso> CursoList= (ArrayList<Curso>) gson.fromJson(s,
                        new TypeToken<ArrayList<Curso>>() {
                        }.getType());


                cursoList = CursoList;
                loadCursos(cursoList);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class MyAsyncTasks2 extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {

            // implement API in background and store the response in current variable
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiUrlTemporal2);

                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();

                    }
                    // return the data to onPostExecute method
                    Log.w("JSON", current);
                    return current;


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return current;
        }


        @Override
        protected void onPostExecute(String s) {
            //S tiene la lista Actualizada que recibe del web service
            //Se actualiza el recycler view
            try {
                Gson gson = new Gson();
                ArrayList<Profesor> ProfesorList= (ArrayList<Profesor>) gson.fromJson(s,
                        new TypeToken<ArrayList<Profesor>>() {
                        }.getType());


                profesorList = ProfesorList;
                loadProfesores(profesorList);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
