/*  
Exercício prático - Java e Bancos de Dados
Neste exercício, você deve criar um aplicativo para registro de despesas domésticas.
Ele é composto dos seguintes recursos

1)Banco de dados para registro de despesas
- Tabela Tipos_de_Despesas(Id_Despesa, Descricao}
- Tabela Historico_Despesas{Id_Historico, Data, Id_Depesa, Valor_despesa}

A integridade referencial entre as tabelas deve permitir que uma despesa seja lançada mais de uma vez, inclusive no mesmo dia.

2) Aplicativo
- Menu com as opções
    Nova despesa (registra despesas na tabela Tipo_de_Despesas)
    Nova entrada no historico (registra um despesa realizada)
    Totais (esta opção deve abrir outro menu)
        Diario (mostrar todas as despesas, dia a dia)
        Mes atual (mostrar as depesas do mes atual)
        Historico consolidado (mostrar as despesas de acordo com um periodo informado pelo usuário)
 */
package controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Scanner ler = new Scanner(System.in);
		String op = "1";
		
		while (op !="0") {
			System.out.println("\n--- Sistema de Despesas ---");
			System.out.println("1- Inserir descricao \t (Nova despesa)");
			System.out.println("2- Inserir valor \t (Nova entrada no histórico)");
			System.out.println("3- Totais");
			System.out.println("0- Sair");
			op = ler.next();
			
			switch (op) {
			case "1"://inserir a descricao da despesa
				Create.SalvarDespesa(); 
				break;
				
			case "2": //inserir o valor da despesa
				Create.SalvarValor();
				break;
				
			case "3": //consultar despesas
				Read.MostrarTotal();
				break;
				
			case "0":
				System.out.println("saindo...");
				Thread.sleep(2000);
				System.exit(0);
				break;
				
			default:
				System.out.println("opção inválida, tente novamente");
				break;
			}	
		}
		ler.close();
	}
}

/*
 * Exercício prático - Java e Bancos de Dados
Neste exercício, você deve criar um aplicativo para registro de despesas domésticas.
Ele é composto dos seguintes recursos

1)Banco de dados para registro de despesas
- Tabela Tipos_de_Despesas(Id_Despesa, Descricao}
- Tabela Historico_Despesas{Id_Historico, Data, Id_Depesa, Valor_despesa}

A integridade referencial entre as tabelas deve permitir que uma despesa seja lançada mais de uma vez, inclusive no mesmo dia.

2) Aplicativo
- Menu com as opções
    Nova despesa (registra despesas na tabela Tipo_de_Despesas)
    Nova entrada no historico (registra um despesa realizada)
    Totais (esta opção deve abrir outro menu)
        Diario (mostrar todas as despesas, dia a dia)
        Mes atual (mostrar as depesas do mes atual)
        Historico consolidado (mostrar as despesas de acordo com um periodo informado pelo usuário)
        
 * "" é diferente de nulo?
 * como executar uma linha especifica, fora continue
 * selenium e watsapp, pq não envia mensagem?
 * nome igual para classe e metodo, precisa usar método?
 * como subir pro github
 * quantas execuçoes o processador faz por segundo? 1000?
*/
