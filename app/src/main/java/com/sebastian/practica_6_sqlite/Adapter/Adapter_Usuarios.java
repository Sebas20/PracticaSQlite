package com.sebastian.practica_6_sqlite.Adapter;

import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sebastian.practica_6_sqlite.Clases.UsuariosVo;
import com.sebastian.practica_6_sqlite.R;

import java.util.ArrayList;

/**
 * Created by Usuario on 1/11/2017.
 */

public class Adapter_Usuarios
        extends RecyclerView.Adapter<Adapter_Usuarios.ViewHoldUsuario>
        implements View.OnClickListener{

    ArrayList<UsuariosVo> usuarios;
    private View.OnClickListener listener;

    public Adapter_Usuarios(ArrayList<UsuariosVo> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }

    }

    public class ViewHoldUsuario extends  RecyclerView.ViewHolder{
        TextView tId,tNombre_libro,tNombre_autor,tNombre_persona,tTelefono;
        public ViewHoldUsuario(View itemView) {
            super(itemView);
            tId = (TextView)itemView.findViewById(R.id.tId);
            tNombre_libro = (TextView)itemView.findViewById(R.id.tNombre_libro);
            tNombre_autor = (TextView)itemView.findViewById(R.id.tNombre_autor);
            tNombre_persona = (TextView)itemView.findViewById(R.id.tNombre_persona);
            tTelefono = (TextView)itemView.findViewById(R.id.tTelefono);
        }
    }

    @Override
    public ViewHoldUsuario onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_users,null,false);
        view.setOnClickListener(this);
        return  new ViewHoldUsuario(view);
    }

    @Override
    public void onBindViewHolder(ViewHoldUsuario holder, int position) {
        holder.tId.setText(usuarios.get(position).getId_libro());
        holder.tNombre_libro.setText(usuarios.get(position).getNombre_libro().toString());
        holder.tNombre_autor.setText(usuarios.get(position).getNombre_autor().toString());
        holder.tNombre_persona.setText(usuarios.get(position).getNombre_persona().toString());
        holder.tTelefono.setText(usuarios.get(position).getTelefono_persona());

    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


}
