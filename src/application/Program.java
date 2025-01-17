package application;

import db.DB;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {


        // programa para atualizar valores no banco de dados

        Connection conn = null;
        PreparedStatement st = null; // classe para criar os comandos SQL

        try {
            conn = DB.getConnection(); // iniciando a conexão

            // comando SQL
           st = conn.prepareStatement(
                   "UPDATE seller "
                   + "SET BaseSalary = BaseSalary + ? "
                   + "WHERE " // restrição da atualização
                   + "(DepartmentId = ?)");

           // valores que serão adicionados
           st.setDouble(1,200.0);
           st.setInt(2,4);

           int rowsAffected = st.executeUpdate(); // executando e vendo linhas que foram modificadas

            System.out.println("Pronto! Linhas modificadas: " + rowsAffected);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();

        }


    }
}
