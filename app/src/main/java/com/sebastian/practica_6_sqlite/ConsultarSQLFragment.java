package com.sebastian.practica_6_sqlite;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.practica_6_sqlite.Utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarSQLFragment extends Fragment {

    ConexionSqliteHelper conn;
    TextView tNombre;
    TextView tTelefono;

    public ConsultarSQLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_consultar_sql, container, false);
        conn = new ConexionSqliteHelper(getContext(), "bd usuarios", null, 1);
        Button bConsultar = (Button) rootView.findViewById(R.id.bConsultar);
        Button bActualizar = (Button) rootView.findViewById(R.id.bActualizar);
        Button bEliminar = (Button) rootView.findViewById(R.id.bEliminar);
        final EditText eDocumento = (EditText) rootView.findViewById(R.id.eDocumento);
        tNombre = (TextView) rootView.findViewById(R.id.tNombre);
        tTelefono = (TextView) rootView.findViewById(R.id.tTelefono);

        bConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String documento = eDocumento.getText().toString();
                if (!documento.isEmpty()) {
                    //cosultar(documento);
                    consultarSQL(documento);
                }
            }
        });

        return rootView;
    }

    private void consultarSQL(String documento) {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {documento};
        try {
            Cursor cursor = db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE_AUTOR+","+Utilidades.CAMPO_TELEFONO+" FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"=?",parametros);
            cursor.moveToFirst();
            tNombre.setText(cursor.getString(0));
            tTelefono.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e) {
            Toast.makeText(getContext(),"El docuemnto no exixte",Toast.LENGTH_SHORT).show();
            tNombre.setText("");
            tTelefono.setText("");
        }
    }

    private void cosultar(String documento) {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {documento};
        String[] campos = {Utilidades.CAMPO_NOMBRE_AUTOR, Utilidades.CAMPO_TELEFONO};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            tNombre.setText(cursor.getString(0));
            tTelefono.setText(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getContext(),"El docuemnto no exixte",Toast.LENGTH_SHORT).show();
            tNombre.setText("");
            tTelefono.setText("");
        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Consultar");
    }
}
