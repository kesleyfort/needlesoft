package projetoprog;

import java.sql.*;

class CadastroPaciente {
    public void CadastrarPaciente(String Nome, String DataDeNascimento, String Sexo){
        Connection conn = null;
        Statement st;
        st = null;
        
     try{
        String url;
        url = "jdbc:sqlserver://kesleyserver.database.windows.net:1433;database=<NOME_BANCODEDADOS>;user=<NOMEDEUSUARIO>;password={<SENHADEUSUARIO};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection connection = null;
        String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(myDriver);
         conn = DriverManager.getConnection(url);
                try {
                connection = DriverManager.getConnection(url);
                
                // Prepared statement to update data
                String updateSql = "INSERT into agendamento Values (?,?,?, '', '')";

                try (PreparedStatement prep = connection.prepareStatement(updateSql)) {
                        prep.setString(1, Nome);
                        prep.setString(2, Sexo);
                        prep.setString(3, DataDeNascimento);

                        int count = prep.executeUpdate();
                        
                }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
     }catch(SQLException | ClassNotFoundException se){

     }
    finally{
        try{
           if(st!=null)
              conn.close();
        }
        catch(SQLException se){
        }
        try{
           if(conn!=null)
              conn.close();
        }
        catch(SQLException se){
        }
    }

    }
}
