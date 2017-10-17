
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/ikea";
        String usuario = "postgres";
        String password = "mi1995guel";
        Connection con = DriverManager.getConnection(url, usuario, password);

        Statement statement = con.createStatement();

        String sentenciaSQL = "SELECT * FROM muebles";
        ResultSet rs = statement.executeQuery(sentenciaSQL);

        System.out.println(String.format("%-20s", "id") + String.format("%-20s", "nombre")
                + String.format("%-20s", "precio") + String.format("%-20s", "meterial")
                + String.format("%-20s","unidades"));
        System.out.println("------------------------------------"
                + "------------------------------"                
                + "------------------------------");

        while (rs.next()) {
            System.out.println(String.format("%-20s", rs.getString(1)) + 
                    String.format("%-20s",rs.getString(2)) +
                    String.format("%-20s", rs.getString(3)) + 
                    String.format("%-20s", rs.getString(4))+
                    String.format("%-20s", rs.getString(5)));
        }
        rs.close();
        con.close();
    }
}
