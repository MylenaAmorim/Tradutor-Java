# Tradutor-Java
## Estruturas de algoritmicos utilizadas:
##### • Bubble Sort
##### • Busca Binária
## O que são algoritmos de ordenação Bubble Sort?
  O Bubble Sort embora seja lento, é o mais simples dos algoritmos de ordenação, que consiste em percorrer os N elementos de um vetor, para cada vez percorrida, 
todos os elementos são comparados com o seu próximo, para verificar se estão na ordem desejada. 
### Exemplo:
public static String[][] ordemI(String dic[][]){ //percorrer os elementos do dicionário, para fazer uma organização alfabética das palavras inglesas.
		
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
## O que é busca binária?
  A busca binária é um eficiente algoritmo para encontrar um item em uma lista ordenada de itens. Ela funciona dividindo repetidamente pela metade a porção da lista que deve conter o item, até reduzir as localizações possíveis a apenas uma.
E também é um dos modos mais comuns de se usar a busca binária é para encontrar um item em um array.
### Exemplo:

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
