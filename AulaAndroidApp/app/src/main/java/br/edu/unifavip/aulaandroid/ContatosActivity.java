package br.edu.unifavip.aulaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifavip.aulaandroid.adapter.ContatoAdapter;
import br.edu.unifavip.aulaandroid.model.Contato;
import br.edu.unifavip.aulaandroid.service.ContatoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContatosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContatoAdapter contatoAdapter;
    private List<Contato> contatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_contatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        contatoAdapter = new ContatoAdapter(this, contatos);
        recyclerView.setAdapter(contatoAdapter);

        carregarDados();
    }

    public void carregarDados(){

        // https://square.github.io/retrofit/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContatoService service = retrofit.create(ContatoService.class);

        Call<List<Contato>> call = service.listarContatos();

        call.enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
                for(Contato contato : response.body()){
                    contatos.add(contato);
                }
                contatoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t) {
                t.printStackTrace();
                Log.d("erro", "deu erro: " + t.getMessage());
            }
        });


    }

}
