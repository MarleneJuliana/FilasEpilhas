/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemabanco;

import java.util.Date;

/**
 *
 * @author Marlene Juliana
 */
class Cliente {
        private int senha;
        private String nome;
        private Date dataNascimento;

        public Cliente(int senha, String nome, Date dataNascimento) {
            this.senha = senha;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public int getSenha() {
            return senha;
        }

        public String getNome() {
            return nome;
        }

        public boolean isPrioritario() {
            // Calcula a idade com base na data de nascimento
            Date dataAtual = new Date();
            long diferenca = dataAtual.getTime() - dataNascimento.getTime();
            long anos = diferenca / (1000L * 60 * 60 * 24 * 365);
            return anos >= 65;
        }
    }