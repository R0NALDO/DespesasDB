package primeiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import primeiro.*;

public class Principal4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
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
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String stgCnxo = "jdbc:mysql://localhost/DESPESAS?autoReconnect=true&useSSL=false";
					Connection conexao = DriverManager.getConnection(stgCnxo,"root", "");
					Statement comando = conexao.createStatement();
					String sql;
					while (!op.equalsIgnoreCase("n")) {
						System.out.println("Qual o tipo de despesa?");
						String despesa = ler.next();
						System.out.println("Qual a descricao?");
						String descricao = ler.next();
						sql = "INSERT INTO TIPO_DESPESA (ID_DESPESA,DESCRICAO) VALUES ('"+despesa+"','"+descricao+"');";
						comando.execute(sql);
						/*boolean rstdCmd = 
						System.out.println(rstdCmd);*/
						System.out.println("deseja gravar mais um? s/n");
						op = ler.next();
					}
					conexao.close();
					/*while(rslojas.next()){
						System.out.println(rslojas.getInt("id_loja")+""+rslojas.getString("nome_loja"));
					}*/
					
				} catch (ClassNotFoundException e) {
					System.out.println(" ------> excessão classe não encontrada");
					Thread.sleep(3000);
					System.exit(0);
					break;
				} catch (SQLException e) {
					System.out.println(" ------> excessão sql");
					Thread.sleep(3000);
					System.exit(0);
					break;
				}
				break;
				
			case "2": //consultar despesa
				//cria conexao
				Class.forName("com.mysql.jdbc.Driver");
				String stgCnxo = "jdbc:mysql://localhost/DESPESAS?autoReconnect=true&useSSL=false";
				Connection conexao = DriverManager.getConnection(stgCnxo,"root", "");
				Statement comando = conexao.createStatement();
				String sql;
				//pergunta pro usuario
				while (!op.equalsIgnoreCase("n")) {
					System.out.println("Qual a categoria?");
					String registro = ler.next();
					System.out.println("Qual a descricao?");
					String descricao = ler.next();
					sql = "SELECT '"+registro+"' FROM TIPO_DESPESA WHERE ID_DESPESA ='"+registro+"';";
					comando.execute(sql);
					/*boolean rstdCmd = 
					System.out.println(rstdCmd);*/
					System.out.println("deseja gravar mais um? s/n");
					op = ler.next();
				}
				conexao.close();
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
	public void conectar() {
		
	}

}
