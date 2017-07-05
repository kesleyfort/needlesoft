/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoprog;
import java.sql.*;
import java.util.Arrays;

/**
 *
 * @author kesley
 */
class AplicacaoVacinas {
   public boolean GravarAplicVacinas(String Nome, String DiaDeVacinacao, String VacinaTomada, int contador) throws SQLException{

       Connection conn = null;
       Statement stmt = null;

     //UPDATE Table SET Field=CONCAT(Field,'your extra html');
     String Values = "UPDATE agendamento SET VacinasTomadas = CONCAT(VacinasTomadas," + "'" + VacinaTomada + "'"+ ")" + " WHERE Nome = '" + Nome + "'";
     //String Values = "UPDATE agendamento SET VacinasTomadas = 'TesteVac' WHERE Nome = 'Kesley Fortunato'";
     String Values2  = "UPDATE agendamento SET DataDeVacinacao = CONCAT(DataDeVacinacao," + "'" + DiaDeVacinacao + "." + "'" + ")"  + " WHERE Nome = '" + Nome + "'";
     //System.out.println("" + Values);
     //System.out.println("" + Values2);
     try{
        String url;
        url = "jdbc:sqlserver://kesleyserver.database.windows.net:1433;database=<NOME_BANCODEDADOS>;user=<NOMEDEUSUARIO>;password={<SENHADEUSUARIO};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = null;
        String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(myDriver);
        connection = DriverManager.getConnection(url);
                

                // Prepared statement to update data
                String updateSql = "UPDATE agendamento SET VacinasTomadas = CONCAT(VacinasTomadas, ?) WHERE Nome = '"+ Nome + "'";
                        
                //System.out.println(updateSql);

                try (PreparedStatement prep = connection.prepareStatement(updateSql)) {
                        prep.setString(1, VacinaTomada);
                        int count = prep.executeUpdate();
                        
                }
                String updateSql2 =" UPDATE agendamento SET DataDeVacinacao = CONCAT(DataDeVacinacao, ?)"  + " WHERE Nome = '" + Nome + "'";
                for(int i=0; i<contador; i++){
                   try (PreparedStatement prep = connection.prepareStatement(updateSql2)) {
                        prep.setString(1, DiaDeVacinacao + ".");
                        int count = prep.executeUpdate();
                        
                } 
                }
        }
        catch (Exception e) {
                e.printStackTrace();
                return false;
        }
       return true;
    }
}
