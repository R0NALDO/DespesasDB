package segundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Scanner;

public class Pessoa {
	
	String 	nome;
	String 	genero;
	float 	peso;
	int 	altura;
	int 	idade;
	int		cpf;
	String 	estadoCivil = "solteiro";
	
	//cria pessoa //duvida, o objeto fulano deixa de existir fora desse metodo?
	public static Pessoa CriarPessoa(String nome, String genero, int peso, int altura, int idade, int cpf) {
		Pessoa fulano 	= new Pessoa();
		fulano.nome 	= nome;
		fulano.genero 	= genero;
		fulano.peso 	= peso;
		fulano.altura 	= altura;
		fulano.idade 	= idade;
		fulano.cpf		= cpf;
		return fulano;
	}
	
	//faz o casamento da pessoa
	public static void Casar(Pessoa pessoa) {
		if (pessoa.estadoCivil.equals("solteiro")) { //duvida pq não se pode usar == aqui
			pessoa.estadoCivil = "casado";
			System.out.println(pessoa.nome+" agora é uma pessoa casada");
		}else {
			System.out.println("ok, essa pessoa é solteira");
		}
	}
	
	//mostra o estado civil da pessoa
	public static void MostrarEstadoCivil(Pessoa pessoa) {
		if (pessoa.estadoCivil != "solteiro") {
			System.out.println(pessoa.nome+" é uma pessoa casada");
		}else {
			System.out.println("ok, essa pessoa é solteira");
		}
	}
	
	//salva a pessoa no banco de dados, se já existe, atualiza
	public static void SalvarPessoa(Pessoa fulano) throws ClassNotFoundException, SQLException {
		boolean existe = false;
		ResultSet resultado =  Pessoa.RetornaResultSet("ronaldo", "PESSOA"); //nome do banco e da tabela //como ver o conteudo do resultset
		while (resultado.next()){
			String 	nome 	= resultado.getString("NOME"); //como imprimir a linha inteira de resultset // é correto declarar variaveis no meio?
			if (nome.equalsIgnoreCase(fulano.nome)) { //se nome && cpf for igual
				existe = true;
			}
		}	//atualiza no banco
			if (existe) {
				Class.forName(			"com.mysql.jdbc.Driver");
				String 		stgCnxo = 	"jdbc:mysql://localhost/ronaldo?autoReconnect=true&useSSL=false";
				Connection 	cnxo = DriverManager.getConnection(stgCnxo,"root", "");
				Statement 	cmdo = cnxo.createStatement();
				String 		sql = "UPDATE PESSOA SET "
						+ "NOME = '"+	fulano.nome+"', "
						+ "GENERO = '"+	fulano.genero+"', "
						+ "PESO = '"+	fulano.peso+"', "
						+ "ALTURA = '"+	fulano.altura+"', "
						+ "IDADE = '"+	fulano.idade+"', "
						+ "CPF = '"+	fulano.cpf+"', "
						+ "ESTADOCIVIL = '"+fulano.estadoCivil+"'";
				
				String 	msgm = (cmdo.execute(sql)) ? "não atualizou" : "ok, atualizou"; //duvida, pq dá false quando grava //System.out.println((cmdo.execute(sql)) ? "não gravou" : "ok, gravou");
				System.out.println(msgm);
				
				cnxo.close();
			//grava no banco
			}else {
				Class.forName(			"com.mysql.jdbc.Driver");
				String 		stgCnxo = 	"jdbc:mysql://localhost/ronaldo?autoReconnect=true&useSSL=false";
				Connection 	cnxo = DriverManager.getConnection(stgCnxo,"root", "");
				Statement 	cmdo = cnxo.createStatement();
				String 		sql = "INSERT INTO PESSOA (NOME, GENERO, PESO, ALTURA, IDADE, CPF, ESTADOCIVIL) VALUES ('"+	fulano.nome+"','"+
						fulano.genero+"',"+
						fulano.peso+","+
						fulano.altura+","+
						fulano.idade+","+
						fulano.cpf+",'"+
						fulano.estadoCivil+"');";
				String 	msgm = (cmdo.execute(sql)) ? "não gravou" : "ok, gravou"; //duvida, pq dá false quando grava //System.out.println((cmdo.execute(sql)) ? "não gravou" : "ok, gravou");
				System.out.println(msgm);
				
				cnxo.close();
			}
			//System.out.format(" %s \t %s, %s, %s, %s, %s, %s, %s \n", id, nome, genero, peso, altura, idade, cpf, etdoCvl); //duvida, o que faz o %s
		
		

//		System.out.println(sql);
//		ResultSet 	rstSt = cmdo.executeQuery(sql);
//		//lê as linhas
//		System.out.println("Exibindo ");
//			while (rstSt.next()){
//				int 	nome  = rstSt.getInt("ID_DESPESA");
//				String 	dcco = rstSt.getString("DESCRICAO");
//				System.out.format("\t %s, %s\n", nome, dcco);
//			}
//		rstSt.close();
//		if (resultset != null) {
//			gravar
//		} else {
//			alterar 
//		}
		
		//executa o comando no banco 
	}
	
	public static void ExcluirPessoa(String nome) throws ClassNotFoundException, SQLException {
			Class.forName(			"com.mysql.jdbc.Driver");
			String 		stgCnxo = 	"jdbc:mysql://localhost/ronaldo?autoReconnect=true&useSSL=false";
			Connection 	cnxo = DriverManager.getConnection(stgCnxo,"root", "");
			Statement 	cmdo = cnxo.createStatement();
			String 		sql  = "DELETE FROM PESSOA WHERE NOME = '"+ nome +"';";
			String 		msgm = (cmdo.execute(sql)) ? "não apagou" : "ok, apagou"; //duvida, pq dá false quando grava //System.out.println((cmdo.execute(sql)) ? "não gravou" : "ok, gravou");
			System.out.println(msgm);
			cnxo.close();
	}
	
	//consulta a partir do nome do banco e tabela
	public static ResultSet RetornaResultSet(String nomeDoBanco, String nomeDaTabela) throws ClassNotFoundException, SQLException {
		//String hora = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		Class.forName("com.mysql.jdbc.Driver");
		String 		stgCnxo = "jdbc:mysql://localhost/"+nomeDoBanco+"?autoReconnect=true&useSSL=false";
		Connection 	conexao = DriverManager.getConnection(stgCnxo, "root", "");
		Statement 	comando = conexao.createStatement();
		String 		sql 	= "SELECT * FROM "+nomeDaTabela+" ";
		ResultSet 	rstSt 	= comando.executeQuery(sql); //String 		sql = "SELECT * FROM TIPO_DESPESA WHERE CONVERT (date, GETDATE())";
		return rstSt; //tem o nome da ultima linha da consulta
	}
	
	//faz a consulta no bd e imprime
	public static void Imprimir() throws ClassNotFoundException, SQLException {
		ResultSet resultado =  Pessoa.RetornaResultSet("RONALDO", "PESSOA");
		System.out.println("Exibindo... \n id \t nome, genero, peso, altura, idade, cpf, estadocivil");
		while (resultado.next()){
			int 	id  	= resultado.getInt("ID"); //pq com getstring tbm funciona?
			String 	nome 	= resultado.getString("NOME");
			String 	genero 	= resultado.getString("GENERO");
			String 	peso 	= resultado.getString("PESO");
			String 	altura 	= resultado.getString("ALTURA");
			String 	idade 	= resultado.getString("IDADE");
			String 	cpf 	= resultado.getString("CPF");
			String 	etdoCvl	= resultado.getString("ESTADOCIVIL");
			System.out.format(" %s \t %s, %s, %s, %s, %s, %s, %s \n", id, nome, genero, peso, altura, idade, cpf, etdoCvl); //duvida, o que faz o %s
		}
	}
}

