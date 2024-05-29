/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.empresatransporte;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marlene Juliana
 */
public class Produto {
    private int codProduto;
    private String descricao;
    private Date dataEntrada;
    private String ufOrigem;
    private String ufDestino;

    public Produto(int codProduto, String descricao, Date dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public String getUfOrigem() {
        return ufOrigem;
    }

    public String getUfDestino() {
        return ufDestino;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Produto [Código: " + codProduto + ", Descrição: " + descricao + ", Data de Entrada: " + sdf.format(dataEntrada) +
               ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino + "]";
    }
}