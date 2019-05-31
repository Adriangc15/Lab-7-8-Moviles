package com.example.mobilecontrol.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobilecontrol.Adapter.AlumnoAdapter;
import com.example.mobilecontrol.LogicaNegocio.Alumno;
import com.example.mobilecontrol.LogicaNegocio.Carrera;
import com.example.mobilecontrol.LogicaNegocio.Ciclo;
import com.example.mobilecontrol.LogicaNegocio.Curso;
import com.example.mobilecontrol.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddUpdCursoActivity extends AppCompatActivity {
    private FloatingActionButton fBtn;
    private boolean editable = true;
    private EditText codFld;
    private Spinner carreras, ciclos;
    private EditText nomFld;
    private EditText creditosFld;
    private EditText horasFld;
    private List<Carrera> carreraList;
    private List<Ciclo> cicloList;

    //String apiUrl = "http://192.168.0.18:8080/BE-LabConnection/ServiceCarrera?";
    //String apiUrl = "http://10.20.105.143:8080/BE-LabConnection/ServiceCurso?";
    String apiUrl = "http://10.20.106.109:8080/BE-LabConnection/ServiceCurso?";
    String apiUrlTemporal = "";
    String apiUrlTemporal2 = "";
    //String apiUrl2 = "http://192.168.0.18:8080/BE-LabConnection/ServiceCiclo?";
//    String apiUrl2 = "http://10.20.105.143:8080/BE-LabConnection/ServiceCiclo?";
//    String apiUrlTemporal2 = "";
   // private ModelData model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upd_curso);
        editable = true;

        // button check
        fBtn = findViewById(R.id.addUpdCursoBtn);



        //cleaning stuff
        codFld = findViewById(R.id.codigoAddUpdCurso);
        carreras = (Spinner) findViewById(R.id.sp_carreras);
        ciclos = (Spinner) findViewById(R.id.sp_ciclos);
        nomFld = findViewById(R.id.nombreAddUpdCurso);
        creditosFld = findViewById(R.id.creditosAddUpdCurso);
        horasFld = findViewById(R.id.horasAddUpdCiclo);
        codFld.setText("");
        nomFld.setText("");
        creditosFld.setText("");
        horasFld.setText("");


        //Carreras
        apiUrlTemporal = apiUrl + "opc=6";
        MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
        myAsyncTasks.execute();
        //Ciclos
        apiUrlTemporal2 = apiUrl + "opc=5";
        MyAsyncTasks2 myAsyncTasks2 = new MyAsyncTasks2();
        myAsyncTasks2.execute();

//        loadCarreras();
//        loadCiclos();

        //receiving data from admCursoActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Curso aux = (Curso) getIntent().getSerializableExtra("curso");
                codFld.setText(aux.getCodigo());
                codFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                creditosFld.setText(Integer.toString(aux.getCreditos()));
                horasFld.setText(Integer.toString(aux.getHoras()));
                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editCurso();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addCurso();
                    }
                });
            }
        }
    }


    public void addCurso() {
        if (validateForm()) {
            //do something
            Carrera carr = buscarCarrera(carreraList, (Carrera)carreras.getSelectedItem());
            Ciclo cic = buscarCiclo(cicloList, ciclos.getSelectedItem().toString());

            Curso cur = new Curso(codFld.getText().toString(),cic,carr, nomFld.getText().toString(),
                    Integer.parseInt(creditosFld.getText().toString()),
                    Integer.parseInt(horasFld.getText().toString()));
            Intent intent = new Intent(getBaseContext(), AdmCursoActivity.class);
            //sending curso data
            intent.putExtra("addCurso", cur);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public void editCurso() {
        if (validateForm()) {
            Carrera carr = buscarCarrera(carreraList, (Carrera)carreras.getSelectedItem());
            Ciclo cic = buscarCiclo(cicloList, ciclos.getSelectedItem().toString());

            Curso cur = new Curso(codFld.getText().toString(),cic,carr, nomFld.getText().toString(),
                    Integer.parseInt(creditosFld.getText().toString()),
                    Integer.parseInt(horasFld.getText().toString()));
            Intent intent = new Intent(getBaseContext(), AdmCursoActivity.class);
            //sending curso data
            intent.putExtra("editCurso", cur);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public Carrera buscarCarrera(List<Carrera> carreraList, Carrera carrera){
        for (Carrera c : carreraList) {
            if (c.getCodigo().equals(carrera.getCodigo())) {
                return c;
            }
        }
        return null;
    }

    public Ciclo buscarCiclo(List<Ciclo> cicloList, String cicloCodigo){
        for (Ciclo ciclo : cicloList) {
            if (ciclo.getCodigo().equals(cicloCodigo)) {
                return ciclo;
            }
        }
        return null;
    }


    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.nomFld.getText())) {
            nomFld.setError("Nombre requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.codFld.getText())) {
            codFld.setError("Codigo requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.creditosFld.getText())) {
            creditosFld.setError("Creditos requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.horasFld.getText())) {
            horasFld.setError("Horas requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Algunos errores", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void loadCiclos(List ciclosList) {
        // im not sure about this
        ArrayAdapter<Ciclo> adapter = new ArrayAdapter<Ciclo>(this, R.layout.support_simple_spinner_dropdown_item, ciclosList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ciclos.setAdapter(adapter);
    }

    private void loadCarreras(List carreraList) {
        // im not sure about this
        ArrayAdapter<Carrera> adapter = new ArrayAdapter<Carrera>(this, R.layout.support_simple_spinner_dropdown_item, carreraList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        carreras.setAdapter(adapter);
    }

    private int getIndex(Spinner spinner, String cod) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(cod)) {
                return i;
            }
        }

        return 0;
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
                ArrayList<Carrera> CarreraList= (ArrayList<Carrera>) gson.fromJson(s,
                        new TypeToken<ArrayList<Carrera>>() {
                        }.getType());


                carreraList = CarreraList;
                loadCarreras(carreraList);

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
                ArrayList<Ciclo> CicloList= (ArrayList<Ciclo>) gson.fromJson(s,
                        new TypeToken<ArrayList<Ciclo>>() {
                        }.getType());


                cicloList = CicloList;
                loadCiclos(cicloList);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
