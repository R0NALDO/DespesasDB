package controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//import periodos.Diario;
//import periodos.Mensal;
//import periodos.Periodo;
//import periodos.Mensal;
//consultar despesa
public class Read {
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
				ExtratoDiario();//mostra o total diário
				break;
			
			case "2":
				ExtratoMensal();//mostra o mes atual
				break;
				
			case "3":
				ExtratoConsolidado(); //mostra o periodo escolhido
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
	
		private static void ExtratoConsolidado() {
			// TODO Auto-generated method stub
			
		}
	
		private static void ExtratoMensal() {
			// TODO Auto-generated method stub
			
		}
	
		private static void ExtratoDiario() {
			// TODO Auto-generated method stub
			
		}
	}


