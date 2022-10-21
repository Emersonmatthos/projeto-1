package crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URSENAME = "root";

	private static final String PASSWORD = "emerson2994";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";
	
	public static Connection createConnectiontoMYSQL()throws
	Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Connection =
				DriverManager.getConnection(DATABASE_URL,URSENAME,PASSWORD);
		return Connection;
		}

	
	public static void main(String[] args) throws
	Exception{
		// TODO Auto-generated method stub
Connection con = createConnectiontoMYSQL();
if(con != null) {
	System.out.println("conexão obtida com sucesso!"+con);
	con.close();
	
}
	}

}
