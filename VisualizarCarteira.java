/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoprog;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.*;
import java.lang.String;
import java.util.Arrays;
/**
 *
 * @author kesley
 */
class VisualizarCarteira {
    public String[] VisualizarVacinas(String Nome){
        javax.swing.JTable TabelaBuscarCarteira;
        String VacinasTomadas = null;
        String DataDeNascimento = null;
        try
      {
        // create our mysql database connection
        String url;
        url = "jdbc:sqlserver://kesleyserver.database.windows.net:1433;database=<NOME_BANCODEDADOS>;user=<NOMEDEUSUARIO>;password={<SENHADEUSUARIO};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = null;
        String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(url);


        String query = "SELECT * FROM agendamento WHERE Nome='" + Nome + "'";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {

                    VacinasTomadas = rs.getString("VacinasTomadas");
                    DataDeNascimento = rs.getString("DataDeVacinacao");
                    // print the results

                }   }
      }
      catch (ClassNotFoundException | SQLException e)
      {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
      }
        String[] saida;

        /*for (data[i]: VacinasTomadas.split(Pattern.quote("."))) {
         System.out.println(data[]);*/
        saida = VacinasTomadas.split(Pattern.quote("."));
        return saida;
    }
    public String[] VisualizarDatas(String Nome){
       String VacinasTomadas = null;
        String DataDeVacina = null;
        try
      {
        // create our mysql database connection
        String url;
        url = "jdbc:sqlserver://kesleyserver.database.windows.net:1433;database=<NOME_BANCODEDADOS>;user=<NOMEDEUSUARIO>;password={<SENHADEUSUARIO};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = null;
        String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(url);


        String query = "SELECT * FROM agendamento WHERE Nome='" + Nome + "'";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {

                    VacinasTomadas = rs.getString("VacinasTomadas");
                    DataDeVacina = rs.getString("DataDeVacinacao");
                    // print the results

                }   }
      }
      catch (ClassNotFoundException | SQLException e)
      {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
      }
        String[] saida;

        
        saida = DataDeVacina.split(Pattern.quote("."));

        return saida;
    }


}
