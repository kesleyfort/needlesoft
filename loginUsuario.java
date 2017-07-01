/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoprog;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 *
 * @author kesley
 */
public class loginUsuario {
    String passwd;

    public loginUsuario() {
        this.passwd = "";
    }
    public boolean LoginUsuario(String Usuario, String Senha) throws ClassNotFoundException{
        try
      {
        String hostName = "kesleyserver";
        String dbName = "postodesaude";
        String user = "kesleyfortunato@kesleyserver";
        String password = "@dfd7!39";
        String url;
        url = "jdbc:sqlserver://kesleyserver.database.windows.net:1433;database=postodesaude;user=kesleyfortunato@kesleyserver;password={@dfd7!39};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = null;
        String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(url);
        String query = "SELECT * FROM autenticador WHERE usuario='" + Usuario + "'";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    passwd = rs.getString("senha");
                }   }
      }
      catch (SQLException e)
      {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
      }
    return passwd.equals(Senha);
    }
    
}
