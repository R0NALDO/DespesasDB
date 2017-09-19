package segundo;
//segundo exercicio
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String op = null;
		Scanner ler = new Scanner(System.in);
		
		while (op != "0") {
				System.out.println("\n--- Sistema de cadastro de pessoas no banco ---");
				System.out.println("1- Cadastrar pessoa");
				System.out.println("2- Mostrar pessoas");
				System.out.println("3- Excluir pessoas");
				System.out.println("0- Sair");
				
				op = ler.nextLine(); //ne segunda itera��o passa direto por aqui
				
				switch (op) {
				case "1": //cadastra ou atualiza se j� existir
					
					System.out.println("Digite o nome para salvar");
					String nomeC = ler.next();
					Pessoa fulano = Pessoa.CriarPessoa(nomeC, "M", 67, 167, 28, 567); //duvida, como usar float
					Pessoa.SalvarPessoa(fulano);
				break;
				
				case "2":
					Pessoa.Imprimir();
					break;
					
				case "3":
					System.out.println("Digite o nome para excluir");
					String nomeD = ler.next();
					Pessoa.ExcluirPessoa(nomeD);
					break;
					
				case "0":
					System.out.println("saindo...");
					System.exit(0);
					break;
					

				default:
					System.out.println("op��o inv�lida, tente novamente");
					break;
				}
			};

			ler.close();
	
	}

	public static void Backup() throws ClassNotFoundException, SQLException {
		//cria pessoas
		Pessoa fulano = Pessoa.CriarPessoa("Fabio", "M", 67, 167, 28, 567); //duvida, como usar float
		Pessoa.SalvarPessoa(fulano);
//		Pessoa.ExcluirPessoa("bob");
		Pessoa.Imprimir();
		Pular();
		System.out.println("");
//		Pessoa dani = CriarPessoa("Dani", "F", 55, 155, 26, 789);
//		Pessoa.SalvarPessoa(dani);
//		Mostrar(ronaldo);
//		PularUmaLinha();
//		
//		Pessoa.MostrarEstadoCivil(ronaldo);
//		PularUmaLinha();
//		
//		Pessoa.Casar(ronaldo);
//		PularUmaLinha();
		
//		Pessoa ana = CriarPessoa("Ana", "F", 62.5, 1.65, 27, 456);
//		Mostrar(ana);
//		PularUmaLinha();
		
		//Pessoa.SalvarPessoa(ronaldo);
		
//		PularUmaLinha();
//		Mostrar(ronaldo);
	}
	
	public static void Pular() {
		System.out.println("");
	}
}
	
	
	
	//mostrar
//	public static void Mostrar(Pessoa pessoa) { //duvida como mostrar com foreach
//		System.out.println("o nome da pessoa � \t"		+pessoa.nome);
//		System.out.println("o genero da pessoa � \t"	+pessoa.genero);
//		System.out.println("o peso da pessoa � \t"		+pessoa.peso);
//		System.out.println("a altura da pessoa � \t"	+pessoa.altura);
//		System.out.println("a idade da pessoa � \t"		+pessoa.idade);
//		System.out.println("o cpf da pessoa � \t"		+pessoa.cpf);
//		System.out.println("o estado civil  � \t"		+pessoa.estadoCivil);
//	}
	
	//pular
	
	//cria um nome para a pessoa
//	static int cont = 0;
//	public static String CriarNome() {
//		cont++;
//		String nome = "p"+cont;
//		return nome;
//	}

/*
2. Crie uma classe Pessoa com os seguintes atributos Nome, Genero, Peso, Altura e
Idade.
   Em uma classe para testes, Instancie dois objetos. Um homem e uma mulher. Defina
os dados de cada um dos objetos e imprima na tela
*/

/*
3. Altere a classe Pessoa: Crie propriedade �EstadoCivil� para a classe e um m�todo
que Casar, que altera a situa��o do EstadoCivil para �Casado�.

Lembre-se de que uma pessoa sempre �nasce� solteira.

Teste o funcionamento da classe

4. Altere o m�todo Casar da classe Pessoa para a seguinte l�gica:

Se a pessoa j� for casada o m�todo deve retornar um texto �Pessoa j� � casada�

Se n�o, o atributo estado civil � alterado e o m�todo retornar� �Ok�
 */

/*
DESAFIO

(Primeira parte)

Crie uma propriedade CPF para a classe pessoa;

Crie uma tabela de banco de dados para gravar dados de pessoas e um m�todo
Salvar que insira os dados do objeto pessoa nessa tabela.

(Segunda parte)

Altere o m�todo Salvar de forma que, se a pessoa n�o existir no banco de dados,
ser� inserida. Se a pessoa j� existir, seus dados ser�o atualizados.

*/

//perguntar se o objeto fulano s� exite dentro do m�todo (pra que n precise instanciar ronaldo)