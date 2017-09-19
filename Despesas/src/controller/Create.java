package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Create {
	//salva a descricao do produto no banco de dados
	public static void SalvarDespesa() throws ClassNotFoundException, SQLException {
			//prepara os objetos
		System.out.println(new SimpleDateFormat("dd-MM-yy").format(Calendar.getInstance().getTime()));
		Class.forName(		"com.mysql.jdbc.Driver");
		String 		stgCnxo = 	"jdbc:mysql://localhost/despesas?autoReconnect=true&useSSL=false";
		Connection 	cnxo = DriverManager.getConnection(stgCnxo,"root", "");
		Statement 	cmdo = cnxo.createStatement();
		Scanner 	ler = new Scanner(System.in);
		String 		sql = null;
		String 		op = "";
			//laço 
		while (!op.equalsIgnoreCase("n")) {
			System.out.println("Qual a descricao da despesa?");
			String 	dcco = ler.next();
			sql = "INSERT INTO TIPO_DESPESA (DESCRICAO) VALUES ('" + dcco + "');";
			String 	msgm = (cmdo.execute(sql)) ? "não gravou" : "ok, gravou"; //perguntar pq dá false quando grava
			System.out.println(msgm);
			System.out.println("deseja gravar mais um? s/n");
			op = ler.next();
		}
		cnxo.close();
	}
	//salva o valor do produto comprado no banco de dados
	public static void SalvarValor() throws ClassNotFoundException, SQLException {
		//prepara os objetos
		String hora = "\n"+new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		Class.forName("com.mysql.jdbc.Driver");
		String 		stgCnxo = "jdbc:mysql://localhost/despesas?autoReconnect=true&useSSL=false";
		Connection 	cnxo = DriverManager.getConnection(stgCnxo,"root", "");
		Statement 	cmdo = cnxo.createStatement();
		Scanner 	ler = new Scanner(System.in);
		String 		sql;
		String 		op = "";
		//laço 
		while (!op.equalsIgnoreCase("n")) {
			System.out.println("Qual o valor da despesa?");
			Double 	vlr = ler.nextDouble();
			sql = "INSERT INTO HISTORICO_DESPESA (VALOR_DESPESA, DATAS) VALUES ("+vlr+",'"+hora+"');";
			if (cmdo.execute(sql)) {
				System.out.println("não gravou"); //perguntar pq retorna false se gravou
			}else {
				System.out.println("ok, gravou");
			}
			System.out.println("deseja gravar mais um? s/n");
			op = ler.next();
		}
		cnxo.close();
	}
}
