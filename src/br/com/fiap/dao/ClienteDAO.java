package br.com.fiap.dao;

import br.com.fiap.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    private Connection conexao;
    PreparedStatement p;
    String sql;
    ResultSet rs;

    public void inserirCliente(Cliente cliente) {

    }
}