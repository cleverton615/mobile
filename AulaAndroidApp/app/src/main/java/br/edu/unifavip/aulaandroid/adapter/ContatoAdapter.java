package br.edu.unifavip.aulaandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.unifavip.aulaandroid.R;
import br.edu.unifavip.aulaandroid.model.Contato;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ContatosViewHolder> {

    private List<Contato> contatos;
    private final Context context;

    public ContatoAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.contatos = contatos;
    }

    @NonNull
    @Override
    public ContatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_contatos, parent, false);
        ContatosViewHolder viewHolder = new ContatosViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContatosViewHolder holder, int position) {
        Contato contato = contatos.get(position);
        holder.textViewContatoNome.setText(contato.getId());
        holder.textViewContatoTelefone.setText(contato.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.contatos != null ? this.contatos.size() : 0;
    }

    public static class ContatosViewHolder extends RecyclerView.ViewHolder {

        TextView textViewContatoNome;
        TextView textViewContatoTelefone;

        public ContatosViewHolder(View view){
            super(view);
            textViewContatoNome = (TextView) view.findViewById(R.id.contato_nome);
            textViewContatoTelefone = (TextView) view.findViewById(R.id.contato_telefone);
        }

    }

}
