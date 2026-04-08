package com.example.catalogodigital.model;

import java.io.Serializable;

// Implementamos Serializable para que o objeto possa "viajar" entre telas
public class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}