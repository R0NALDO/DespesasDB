package primeiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal5 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		String op = "1";
		
		while (op !="0") {
			System.out.println("--- Sistema de Despesas ---");
			System.out.println("1- Nova despesa");
			System.out.println("2- Nova entrada no histórico");
			System.out.println("3- Totais");
			System.out.println("0- Sair");
			op = ler.next();
			
			switch (op) {
			case "1":
				
				break;
				
			case "2":
				System.out.println("Digite o tipo");
				String registro = ler.next();
				System.out.println("Digite o tipo");
				String data  = ler.next();
				System.out.println("Digite o tipo");
				String despesa = ler.next();
				System.out.println("Digite o tipo");
				
				break;
				
			case "0":
				System.exit(0);
				break;
				
			default:
				System.out.println("opção inválida, tente novamente");
				break;
			}	
		}
		
	}
	public static void conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String stgCnxo = "jdbc:mysql://localhost/DESPESAS?autoReconnect=true&useSSL=false";
		Connection conexao = DriverManager.getConnection(stgCnxo,"root", "");
		Statement comando = conexao.createStatement();
		String sql;
		
	}
}
