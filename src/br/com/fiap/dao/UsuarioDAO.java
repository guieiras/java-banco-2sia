package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    private Connection conexao;
    
    public boolean pesqusarUsuario(Usuario u) {
        try {
            conexao = Conexao.getConnection();
            String sql = "SELECT * FROM POO_USUARIO WHERE LOGIN = ? AND SENHA = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, u.getLogin());
            p.setString(2, u.getSenha());
            ResultSet rs = p.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário\n"+ex);
        }
        return false;
    } 
}
