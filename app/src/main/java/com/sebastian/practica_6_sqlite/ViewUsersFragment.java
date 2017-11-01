package com.sebastian.practica_6_sqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebastian.practica_6_sqlite.Adapter.Adapter_Usuarios;
import com.sebastian.practica_6_sqlite.Clases.UsuariosVo;
import com.sebastian.practica_6_sqlite.Utilidades.Utilidades;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUsersFragment extends Fragment {

    ArrayList<UsuariosVo> usuarios;
    RecyclerView recyclerView_usuarios;
    ConexionSqliteHelper conn;

    public ViewUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_view_users, container, false);
        conn = new ConexionSqliteHelper(getContext(), "bd usuarios", null, 1);
        usuarios = new ArrayList<>();
        recyclerView_usuarios = (RecyclerView)rootView.findViewById(R.id.recyclerview_users);
        recyclerView_usuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        consultarUsuarios();
        Adapter_Usuarios adapter = new Adapter_Usuarios(usuarios);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Toast.makeText(getContext(),usuarios.get(recyclerView_usuarios.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater1 = getActivity().getLayoutInflater();
                View mView = inflater1.inflate(R.layout.dialog_layout,null);

                Button bEliminar = (Button)mView.findViewById(R.id.bEliminar);
                Button bEditar = (Button)mView.findViewById(R.id.bEditar);
                bEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        //Toast.makeText(getContext(),usuarios.get(recyclerView_usuarios.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                        SQLiteDatabase db = conn.getWritableDatabase();
                        String selection = Utilidades.CAMPO_ID+"=?";
                        String[] parametros = {usuarios.get(recyclerView_usuarios.getChildAdapterPosition(view)).getId_libro()};
                        db.delete(Utilidades.TABLA_USUARIO,selection,parametros);
                        Toast.makeText(getActivity(),"La información se elimino exitosamente",Toast.LENGTH_SHORT).show();


                    }
                });
                bEditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick( View view1) {
                        final AlertDialog.Builder eBuilder = new AlertDialog.Builder(getContext());
                        LayoutInflater einflater = getActivity().getLayoutInflater();
                        View eView = einflater.inflate(R.layout.dialog_editar_layout,null);
                        final EditText eNombre = (EditText)eView.findViewById(R.id.eNombre_persona);
                        final EditText eTelefono = (EditText)eView.findViewById(R.id.eTelefono);
                        Button bGuardar = (Button)eView.findViewById(R.id.bGuardar);
                        bGuardar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view4) {
                                String Nombre = eNombre.getText().toString();
                                String Telefono = eTelefono.getText().toString();
                                String[] parametros = {usuarios.get(recyclerView_usuarios.getChildAdapterPosition(view)).getId_libro()};
                                if(!Nombre.isEmpty()){
                                    SQLiteDatabase db = conn.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    values.put(Utilidades.CAMPO_NOMBRE_USUARIO,Nombre);
                                    db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
                                    db.close();
                                    Toast.makeText(getActivity(),"La información se modifico exitosamente",Toast.LENGTH_SHORT).show();

                                }
                                if(!Telefono.isEmpty()){
                                    SQLiteDatabase db = conn.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    values.put(Utilidades.CAMPO_TELEFONO,Telefono);
                                    db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
                                    db.close();
                                    Toast.makeText(getActivity(),"La información se modifico exitosamente",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                        eBuilder.setView(eView);
                        AlertDialog dialog = eBuilder.create();
                        dialog.show();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });
        recyclerView_usuarios.setAdapter(adapter);

        return rootView;
    }

    private void consultarUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        UsuariosVo user = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);
        while (cursor.moveToNext()){
            user = new UsuariosVo();
            user.setId_libro(cursor.getString(0));
            user.setNombre_libro(cursor.getString(1));
            user.setNombre_autor(cursor.getString(2));
            user.setNombre_persona(cursor.getString(3));
            user.setTelefono_persona(cursor.getString(4));
            usuarios.add(user);
        }
    }

}
