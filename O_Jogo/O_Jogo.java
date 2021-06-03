import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class O_Jogo {

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-VARIAVÉIS GLOBAIS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	public static Scanner entrada = new Scanner(System.in);
	public static String opcao = "";
	public static int dificuldade = 0;
	public static String nomeJogador = "";
	public static int thread1 = 0;
	public static int thread2 = 0;
	public static int thread3 = 0;
	public static int[] status = { 100, 2 };
	public static int frases = 0;

	// CORES DO TEXTO
	public static final String RESET = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	// NEGRITO DO TEXTO 
	public static final String RESET_BOLD = "\u001B[0m";
	public static final String BOLD = "\u001B[1m";
	
	

	// CORES DO FUNDO DO TEXTO
	public static final String RESET_BACKGROUND = "\u001B[0m";
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-MAIN-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	public static void main(String[] args) {

		boolean cond = true;
		

		do {

			System.out.print(Tabula1(6, "---Menu---\n\n"));
			System.out.print(Tabula2(2, "[1] Intruções", 6, "[2] Jogar\n"));
			System.out.print(Tabula2(2, "[3] Créditos", 6, "[4] Sair\n"));

			String opcao_Menu = Option();

			switch (opcao_Menu) {

			case "1":
				Instruções();
				break;

			case "2":

				Jogar();
				Hist_1();
				//ExecutaTemplo1();
				Hist_2();
				ExecutaTemplo2();
				//Hist_3();
				ExecutaTemplo3(status);
				//Hist_3();
				
				
				break;

			case "3":
				Créditos();
				break;

			case "4":

				cond = false;
				break;

			default:

				System.out.print(RED + Tabula1(6, "Opção não é válida!\n\n") + RESET);

			}

		} while (cond);

	}

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-JOGO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DAS INTRUÇÕES
	public static void Instruções() {

		System.out.print("\n");
		Texto_Formatado("\nO objetivo do jogo é auxiliar o jogador em alguns conhecimentos da matemática."
				+ " Ao longo da jornada, serão apresentados conteúdos sobre a matéria em questão e "
				+ "apresentadas perguntas ao jogador. O mesmo deverá selecionar as opções válidas para que ele possa"
				+ " avançar no jogo e a cada questão, o jogador sofrerá um dano se errar, diminuindo assim sua vida."
				+ " O objetivo final do jogador, é avançar por todos os templos para derrotar o último chefe, sem perder toda a sua vida.");
		System.out.print("\n");
		Sair();

	}

	// PROCEDIMENTO PARA FAZER A 1º CHAMADA DO JOGO, PARA COLETAR AS INFORMAÇÕES DO
	// NOME DO JOGADOR, A DIFICULDADE DO JOGO E A HISTÓRIA INICIAL
	public static void Jogar() {

		Texto_Formatado(Tabula1(4, "---Escolha a sua dificuldade de jogo---\n\n")
				+ Tabula3(1, "[1] Fácil", 3, "[2] Normal", 3, "[3] Difícil"));

		boolean cond = true;

		do {

			String opcao_Menu = Option();
			switch (opcao_Menu) {

			case "1":
				dificuldade = 1;
				cond = false;
				break;

			case "2":
				dificuldade = 2;
				cond = false;
				break;

			case "3":
				dificuldade = 3;
				cond = false;
				break;

			default:
				System.out.print(RED + Tabula1(6, "Opção não é válida!\n\n") + RESET);

			}
		} while (cond);

		Texto_Formatado(Tabula1(4, "   ---Escolha o nome do seu jogador---"));
		nomeJogador = Option();

		boolean cond2 = true;
		do {

			Texto_Formatado(Tabula1(4,
					"---Você deseja que o nome do seu jogador seja " + RED + nomeJogador + RESET + " ?---\n\n")
					+ Tabula2(4, GREEN + "[S]" + RESET, 6, RED + "[N]" + RESET));
			String opcao_Menu = Option();

			switch (opcao_Menu.toUpperCase()) {
			case "S":
				cond2 = false;
				break;
			case "N":
				Texto_Formatado(Tabula1(4, "---Escolha o nome do seu jogador---"));
				nomeJogador = Option();
				break;
			default:
				System.out.print(RED + Tabula1(6, "Opção não é válida!\n\n") + RESET);
			}
		} while (cond2);

	}

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DOS CRÉDITOS
	public static void Créditos() {

		System.out.print("\n");
		Texto_Formatado(Tabula3(2,"\nGustavo Tozeti",2,"Matheus Cavalcanti",2,"Renan Kesper"));
		System.out.print("\n");
		Sair();

	}

	
	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-HISTÓRIA-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	
	// PRIMEIRA NARRATIVA DO JOGO
	public static void Hist_1() {

		System.out.print("\n");
		
		Texto_Formatado(
				
				
				Dialogo("Narrador",WHITE) + "\n - Aos escombros, uma leve página, parecida de um diário, pousa sobre o rosto de "+ nomeJogador +". Aos sustos, " + nomeJogador +" acorda e começa a ler a página." +
				
				Dialogo(nomeJogador,WHITE)+ GREEN
				+ "\n - \"Reza a lenda que Ariandre era um lugar próspero, cheio de magia e encanto, onde todos os seres viviam em harmonia e em paz. Um lugar tão belo,"					
				+ " que a matemática era a base de força para grandes magos. Mas isso é claro, antes do grande acontecimento. . .Ninguém sabe ao certo, nem ao menos como,"				
				+ " mas naquela tarde esse lugar tão calmo e pleno, foi reduzido a cinzas e escombros, uma enorme escuridão pairou pelos céus e tomou Ariandre por inteiro "			
				+ "e com um simples clarão. . .tudo foi destruído. Após momentos agoniantes, enfim o motivo disso tudo. . . sim, ele que era apenas uma fábula de centenas de "			
				+ "anos, de contos muito antigos, enfim ressurgiu. . . Ancelot tinha despertado. O grande rei demônio estava presente novamente, "			
				+ "para aprisionar toda a matemática de Ariandre e ser o detentor de toda a magia. Já se passaram alguns meses depois disso tudo, mas agora espero "					
				+ "ter forças para enfrentá-lo, mas a cada dia que se passa nessas catedrais do abismo perco mais e mais da minha sanidade. Talvez eu seja a última esperança "			
				+ "de Ariandre, mas caso alguém esteja lendo isso, significa que Ancelot venceu e Ariandre para sempre estará sob o seu domínio.\"" 									
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Mas. . . mas como? Meses? Estava tudo certo, ele estava em minhas mãos, como foi tudo isso desmoronar. Minha "					
				+ "cabeça dói, são memórias que me vem, mas o que será que aconteceu? Por que eu estou nas catedrais e porque Ariandre está destruída? Será isso um sonho?"
				+ " Eu preciso descobrir o que aconteceu, mas me sinto estranho. Parece que não tenho mais meus poderes. Será que eu consigo canalizar algo??"
				
				+ Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+ " tenta utilizar, uma de suas magias vinda através dos poderes da matemática, mas sem sucesso! "
				+ "E como em um turbilhão de memórias, "+nomeJogador+" começa a se lembrar daquele fatídico dia.\n\n"
						
				+Tabula1(4,"Alguns meses antes...") 
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Finalmente, depois de anos de estudos e cálculos, finalmente irei despertar Ancelot e enfim obter o seu"
				+ " poder supremo."
				
				+ Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+ " por mais que fosse extremamente forte, jamais saberia que o terrível Ancelot portava de uma maldição, que "
				+ "quem o invoca-se traria destruição ao seu mundo. Ao passo em que o ritual de invocação se iniciava, um grande portal cheio de trevas se abriu no chão e dele "
				+ "saía o fim dos tempos."
				
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - Finalmente livre!!"	
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Jamais Ancelot, eu "+ nomeJogador +" sou o ser mais supremo de toda Ariandre, você não é pareo para os meus poderes. Apenas te "
				+ "invoquei para obter toda sua fonte de poder e assim te derrotá-lo para sempre. "
				
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - Tolo, você não é a primeira pessoa a tentar isso. Vocês todos tentam, mas todos esquecem da maldição!!"	
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Maldição? Que maldição?!"
				
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - Pelo visto, você não está preparado HAHAHAHAH. Mas talvez o que eu faça aqui, sirva de lição para você."
				
				+ Dialogo("Narrador",WHITE) + "\n - E com uma enorme força e magia, que surpreendia até "+nomeJogador+", Ancelot conseguiu drenar todos os seus poderes. Com vários feixes de luz, "
				+ nomeJogador+" via seus poderes se esvaindo ao longo de si."
				
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - "+nomeJogador+", você me parece interessante. Irei espalhar esses seus poderes nas mais profundas terras de Ariandre e caso você sobreviva, terá seus "
				+ "poderes de volta para me enfrentar."
				
				+ Dialogo("Narrador",WHITE) + "\n - Com um imenso clarão, tudo ficou em silêncio. Até agora...\n\n"
				
				+Tabula1(4,"Atualmente...")
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Droga! Preciso recuperar meus poderes e derrotar Ancelot. Mas onde estou?"
				
				+ Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" olha em volta e se depara com escombros e ruínas. Mas começa a perceber que existem símbolos escritos nas paredes que são familiares. "
				+ "Estes símbolos remetem a algumas descrições dos templos da perdição das catedrais. É de grande espanto, pois "+nomeJogador+" ao reconhecer às escritas, lembrou que os templos eram mitos da terra "
				+ "antiga e que eram locais responsáveis por um grande armazenamento de magia."
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Se ele disse que meus poderes estão nas mais profundas terras de Ariandre, então só podem estar espalhados entre os três templos daqui. "
				+ "Preciso ir em frente!"
				
				+Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+ " adentra no templo das "+BOLD+"Equações de 1º Grau"+RESET_BOLD+", um lugar que lhe faz relembrar dos seus inícios de treinamento de mago. "
				+ "Tanto é, que esse conhecimento era a base dos seus grandiosos poderes."
						
				+ Dialogo("Narrador",WHITE) + "\n - Os templos possuem feitiços incríveis e fazem com quem adentrar ao local tenha a sabedoria para conquistar o poder armazenado nele. E não foi diferente com esse templo."
				+ nomeJogador+" após passar por um portal mágico do templo, teve uma viagem mística até onde estavam os desafios para recuperar seu poder. Dentro dessa viagem, uma voz desconhecida lhe passou os seguintes "
				+ "ensinamentos…"
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Olá "+ nomeJogador+", que bom te ver aqui!!"
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Mas quem é você?"
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Não se preocupe, sou apenas um ajudante de Ariandre e estou aqui para ajudar em sua jornada. Não temos muito tempo a frente então serei o mais rápido possível, "
				+ "isso lhe guiará nos seus próximos desafios daqui para frente."
				
				+ Dialogo("Narrador",WHITE) + "\n - E parecendo uma voz familiar, "+ nomeJogador+" escutou os ensinamentos que a voz desconhecida tinha a oferecer."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - O poder deste templo são às"+BOLD(" Equações de 1º Grau",CYAN)+", elas serão a base para sua fonte de poder. Para derrotar os desafios à frente, você irá precisar dos "
				+ "conhecimentos básicos a fim de quebrar os feitiços que serão lançados a ti. Então preste muita atenção..."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - As equações de primeiro grau são sentenças matemáticas que estabelecem relações de igualdade entre termos conhecidos e desconhecidos, "
				+ "representadas sob a forma: "+BOLD("ax+b = 0",CYAN)+". Donde "+BOLD("a",CYAN)+" e "+BOLD("b",CYAN)+" são números reais, sendo "+BOLD("a",CYAN)+" um valor diferente de zero "+BOLD("(a != 0)",CYAN)+" e "+BOLD("x ",CYAN)+ "representa o "
				+ "valor desconhecido. O valor desconhecido é chamado de "+BOLD("incógnita",CYAN)+" que significa \"termo a determinar\". As equações do 1º grau podem apresentar "+BOLD("uma",CYAN)+" ou "+BOLD("mais",CYAN)+" incógnitas."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - O objetivo de resolver uma equação de primeiro grau é "+BOLD("descobrir o valor desconhecido",CYAN)+", ou seja, encontrar o valor da incógnita que "+BOLD("torna a igualdade verdadeira",CYAN)+". Para isso, "
				+ "deve-se "+BOLD("isolar os elementos desconhecidos em um dos lados do sinal de igual e os valores constantes do outro lado",CYAN)+". Contudo, é importante observar que a mudança de posição desses elementos "+BOLD("deve ser feita de forma que a igualdade "
				+ "continue sendo verdadeira",CYAN)+". Quando um termo da equação mudar de lado do sinal de igual, devemos inverter a operação. Assim, se tiver multiplicando, passará dividindo, se tiver somando, passará subtraindo e vice-versa."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Agora você está pronto para o caminho em frente. Espero te ver logo, adeus…"
				
				+ Dialogo("Narrador",WHITE) + "\n - E com essa despedida, "+ nomeJogador+" saiu de sua viagem mística e já estava em apuros."
				
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - Parece que você sobreviveu depois de tudo aquilo e ainda conseguiu chegar até aqui. Você não terá seu poder de volta tão fácil HAHAHHA. Veremos se você é realmente capaz de enfrentar meus 3 feitiços.");
				
								
				
				
		
		System.out.print("\n");

	}

	public static void Hist_2(){
		
		System.out.print("\n");
		
		Texto_Formatado(
				
				Dialogo("Ancelot",WHITE) +  RED + "\n - Impossível, como você conseguiu ? Isso ainda não acabou, nós iremos nos encontrar novamente."
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Onde você estiver, eu estarei lá para te derrotar!"
				
				+ Dialogo("Narrador",WHITE) + "\n - E diante de um clarão Ancelot, desapareceu… Mas no local da batalha grandiosa, uma enorme chama, surgia no meio da arena. Era o poder perdido de "+nomeJogador+",  que ao se aproximar, pode absorver novamente seu poder."
				
				+ Dialogo(nomeJogador,WHITE) +  GREEN + "\n - Como é bom ter meus poderes de volta!"
				
				+ Dialogo("Narrador",WHITE) + "\n - Com a grande primeira batalha travada, "+nomeJogador+" continuou em sua jornada para o próximo templo adentrando no próximo portal."
						
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Olá "+ nomeJogador+", que bom que você sobreviveu!!"
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Precisamos continuar sua batalha."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - O poder deste templo são às"+BOLD(" Equações de 2º Grau",CYAN)+", elas serão o fortalecimento do seu poder. Para derrotar os desafios à frente, você irá precisar dos "
				+ "conhecimentos básicos a fim de quebrar os feitiços que serão lançados a ti. Então preste muita atenção..."									
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - As equações de segundo grau são caracterizadas por um "+BOLD("polinômio de grau 2",CYAN)+", ou seja, um polinômio do tipo "+BOLD("ax² + bx + c",CYAN)+", em que a, b e c "+BOLD("são números reais",CYAN)+". Ao resolvermos uma equação de grau 2, estamos "
				+ "interessados em "+BOLD("encontrar valores para a incógnita x",CYAN)+" que torne o "+BOLD("valor da expressão igual a 0",CYAN)+", que são chamadas de raízes, isto é, "+BOLD("ax² + bx + c = 0",CYAN)+"."
						
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - A equação do 2º grau é classificada como "+BOLD("completa",CYAN)+" quando todos os coeficientes são diferentes de 0, ou seja, a != 0, b != 0 e c != 0. A equação do 2º grau é classificada como "+BOLD("incompleta",CYAN)+" quando o valor dos coeficientes b ou c são iguais a 0, isto é, b = 0 ou c = 0."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - "+BOLD("Para solucionar equações do tipo ax² + c = 0",CYAN)+", o método para determinar a solução de equações incompletas que possuem b=0 consiste em isolar a incógnita x."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - "+BOLD("Para solucionar equações do tipo ax² + bx = 0",CYAN)+", o método para determinar as possíveis soluções de uma equação com c =0, consiste em utilizar a fatoração por evidência."
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - "+BOLD("Para solucionar equações completas",CYAN)+", o método conhecido como método de Bhaskara ou fórmula de Bhaskara aponta que as raízes de uma equação do 2º grau do tipo ax² + bx + c = 0 é dada pela seguinte relação:"
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Raíz 1 = "+BOLD(" (-b + (Raiz Quadrada(Delta)) / 2.a | Delta = b² - 4.a.c",CYAN) 
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Raíz 2 = "+BOLD(" (-b - (Raiz Quadrada(Delta)) / 2.a | Delta = b² - 4.a.c",CYAN) 
				
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Quando o "+BOLD("Delta for positivo",CYAN)+": existem duas soluções para a equação. Quando o "+BOLD("Delta for igual a zero",CYAN)+": as soluções da equação são repetidas."
				+ " Quando o "+BOLD("Delta for negativo",CYAN)+": não admite solução real."
										
				+ Dialogo("Voz Desconhecida",WHITE) + CYAN + "\n - Agora você está pronto para o caminho em frente. Espero que consiga vencer novamente!"
				
				+ Dialogo("Narrador",WHITE) + "\n - E com essa despedida, "+ nomeJogador+" saiu de sua viagem mística e já estava em apuros de novo."
							
				+ Dialogo("Ancelot",WHITE) +  RED + "\n - Eu me descuidei da primeira vez, mas dessa vez será diferente. Você será derrotado através desses meus novos 3 feitiços."
				
				
				
				
				);
	
	}	
	
	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FERRAMENTAS DE TEXTO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO CRIADO PARA FORMATAR QUALQUER TEXTO, PARA PADRONIZAR O LAYOUT DA
	// MENSAGEM COM BASE EM UM VALOR PRÉ DETERMINADO
	public static void Texto_Formatado(String frase) {

		String texto = frase;
		String[] palavras = texto.split(" ");

		int contadorQntLetras = 0;
		int limiteLinha = 170;
		

		for (int i = 0; i < limiteLinha; i++) {
			System.out.print(RED + "=" + RESET);
		}
		System.out.print("\n");

		for (String palavra : palavras) {

			if (contadorQntLetras + palavra.length() >= limiteLinha) {
				contadorQntLetras = 0;
				System.out.print("\n");
			}

			System.out.print(palavra + " ");
			Timer2();
			if (palavra.length()>18){
				contadorQntLetras = 0;
			}
			else {
			contadorQntLetras += palavra.length() + 1;
			
			
			}
			
			}
		System.out.println("\n");

		for (int i = 0; i < limiteLinha; i++) {
			System.out.print(RED + "=" + RESET);
		}
		System.out.println("\n");

	}

	// PROCEDIMENTOS CRIADOS PARA TABULAR QUALQUER TEXTO, PARA PADRONIZAR O LAYOUT DA
	// MENSAGEM
	public static String Tabula1(int t, String s) {

		String tab = "\t";
		String frase = "";
		for (int i = 0; i <= t; i++) {
			frase += tab;
		}
		frase += s;

		return frase;
	}

	public static String Tabula2(int t, String s, int tt, String ss) {

		String tab = "\t";
		String frase = "";

		for (int i = 0; i <= t; i++) {
			frase += tab;
		}
		frase += s;
		for (int i = 0; i <= tt; i++) {
			frase += tab;
		}
		frase += ss;
		return frase;
	}

	public static String Tabula3(int t, String s, int tt, String ss, int ttt, String sss) {

		String tab = "\t";
		String frase = "";

		for (int i = 0; i <= t; i++) {
			frase += tab;
		}
		frase += s;
		for (int i = 0; i <= tt; i++) {
			frase += tab;
		}
		frase += ss;
		for (int i = 0; i <= ttt; i++) {
			frase += tab;
		}
		frase += sss;
		return frase;
	}

	// PROCEDIMENTOS CRIADO PARA PADRONIZAR OS DIÁLOGOS
	public static String Dialogo(String Nome, String Cor) {
		String texto = "\n\n" + BLACK_BACKGROUND + Cor +Nome+ RESET + RESET_BACKGROUND;
		return texto;
		}
	
	public static String BOLD(String frase, String Cor) {
		String texto = RESET + BOLD + frase + RESET_BOLD + Cor;
		return texto;
	}
	
	// PROCEDIMENTOS CRIADO PARA PRINTAR A MENSAGEM ANTES DO BOSS
	static void FormataTexto1(String frase) {

		String[] palavra = frase.split(" ");

		for (String each : palavra) {
			System.out.print(each + " ");
			Timer2();
		}
	}

	// PROCEDIMENTOS CRIADO PARA PRINTAR A MENSAGEM DE GAME OVER
	static void FormataTexto2(String frase) {

		String[] palavra = frase.split(" ");

		for (String each : palavra) {
			System.out.print(each);
			Timer2();
		}

		System.out.print(" ");
	}
	
	// PROCEDIMENTOS CRIADO PARA ARMAZENAR A COLEÇÃO DE FRASES PARA ACERTOS
	static void Vitoria_Frase () {
		
		ArrayList<String> vitoria = new ArrayList();
		vitoria.add("Acertou novamente, droga droga droga...\n");
		vitoria.add("Vejo que acertou mais uma...\n");
		vitoria.add("TUDO QUE EU JOGO PARA VOCÊ, ESTÁ CONSEGUINDO RESOLVER... Bom...você é bom, faz tempo que não uso todo o meu poder," 
		+ "agora você conhecerá a minha fúria, dúvido que irá conseguir responder as próximas questões...\n");
		vitoria.add("Aaaah, sim, vejo que você foi capaz de passar pelo meu desafio! Maravilhoso, vamos apimentar um pouco mais as coisas\n");
		
		Collections.shuffle(vitoria);
		Collections.shuffle(vitoria);
		Collections.shuffle(vitoria);
		
		
		System.out.print(Dialogo("Ancelot",WHITE) +  RED + " - " + vitoria.get(0) + RESET + Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" concluiu mais um desafio! E por uma benção divina recebeu mais uma potion!!\n");
		
	}
	
	// PROCEDIMENTOS CRIADO PARA ARMAZENAR A COLEÇÃO DE FRASES PARA ERROS
	static void Derrota_Frase () {
		
		ArrayList<String> derrota = new ArrayList();
		derrota.add("Você não conseguirá prosseguir nem que tente mil vezes.\n");
		derrota.add("Você não é capaz de seguir em frente\n");
		
		Collections.shuffle(derrota);
		Collections.shuffle(derrota);
		
		System.out.println(Dialogo("Ancelot",WHITE) +  RED + " - " + derrota.get(0) + RESET);
	}

	// FUNÇÃO CRIADA PARA ARMAZENAR A COLEÇÃO DE FRASES PARA DESAFIOS
	static String Desafio_Frase () {
			
			ArrayList<String> desafio = new ArrayList();
			desafio.add("rationem esse accelerationis");
			desafio.add("processus arithmetica");
			desafio.add("mindsets parallel");
			desafio.add("periculi sensus");
			desafio.add("sensus motus");
			desafio.add("ignis magicae");
			desafio.add("ventum magicae");
			desafio.add("impulsum resistentiam");
			desafio.add("viribus");
			desafio.add("title heros");
			
			String frase =  RED + desafio.get(frases) + RESET;
			
			Texto_Formatado(Tabula1(6,frase)+"\n" + Dialogo("Narrador",WHITE) + "\n - Você recebe essa magia. Com o seu conhecimento, é capaz"
			+ " de absorvê-la e consegue revidar caso acerte o encanto!");
			
			return frase;
		}
	
	// PROCEDIMENTOS CRIADO PARA MOSTRAR MENSAGEM DE ACORDO COM A VIDA 
	// DO PERSONAGEM
	static void AcertouResposta(int healthPoints) {
		
		String frase_A = "";
		
		if (healthPoints >= 30 && healthPoints < 65) {
			frase_A = "\nParecia que tinha sido um grande desafio para "+nomeJogador+".";
		}
		if (healthPoints < 30) {
			frase_A = "\nTinha sido por pouco, mas "+nomeJogador+" conseguiu passar!";
		}
		
		String frase =  Dialogo("Narrador",WHITE) + "\n - A resposta estava...\n...\n...\n\n"+GREEN + "Certa :D\n" + RESET + frase_A ;
		Texto_Formatado(frase);
	
		Vitoria_Frase();

		

		
	}
	
	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FERRAMENTAS DE INPUT-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// FUNÇÃO CRIADA PARA RETONAR UMA OPÇÃO DESEJADA DO USUÁRIO
	public static String Option() {
		System.out.print(BLACK_BACKGROUND + WHITE + "\n***Digite sua opção:" + RESET + RESET_BACKGROUND + " ");
		opcao = entrada.next();
		System.out.print("\n");
		return opcao;
	}

	// PROCEDIMENTO CRIADO PARA SAIR DE UMA OPÇÃO DE UM MENU
	public static void Sair() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPressione a tecla ENTER para voltar!\n");
		sc.nextLine();
		System.out.println(" ");
	}

	
	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FERRAMENTAS DO JOGO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// FUNÇÃO CRIADA PARA CALCULAR O DANO
	static int DanoRespostaErrada(int healthPoints) {
		Random dado = new Random();
		int jogada;
		
		int vida  = healthPoints;
		String frase_A = "";
		
		jogada = dado.nextInt(20) + 1;
		String jogada_ = String.valueOf(jogada);
		
		if (jogada <= 5) {
			
			String frase =  Dialogo("Narrador",WHITE) + "\n - Parece que o feitiço era fraco e "+nomeJogador+" conseguiu se esquivar do dano.\n";
			Texto_Formatado(frase);
			
		}
		else 
		{
			
			if (jogada > 5 && jogada <= 10) {
			frase_A = "\nSorte que o feitiço não acertou em cheio, mas acertou de raspão.\n";
			healthPoints = healthPoints - (10 + (5 * dificuldade));
		} else if (jogada > 10 && jogada <= 17) {
			frase_A = "\nEsse feitiço era forte, mas não muito poderoso.\n";
			healthPoints = healthPoints - (20 + (5 * dificuldade));
		}
		else {
			frase_A = "\nEsse feitiço tinha acertado em cheio!!.\n";
			healthPoints = healthPoints - (30 + (5 * dificuldade));
		}
			
			if (healthPoints > 0) {
			vida = vida - healthPoints;
			String vida_ = String.valueOf(vida);
			
			String frase =  Dialogo("Narrador",WHITE) + "\n - A resposta estava...\n...\n...\n\n"+RED + "Errada :(\n" + RESET + "\n**\t"+nomeJogador+
			" tinha recebido "+vida_+" de dano\t **\n\n"+frase_A+"";
			
				
			Texto_Formatado(frase);

				
			Derrota_Frase();
			}
			
		}
		
		
		frases--;
		return healthPoints;
	}

	// PROCEDIMENTO CRIADO PARA DAR GAME-OVER AO JOGO
	static void GameOver() {
		System.out.println("Seu HP chegou a 0");
		frases = 0;

		String game = "G A M E";
		String over = "O V E R";

		FormataTexto2(game);
		FormataTexto2(over);

		System.out.println("\n");
	}

	// FUNÇÃO CRIADA PARA USAR POTIONS
	static int[] UsePotion(int healthPoints, int qntPotions) {

		boolean condicao = true;
		char opcao = 0;
		int[] status = new int[2];

		do {

			Texto_Formatado(Tabula1(5,"Você tem certeza que quer usar uma potion?\n")+"\n" +Tabula3(4,GREEN + "[S]" + RESET,3 ," ou ",2, RED + "[N]\n" + RESET));

			opcao = Option().toUpperCase().charAt(0);

			switch (opcao) {
			case 'S':
				healthPoints = healthPoints + 10;
				qntPotions--;

				if (healthPoints > 100) {
					do {
						healthPoints--;
					} while (healthPoints != 100);
				}

				condicao = false;
				break;
			case 'N':

				condicao = false;
				break;

			default:
				System.out.print(RED + Tabula1(6, "Opção não é válida!\n\n") + RESET);
			}

		} while (condicao);

		status[0] = healthPoints;
		status[1] = qntPotions;
		
		O_Jogo.status[0] = status[0] ;
		O_Jogo.status[1] =status[1] ;

		return status;
	}

	// PROCEDIMENTOS DE TEMPO PARA IMPRIMIR MENSAGENS
	static void Timer() {
		try {
			Thread.sleep(thread1);
		} catch (Exception e) {

		}
	}

	static void Timer2() {
		try {
			Thread.sleep(thread2);
		} catch (Exception e) {

		}
	}

	static void Timer3() {
		try {
			Thread.sleep(thread3);
		} catch (Exception e) {

		}
	}

	// FUNÇÃO CRIADA PARA GERAR AS PERGUNTAS AO JOGADOR
	static int[] ProcessoAlternativas_Geral(String[] opcoes, int[] status, String respostaCerta, String enunciado) {
		// Area para declarar variaveis
		Scanner sc = new Scanner(System.in);
		String resposta;
		boolean condicao = true;

		

		////////////////////////////////////////////////////////////////////////
		// Area para processo de alternativas
		do {

			
			if (status[0] <= 0) {
				GameOver();
				condicao = false;
			}
			
			else {
				
				Desafio_Frase();
				frases++;
				
				System.out.printf(enunciado+"\n");
				Timer2();
				System.out.printf("[ A ] %S\n", opcoes[0]);
				Timer2();
				System.out.printf("[ B ] %S\n", opcoes[1]);
				Timer2();
				System.out.printf("[ C ] %S\n", opcoes[2]);
				Timer2();
				System.out.printf("[ D ] %S\n", opcoes[3]);
				Timer2();
				System.out.printf("[ E ] %S\n\n", opcoes[4]);
				Timer2();
				System.out.printf("[ P ] Caso queira utilizar uma potion.\n\nHP atual: "+GREEN+"%d"+RESET+"\t| Potions: "+RED+"%d\n"+RESET, status[0],status[1]);
				Timer2();
				System.out.println("Resposta certa: " + respostaCerta.toUpperCase());
				Timer2();
				resposta = Option().toUpperCase();

			switch (resposta.charAt(0)) {
			case 'A':
				if (opcoes[0].equals(respostaCerta)) {
					AcertouResposta(status[0]);
					condicao = false;
				} else {
					status[0] = DanoRespostaErrada(status[0]);
					if (status[0] <= 0) {
						GameOver();
						condicao = false;
					}
				}
				break;
			case 'B':
				if (opcoes[1].equals(respostaCerta)) {
					AcertouResposta(status[0]);
					condicao = false;
				} else {
					status[0] = DanoRespostaErrada(status[0]);
					if (status[0] <= 0) {
						GameOver();
						condicao = false;
					}
				}
				break;

			case 'C':
				if (opcoes[2].equals(respostaCerta)) {
					AcertouResposta(status[0]);
					condicao = false;
				} else {
					status[0] = DanoRespostaErrada(status[0]);
					if (status[0] <= 0) {
						GameOver();
						condicao = false;
					}
				}
				break;
			case 'D':
				if (opcoes[3].equals(respostaCerta)) {
					AcertouResposta(status[0]);
					condicao = false;
				} else {
					status[0] = DanoRespostaErrada(status[0]);
					if (status[0] <= 0) {
						GameOver();
						condicao = false;
					}
				}
				break;
			case 'E':
				if (opcoes[4].equals(respostaCerta)) {
					AcertouResposta(status[0]);
					condicao = false;
				} else {
					status[0] = DanoRespostaErrada(status[0]);
					if (status[0] <= 0) {
						GameOver();
						condicao = false;
					}
				}
				
				break;
			case 'P':
				
				if ( status[1] == 0 ) {
					
					System.out.print(RED + Tabula1(7, "Você não tem potions!\n\n") + RESET);
									
				}
				
				else{
					status = UsePotion(status[0], status[1]);
				}
				frases--;
					break;
				
			default:
				System.out.print(RED + Tabula1(6, "Opção não é válida!\n\n") + RESET);
			}
			}
		} while (condicao);

		return status;
	}

		
// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-TEMPLOS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// TEMPLO 3
	static int[] ExecutaTemplo3(int[] status) {
		Scanner sc = new Scanner(System.in);
		boolean condicao = true,condicao2 = true;
do {
		do {
			status = Desafio1_Templo3(status);
			
			if (status[0] > 0) {
										
						
				status[1]++;			

			} else {
				Texto_Formatado(Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" infelizmente foi derrotado!!");
				status[0] = 100;
				break;
			}	
		
		System.out.print("\nAperte ENTER para começar o próximo Desafio");
		sc.nextLine();
		System.out.println(" ");

		
			status = Desafio2_Templo3(status);
			
			
			if (status[0] > 0) {
				
				
				status[1]++;			

			} else {
				Texto_Formatado(Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" infelizmente foi derrotado!!");
				status[0] = 100;
				break;
			}
		

		System.out.print("\nAperte ENTER para começar o último Desafio");
		sc.nextLine();
		System.out.println(" ");

	
			status = Desafio3_Templo3(status);
			
			if (status[0] > 0) {
				
				
				status[1]++;

				condicao = false;
				condicao2 = false;
				
			} else {
				
				Texto_Formatado(Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" infelizmente foi derrotado!!");
				status[0] = 100;
				break;
			
			}
		} while (condicao);
	}while (condicao2);

		Timer();
		Texto_Formatado(Dialogo("Narrador",WHITE) + "\n - "+nomeJogador+" concluiu o Templo das Conversões. Agora estava o momento para o final");
		Timer2();
		FormataTexto1("Você está preparado para o ");
		FormataTexto2("F I N A L ");
		FormataTexto2("B O S S ");
		FormataTexto2("? ? ?");
		System.out.println("\n");
		return status;
	}

	// DESAFIO É CONVERTER UM NÚMERO QUE ESTÁ EM UMA BASE PARA OUTRA
	static int[] Desafio1_Templo3(int[] status) {
		int baseInicial, baseConversao;
		String respostaCerta;

		String[] numeroInicial = new String[1];
		String[] opcoes = new String[5];
		ArrayList<String> respostaErrada = new ArrayList();

		////////////////////////////////////////////////////////////////////////
		// Area para preparar os numeros
		baseInicial = DeterminaBase_Templo3(); // Determinando a base standard

		do {
			baseConversao = DeterminaBase_Templo3(); // Determinando a base de conversao
		} while (baseConversao == baseInicial);

		numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); // Determinando o numero standard

		respostaCerta = DeterminaNumeroConv_Templo3(numeroInicial, baseInicial, baseConversao); // Determinando o numero
																								// de conversao (certo)

		respostaErrada.add(respostaCerta); // Adicionando a resposta certa nas opcoes

		for (int i = 0; i < 4; i++) {
			respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); // Adicionando opcoes erradas
		}

		Collections.shuffle(respostaErrada); // Embaralhando as opcoes para que haja uma aleatoriedade
		Collections.shuffle(respostaErrada);

		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i] = respostaErrada.get(i); // Transferindo as opcoes do ArrayList para uma String[]
		}

		////////////////////////////////////////////////////////////////////////
		// Area de logica do game
		

		String enunciado = String.valueOf("\nConverta o numero "+numeroInicial[0]+" que esta na base "+baseInicial+" para a base "+baseConversao+"\n\n");
		
		//  System.out.printf("\nConverta o numero %S que esta na base %d para a base %d\n\n", numeroInicial[0],
		//	baseInicial, baseConversao);
		//  Timer2();

		status = ProcessoAlternativas_Geral(opcoes, status, respostaCerta,enunciado);

		return status;
	}

	// DESAFIO É SOMAR DOIS NÚMEROS QUE ESTÃO EM UMA BASE E CONVERTER PARA OUTRO
	static int[] Desafio2_Templo3(int[] status) {
		// Area para inicializar variaveis
		int baseInicial, baseConversao;
		String respostaCerta;

		String[] numeroInicial = new String[2];
		String[] opcoes = new String[5];
		ArrayList<String> respostaErrada = new ArrayList();
		////////////////////////////////////////////////////////////////////////
		// Area para declarar os numeros

		baseInicial = DeterminaBase_Templo3(); // Gerar a base standard

		do {
			baseConversao = DeterminaBase_Templo3(); // Gerar a base para conversao
		} while (baseConversao == baseInicial);

		numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); // Gerar o numero standard A
		numeroInicial[1] = DeterminaNumero_Templo3(baseInicial); // Gerar o numero standard B

		respostaCerta = DeterminaNumeroConv_Templo3(numeroInicial, baseInicial, baseConversao); // Gerar a resposta
																								// certa

		respostaErrada.add(respostaCerta); // Adicionando a resposta certa no ArrayList

		for (int i = 0; i <= 3; i++) {
			respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); // Criando respostas erradas para o
																				// ArrayList
		}

		Collections.shuffle(respostaErrada); // Embaralhando as opcoes
		Collections.shuffle(respostaErrada);

		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i] = respostaErrada.get(i); // Adicionando as opcoes embaralhadas numa String para fazer o desafio
		}

		
		String enunciado = String.valueOf("\nFaça a seguinte conversão:\n"+numeroInicial[0]+" + "+numeroInicial[1]+" (na base "+baseInicial +") = X (na base "+baseConversao+")\n\n" );
		
		//		System.out.printf("\nFaça a seguinte conversão:\n%S + %S (na base %d) = X (na base %d)\n\n", numeroInicial[0],
		//		numeroInicial[1], baseInicial, baseConversao);
		//		Timer2();

		ProcessoAlternativas_Geral(opcoes, status, respostaCerta,enunciado);

		return status;
	}

	// DESAFIO É MULTIPLICAR DOIS NÚMEROS QUE ESTÃO EM UMA BASE E CONVERTER PARA OUTRO
	static int[] Desafio3_Templo3(int[] status) {
		// Area para declarar variaveis
		int baseInicial, baseConversao, aux;
		String respostaCerta;

		String[] numeroInicial = new String[2];
		String[] opcoes = new String[5];
		ArrayList<String> respostaErrada = new ArrayList();
		////////////////////////////////////////////////////////////////////////
		// Area para iniciar variaveis
		baseInicial = DeterminaBase_Templo3(); // Gerar a base inicial

		do {
			baseConversao = DeterminaBase_Templo3(); // Gerar a base para conversao
		} while (baseConversao == baseInicial);

		numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); // Gerar numero standard A
		numeroInicial[1] = DeterminaNumero_Templo3(baseInicial); // Gerar numero standard B

		aux = (Integer.parseInt(numeroInicial[0], baseInicial)) * (Integer.parseInt(numeroInicial[1], baseInicial)); // Convertendo
																														// o
																														// produto
																														// dos
																														// numeros
																														// standard
																														// para
																														// int

		respostaCerta = Integer.toString(aux, baseConversao); // Convertendo o produto dos numeros standard para a base
																// de conversao

		respostaErrada.add(respostaCerta); // Adicionando a resposta certa nas opcoes

		for (int i = 0; i <= 3; i++) {
			respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); // Adicionando as opcoes erradas
		}

		Collections.shuffle(respostaErrada); // Embaralhando as opcoes
		Collections.shuffle(respostaErrada);

		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i] = respostaErrada.get(i);// Adicionando as opcoes em String para fazer o desafio
		}

		
		String enunciado = String.valueOf("\nFaça a seguinte conversão:\n"+numeroInicial[0]+" * "+numeroInicial[1]+" (na base "+baseInicial +") = X (na base "+baseConversao+")\n\n" );
		

		//			System.out.printf("\nFaça a seguinte conversão:\n%S * %S (na base %d) = X (na base %d)\n\n", numeroInicial[0],
		//			numeroInicial[1], baseInicial, baseConversao);
		//			Timer2();

		ProcessoAlternativas_Geral(opcoes, status, respostaCerta,enunciado);

		return status;
	}

	// FUNÇÕES DO TEMPLO 3
	static int DeterminaBase_Templo3() {

		ArrayList<Integer> bases = new ArrayList();

		bases.add(2);
		bases.add(8);
		bases.add(10);
		bases.add(16);

		Collections.shuffle(bases);
		Collections.shuffle(bases);

		return bases.get(0);
	}

	static String DeterminaNumero_Templo3(int baseInicial) {

		Random dado = new Random();
		int numRandom;
		String baseAconv = null;

		do {
			numRandom = dado.nextInt(2000);
		} while (numRandom <= 50);

		switch (baseInicial) {
		case 2:
			baseAconv = Integer.toBinaryString(numRandom);
			break;
		case 8:
			baseAconv = Integer.toOctalString(numRandom);
			break;
		case 10:
			baseAconv = Integer.toString(numRandom);
			break;
		case 16:
			baseAconv = Integer.toHexString(numRandom);
			break;
		}

		return baseAconv;
	}

	static String DeterminaOpcoes(int baseConversao, String respostaCerta) {
		Random dado = new Random();
		int aux = Integer.parseInt(respostaCerta, baseConversao);
		String opcoesFalsas;

		do {
			aux = aux + dado.nextInt(30);
			aux = aux - 15;
			opcoesFalsas = Integer.toString(aux, baseConversao);
		} while (opcoesFalsas.equals(respostaCerta));

		return opcoesFalsas;
	}

	static String DeterminaNumeroConv_Templo3(String[] numeroInicial, int baseInicial, int baseConversao) {
		int aux = 0;
		String respostaConversao;

		for (int i = 0; i < numeroInicial.length; i++) {
			aux = aux + Integer.parseInt(numeroInicial[i], baseInicial);
		}

		respostaConversao = Integer.toString(aux, baseConversao);

		return respostaConversao;
	}

	// TEMPLO 2
	static void ExecutaTemplo2(){
	
	
		Scanner sc = new Scanner(System.in);
		boolean condicao = true, condicao2 = true;

		do {

			do {

				Desafio1_Templo2();

				if (status[0] > 0) {

					status[1]++;

				} else {
					Texto_Formatado(Dialogo("Narrador", WHITE) + "\n - " + nomeJogador + " infelizmente foi derrotado!!");
					status[0] = 100;
					break;
				}

				System.out.print("\nAperte ENTER para começar o próximo Desafio");
				sc.nextLine();
				System.out.println(" ");

				Desafio2_Templo2();

				if (status[0] > 0) {

					status[1]++;

				} else {
					Texto_Formatado(Dialogo("Narrador", WHITE) + "\n - " + nomeJogador + " infelizmente foi derrotado!!");
					status[0] = 100;
					break;
				}

				System.out.print("\nAperte ENTER para começar o próximo Desafio");
				sc.nextLine();
				System.out.println(" ");

				Desafio3_Templo2();

				if (status[0] > 0) {

					status[1]++;
					condicao = false;
					condicao2 = false;

				} else {
					Texto_Formatado(Dialogo("Narrador", WHITE) + "\n - " + nomeJogador + " infelizmente foi derrotado!!");
					status[0] = 100;
					break;
				}
			} while (condicao);
		} while (condicao2);
	
}
	
	// FUNÇÕES DO TEMPLO 2
	static void Desafio1_Templo2() {
		//variáveis
		int r;
		Random rng = new Random();
		String enunciado;
		String[] opcoes = new String[5];
				
		//Questão
				
		//RANDOMIZANDO A QUESTÃO E REPETINDO ATÉ O ACERTO OU VIDA = 0
		
		
			r = rng.nextInt(3);
		switch(r) {
		//RECEBENDO A QUESTÃO RANDOMIZADA E RESOLVENDO A QUESTÃO.
			case 0:
				
				enunciado = "\nQuais são os coeficiêntes dessa equação de segundo grau. 2x² + x – 3 = 0\n";
				
						
				
				opcoes[0] = "a = -2  |  b = 0  |  c = -3";
				opcoes[1] = "a =  2  |  b = 1  |  c =  3";
				opcoes[2] = "a =  2  |  b = 1  |  c = -3";
				opcoes[3] = "a =  2  |  b = 0  |  c = -3";
				opcoes[4] = "a =  1  |  b = 0  |  c = -3";
				
				ProcessoAlternativas_Geral(opcoes,status,"a =  2  |  b = 1  |  c = -3",enunciado);
				
				break;
				
			case 1:
				
				enunciado = "\nQuais são os coeficiêntes dessa equação de segundo grau. –3x² + 18x – 15 = 0\n";
				
				
				
				
				opcoes[0] = "a = -3  |  b = -18  |  c = -15";
				opcoes[1] = "a =  3  |  b =  18  |  c = -15";
				opcoes[2] = "a = -3  |  b =  18  |  c =  15";
				opcoes[3] = "a = -3  |  b =  18  |  c = -15";
				opcoes[4] = "a =  3  |  b =  18  |  c =   0";
				
				
				
				ProcessoAlternativas_Geral(opcoes,status,"a = -3  |  b =  18  |  c = -15",enunciado);
				
				
				break;
				
			case 2:
				
				enunciado = "\nQuais são os coeficiêntes dessa equação de segundo grau. 3x² – x – 1 = 0\n";
			
				
				
				opcoes[0] = "a = -3  |  b =  -1  |  c = -1";
				opcoes[1] = "a =  3  |  b =  -1  |  c = -1";
				opcoes[2] = "a = -3  |  b =   0  |  c =  1";
				opcoes[3] = "a =  3  |  b =  -1  |  c =  1";
				opcoes[4] = "a =  1  |  b =   0  |  c = -3";
				
				ProcessoAlternativas_Geral(opcoes,status,"a =  3  |  b =  -1  |  c = -1",enunciado);
				
				break;
		}
		
	
		}
	
	static void Desafio2_Templo2() {
		//variáveis
		int r;
		Random rng = new Random();
		String enunciado;
		String[] opcoes = new String[5];
		
		//Enunciado
		
		//Randomizando a questão
		
		
		//RECEBENDO A QUESTÃO RANDOMIZADA E RESOLVENDO A QUESTÃO.
	
			r = rng.nextInt(3);
		switch(r) {
		case 0:
			
			enunciado = "\nQual é a maior raiz da equação -2x² + 3x + 5 = 0?\n";
			
			
			opcoes[0] = "-1";
			opcoes[1] = "-2,5";
			opcoes[2] = "2";
			opcoes[3] = "2,5";
			opcoes[4] = "1";
			
			ProcessoAlternativas_Geral(opcoes,status,"2,5",enunciado);
			
			
		
			break;
		case 1:
			
			enunciado = "\nQual é a menor raiz da equação 2x² + 7x + 5 = 0\n";
			
			
			opcoes[0] = "-1";
			opcoes[1] = "1";
			opcoes[2] = "-5/2";
			opcoes[3] = "-2";
			opcoes[4] = "-2/5";
			
			ProcessoAlternativas_Geral(opcoes,status,"-5/2",enunciado);
			
			break;
			
		case 2:
			
			enunciado = "\nQuais são as duas raízes da equação 3x² – x – 2 = 0\n";
			
			
			opcoes[0] = "x1 =  2/3 | x2 =  1";
			opcoes[1] = "x1 = -2/3 | x2 = -1";
			opcoes[2] = "x1 = -2/3 | x2 =  1";
			opcoes[3] = "x1 =  -1  | x2 = 2/3";
			opcoes[4] = "x1 =  -1  | x2 = -2/3";
			
			ProcessoAlternativas_Geral(opcoes,status,"x1 = -2/3 | x2 =  1",enunciado);
			
			break;
			
		}
			
	
	}
	
	static void Desafio3_Templo2() {
		//Variaveis
		int r;
		Random rng = new Random();
		String enunciado;
		String[] opcoes = new String[5];
		
		//Enunciado
		
			r = rng.nextInt(3);
		switch(r) {
		case 0:
			
			enunciado = "\nQual é a resolução da seguinte equação do segundo grau x² – 4x – 5 = 0?\n";
			
			
			opcoes[0] = "x1 =  1  | x2 =  5";
			opcoes[1] = "x1 = -1  | x2 =  5";
			opcoes[2] = "x1 = -1  | x2 = -5";
			opcoes[3] = "x1 = -5  | x2 =  1";
			opcoes[4] = "x1 = -3  | x2 =  5";
			
			ProcessoAlternativas_Geral(opcoes,status,"x1 = -1  | x2 =  5",enunciado);
			
			
			break;
		case 1:
			
			enunciado = "\nTemos na equação 10x² – 1000 = 0, duas raízes reais e distintas, a e b, que podem ser encontradas. Determine a² + b²\n";
			
			
			opcoes[0] = "100";
			opcoes[1] = "50";
			opcoes[2] = "250";
			opcoes[3] = "200";
			opcoes[4] = "1000";
			
			ProcessoAlternativas_Geral(opcoes,status,"200",enunciado);
				
			break;
		case 2:
			
			enunciado = "\nQual será o resultado do produto das duas raízes da equação 5x² - 125 = 0\n";
			
			
			opcoes[0] = "-25";
			opcoes[1] = "20";
			opcoes[2] = "25";
			opcoes[3] = "30";
			opcoes[4] = "125";
			
			ProcessoAlternativas_Geral(opcoes,status,"-25",enunciado);
			
			
			break;
			
		}
	
		
		
	}
	
	
}
