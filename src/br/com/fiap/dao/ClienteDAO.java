package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private Connection conexao;
    PreparedStatement p;
    String sql;
    ResultSet rs;

    public void inserirCliente(Cliente cliente) {
        try {
            conexao = Conexao.getConnection();
            sql = "INSERT INTO POO_CLIENTE VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getCaminho());
            p.execute();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir cliente\n"+ex);
        }
    }
    
    public Cliente pesquisarCliente(String nome) {
        Cliente cliente = null;
        conexao = Conexao.getConnection();
        sql = "SELECT * FROM POO_CLIENTE WHERE NOME = ?";
        String endereco, fone, caminho;
        Date nascimento;
        try {
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            if(rs.next()) {
                endereco = rs.getString("endereco");
                nascimento = rs.getDate("nascimento");
                fone = rs.getString("fone");
                caminho = rs.getString("caminho");
                cliente = new Cliente(nome, endereco, nascimento, fone, caminho);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente\n"+ex);
        }
        return cliente;
    }
}