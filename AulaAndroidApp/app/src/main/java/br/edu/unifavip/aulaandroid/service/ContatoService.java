package br.edu.unifavip.aulaandroid.service;

import java.util.List;

import br.edu.unifavip.aulaandroid.model.Contato;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ContatoService {

    @GET("weather?q=caruaru")
    Call<List<Contato>> listarContatos();

}
