import java.util.*;

public class tradutor {
	
	public static String[][] ordemI(String dic[][]){ //percorrer os elementos do dicionário, para fazer uma organização alfabética das palavras inglesas.
		
		int out;
		int tam = dic.length;
		int in = 0;
		String temp = null;
		int meio = (in + tam) / 2;
		
		for(out = tam-1; out>0; out--) { 
			 for(in=0; in<meio; in++) { //enquanto in for menor que o índice do meio, faça.
				 if( dic[in][1].charAt(0) > dic[in+1][1].charAt(0) ) { //se a palavra do índice in da coluna 1 tiver a primeira letra( charAt(0) ) maior que a primeira letra do seu próximo índice, faça.
					 temp = dic[in][1]; //temp guarda a palavra do índice in da coluna 1(palavras em inglês).
					 dic[in][1] = dic[in+1][1]; //dic[in][1] recebe a palavra que vem depois dela
					 dic[in+1][1] = temp; //agora, dic[in+1][1] recebe a palavra que antes era anterior a ela.
					 
					 //o mesmo acontece para ordenar a coluna 0(palavras em português)
					 temp = dic[in][0];  
					 dic[in][0] = dic[in+1][0]; 
					 dic[in+1][0] = temp;	 
				 }
			 }
		}
		return dic; //por ser um método static é necessário especificar o return.
	 }

	public static String[][] ordemP(String dic[][]){ //percorrer os elementos do dicionário, para fazer uma organização alfabética das palavras em português.
		
		int out;
		int tam = dic.length;
		int in = 0;
		String temp = null;
		int meio = (in + tam) / 2;
		
		//o mesmo método da busca anterior se aplica, apenas fazendo uma troca de colunas, da 1 para 0 e vice-versa.
	 	for(out=tam-1; out>0; out--) { 
		 	for(in=0; in<out; in++) {
			    if( dic[in][0].charAt(0) > dic[in+1][0].charAt(0) ) { 
				 temp = dic[in][0];
				 dic[in][0] = dic[in+1][0];
				 dic[in+1][0] = temp;
				 
				 temp = dic[in][1];
				 dic[in][1] = dic[in+1][1];
				 dic[in+1][1] = temp;	 
			     }
		 	} 
	  	}
		return dic; //por ser um método static é necessário especificar o return.
	 }

	public static String tradutor (String [][] dic, String pa, int op){ //Exemplo de busca binária
		
		int out;
		int in = 0;
		String temp = null;
		String p = null;
		int tam = dic.length;
		int meio = (in + tam) / 2;
		
	if(op==1) { 

		ordemI(dic)
	
		if(pa.compareToIgnoreCase(dic[meio][1])==0){ //se a palavra procurada for igual a palavra que está no índice central
			p = dic[meio][0]; //retorne a palavra em português
		}
		else if(pa.charAt(0) > dic[meio][1].charAt(0)) { //se a primeira letra for maior que a letra do índice meio, faça.
			for (int i = meio; i < tam; i++){ //i recebe o índice do meio, e enquanto ele for maior que o tamanho, faça.
				//comparar a palavra do índice i a palavra digitada.
				if(dic[i][1].compareToIgnoreCase(pa) == 0) { //Compara duas strings, ignorando as diferenças entre maiúsculas e minúsculas.
					p = dic[i][0];
					}
				}
		}
		else {
			for (int i = 0; i < meio; i++){ //enquanto o i for menor que o meio, faça.
				if(dic[i][1].compareTo(pa) == 0) {
					p = dic[i][0];
				}
			}	
		}		
	}
	
	else if (op==2){ 

		ordemP(dic)

		 if(pa.compareTo(dic[meio][0])==0){
			p = dic[meio][1];
		 }
		if(pa.charAt(0) > dic[meio][0].charAt(0)) {
			for (int i = meio; i < dic.length; i++){
				if(dic[i][0].compareTo(pa) == 0) {
					p = dic[i][1];
				}
			}
		}
		else {
			for (int i = 0; i < meio; i++){
				if(dic[i][0].compareTo(pa) == 0) {
					p = dic[i][1];
				}
			}	
		}	 
	}
		
	else { //se a palavra não for encontrada
		System.out.println("opção inválida");
	}
		return "Traduçaõ: " + pa + " -> " + p; 
}
	
	public static void main(String[] args) { 
		
		Scanner ler = new Scanner(System.in);
		
		String[][] dic = {{"preto", "black"}, {"arvore", "tree"}, {"de novo", "again"}, {"azul", "blue"}, {"oi", "hi"}}; //exemplo de palavras
		 
		 System.out.println("Digite 1 para traduzir para português ou 2 para inglês: ");
		 int op = ler.nextInt();
		 System.out.println("Digite a palavra: ");
		 String pa = ler.next();
			
		 rascunho b = new rascunho(); //atribuindo a variável b a classe dicionario
			
		 String x = b.tradutor(dic, pa, op); //pegue o método tradutor da classe e atribua os valores das variáveis
			
			System.out.println( "Palavra: "+ pa +"\n"+ x); 
	
	}	
}
