package despesas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//import periodos.Diario;
//import periodos.Mensal;
//import periodos.Periodo;
//import periodos.Mensal;
//consultar despesa
public class Read {
	
	public static Read read;

	public static void MostrarTotal() throws ClassNotFoundException, SQLException {
		String 	hora = "\n"+new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
		String 	op = "";
		Scanner ler = new Scanner(System.in);
		while (!op.equalsIgnoreCase("n")) {
			System.out.println(hora);
			System.out.println("Qual total você gostaria?");
			System.out.println("1- Total Diário");
			System.out.println("2- Total Mensal");
			System.out.println("3- Total Consolidado");
			System.out.println("0- Voltar");
			op = ler.next();
			//chamadas
			switch (op) {
			case "1":
				read.ExtratoDiario();//mostra o total diário
				break;
			
			case "2":
				read.ExtratoMensal();//mostra o mes atual
				break;
				
			case "3":
				read.ExtratoConsolidado(); //mostra o periodo escolhido
				break;
				
			case "0":
				op = "n";
				break;
				
			default:
				System.out.println("opção inválida, tente novamente");
				break;
				}
			}
		}
	
		public void ExtratoDiario() throws ClassNotFoundException, SQLException {
			ResultSet rs =  RetornaResultSet("DESPESAS", "HISTORICO_DESPESA");
			
//			while (rs.next()) {
//				System.out.println(" "+rs.getString("VALOR_DESPESA")+rs.getString("DATAS"));
//			}
			
		}
	
		public void ExtratoMensal() throws ClassNotFoundException, SQLException {
			ResultSet rs =  RetornaResultSet("DESPESAS", "HISTORICO_DESPESA");
			
//			while (rs.next()) {
//				System.out.println(" "+rs.getString("VALOR_DESPESA")+rs.getString("DATAS"));
//			}
			
		}
	
		public void ExtratoConsolidado() throws ClassNotFoundException, SQLException {
			ResultSet rs =  RetornaResultSet("DESPESAS", "HISTORICO_DESPESA");
			
			while (rs.next()) {
				System.out.println(" "+rs.getString("VALOR_DESPESA")+rs.getString("DATAS"));
			}
			
		}
		
		//para ler do banco
		public ResultSet RetornaResultSet(String nomeDoBanco, String nomeDaTabela) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String stgCnxo = "jdbc:mysql://localhost/" + nomeDoBanco + "?autoReconnect=true&useSSL=false";
			Connection cnxo = DriverManager.getConnection(stgCnxo, "root", "");
			Statement cmdo = cnxo.createStatement();
			String sql = "SELECT * FROM "+nomeDaTabela+";";
			ResultSet rstst = cmdo.executeQuery(sql);
			return rstst;
		}
	}
























