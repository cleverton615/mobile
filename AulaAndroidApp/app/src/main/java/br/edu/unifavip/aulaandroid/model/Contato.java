package br.edu.unifavip.aulaandroid.model;

public class Contato {

    private Integer id;
    private String description;

    public Contato(){

    }

    public Contato(Integer id, String description){
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
