/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.MonitorControle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Monitor;

/**
 *
 * @author manuela
 */
public class MonitorJDBCDao implements MonitorControle {
    
    private Connection getConnection(){
         
        Connection conexao = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:hsql://localhost/";
            conexao = DriverManager.getConnection(url, "SA", "");
                    
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Falha na conexão");
        } catch (SQLException ex) {
            System.out.println("Erro de driver");;
        }
    
    return conexao;
    
    
    }

    @Override
    public void salvar(Monitor monitor) {
        Connection conexao = getConnection();
        String comando = "insert into monitor (marca, preco, novo) values (?, ?, ?) ";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, monitor.getMarca());
            ps.setInt(2, monitor.getPreco());
            ps.setBoolean(3, monitor.getNovo());
            
            ps.execute();
            conexao.close();
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(MonitorJDBCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

    @Override
    public void excluir(Monitor monitor) {
        Connection conexao = getConnection();
        String comando = "Delete from monitor where id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setInt(1, monitor.getId());
            ps.execute();
            
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro");
        }
        
    }

    
    @Override
    public ArrayList<Monitor> listar() {
        ArrayList<Monitor> listaMonitores = new ArrayList<>();
        
        Connection conexao = getConnection();
        String consulta = "Select * from monitor";
        try {
            PreparedStatement ps = conexao.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            Monitor monitor = new Monitor();
            monitor.setId(rs.getInt("id"));
            monitor.setMarca(rs.getString("marca"));
            monitor.setPreco(rs.getInt("preco"));
            monitor.setNovo(rs.getBoolean("novo"));
            
            listaMonitores.add(monitor);
        }
            
        } catch (SQLException ex) {
            System.out.println("Erro");
        }
         return listaMonitores;
    }

    @Override
    public void atualizar(Monitor monitor) {
        Connection conexao = getConnection();
        String comando = "Update monitor set marca = ?, preco = ?, novo = ? where id = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, monitor.getMarca());
            ps.setInt(2, monitor.getPreco());
            ps.setBoolean(3, monitor.getNovo());
            ps.setInt(4, monitor.getId());
            
            ps.execute();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro");
        }
     
       
    }
    
    
    
    
}
