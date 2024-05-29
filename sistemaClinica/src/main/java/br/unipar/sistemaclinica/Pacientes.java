/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemaclinica;

/**
 *
 * @author Marlene Juliana
 */
class Pacientes {
    private String nome;
    private int senha;

    public Pacientes(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }
}

