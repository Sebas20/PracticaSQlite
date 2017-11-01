package com.sebastian.practica_6_sqlite.Entidades;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebastian.practica_6_sqlite.ConexionSqliteHelper;
import com.sebastian.practica_6_sqlite.R;
import com.sebastian.practica_6_sqlite.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewUserFragment extends Fragment {

    EditText eId, eNombre_libro, eNombre_autor, eNombre_persona, eTelefono;

    public NewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_user, container, false);
        Button bRegistrar = (Button)rootView.findViewById(R.id.bRegistrar);
        eId = (EditText) rootView.findViewById(R.id.eId);
        eNombre_libro = (EditText) rootView.findViewById(R.id.eNombre_libro);
        eNombre_autor = (EditText) rootView.findViewById(R.id.eNombre_autor);
        eNombre_persona = (EditText) rootView.findViewById(R.id.eNombre_persona);
        eTelefono = (EditText) rootView.findViewById(R.id.eTelefono);
        bRegistrar = (Button) rootView.findViewById(R.id.bRegistrar);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id_libro = eId.getText().toString();
                String Nombre_libro = eNombre_libro.getText().toString();
                String Nombre_autor = eNombre_autor.getText().toString();
                String Nombre_persona = eNombre_persona.getText().toString();
                String Telefono = eTelefono.getText().toString();
                if (id_libro.isEmpty() || Nombre_libro.isEmpty() || Nombre_autor.isEmpty() || Nombre_persona.isEmpty() || Telefono.isEmpty()) {
                    Toast.makeText(getContext(), "Hay Campos Vacios", Toast.LENGTH_SHORT).show();
                } else {
                    //registroUsuarioSQL(id_libro, Nombre_libro, Nombre_autor, Nombre_persona, Telefono);
                    registrarUsuario(id_libro, Nombre_libro, Nombre_autor, Nombre_persona, Telefono);
                }
            }
        });

        return rootView;
    }

    private void registroUsuarioSQL(String id, String nombre, String telefono) {
        ConexionSqliteHelper conn = new ConexionSqliteHelper(getContext(),"bd usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String insert = "INSERT INTO "+Utilidades.TABLA_USUARIO+"("+Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE_AUTOR+","+Utilidades.CAMPO_TELEFONO+") VALUES ("+id+",'"+nombre+"','"+telefono+"')";
        db.execSQL(insert);
        db.close();
    }

    private void registrarUsuario(String id_libro, String nombre_libro, String nombre_autor, String nombre_persona, String telefono) {
        ConexionSqliteHelper conn = new ConexionSqliteHelper(getContext(),"bd usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,id_libro);
        values.put(Utilidades.CAMPO_NOMBRE_AUTOR,nombre_autor);
        values.put(Utilidades.CAMPO_NOMBRE_LIBRO,nombre_libro);
        values.put(Utilidades.CAMPO_NOMBRE_USUARIO,nombre_persona);
        values.put(Utilidades.CAMPO_TELEFONO,telefono);
        Long idResultado = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getActivity(),"La información se guardo exitosamente",Toast.LENGTH_SHORT).show();
        db.close();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Registrar");
    }
}
