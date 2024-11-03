package model;

public class DaoJogador extends Dao {
	//
	// Constantes
	//
	final public static int TAM_INICIAL = 10;
	final public static int FATOR_CRESCIMENTO = 5;
	
	//
	// Atributos
	//
	private static Jogador[]  listaJogador;
	private static int 		     numJogador;
	
	//
	// Métodos
	//
	public static void inicializar(Jogador[] array) {
		DaoJogador.listaJogador = array;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null)
				break;
			DaoJogador.numJogador++;
		}
	}

	/**
	 * Informa quantos objetos estão persistidos
	 */
	public static int getNumJogador() {
		return DaoJogador.numJogador;
	}
	
	/**
	 * Faz a persistência do novo objeto 
	 */
	public void incluir(Jogador t) {
		// Se o array que armazena os objetos não foi criado,  
		// então crio o array
		if(DaoJogador.listaJogador == null) {
			DaoJogador.listaJogador = new Jogador[TAM_INICIAL];
			DaoJogador.numJogador = 0;
		} 
		// Se o array criado já esgotou sua capacidade, então
		// criamos um novo maior e copiamos os objetos do antigo
		// para o novo (o antigo irá para Garbage Collection)
		if(DaoJogador.listaJogador.length == DaoJogador.numJogador) {
			int novoTamanho = DaoJogador.listaJogador.length + FATOR_CRESCIMENTO;
			Jogador[] novoArray = new Jogador[novoTamanho];
			for(int i = 0; i < DaoJogador.numJogador; i++)
				novoArray[i] = DaoJogador.listaJogador[i];
			DaoJogador.listaJogador = novoArray;
		}
		// Incluindo o novo objeto no array
		DaoJogador.listaJogador[DaoJogador.numJogador] = t;
		DaoJogador.numJogador++;	
		// Salvando o objeto
		Dao.salvar();
	}
	
	/**
	 * Promove a alteração do objeto no DaoJogador 
	 */
	public void alterar(Jogador p) throws ModelException {
		// Se o array que armazena os objetos não foi criado,  
		// então lanço uma exceção indicando erro
		if(DaoJogador.listaJogador == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		// Verificando se o objeto já fazia parte do array
		// Gerenciado pelo Dao
		for(int i = 0; i < DaoJogador.numJogador;i++) {
			// Se encontrei o objeto a ser alterado no array
			if(DaoJogador.listaJogador[i] == p) {
				// Salvo o objeto e saio do método
				Dao.salvar();
				return;
			}
		}
		// Se cheguei aqui, é porque o objeto não fazia 
		// parte do array; logo não há alteração a ser feita
		throw new ModelException("Solicitação de Alteração de um objeto que não foi salvo anteriormente");
	}
	
	/**
	 * Promove a exclusão de um objeto no DaoJogador 
	 */
	public void excluir(Jogador p) throws ModelException {
		// Se o array que armazena os objetos não foi criado,  
		// então lanço uma exceção indicando erro.
		if(DaoJogador.listaJogador == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		// Verificando se o objeto já fazia parte do array
		// Gerenciado pelo Dao
		for(int i = 0; i < DaoJogador.numJogador;i++) {
			// Se encontrei o objeto a ser alterado no array
			if(DaoJogador.listaJogador[i] == p) {
				// Trago todos os objetos à frente da posição 'i'
				// uma posição para trás, apagando assim o objeto e
				// não deixando um buraco no array
				for(int j = i; j < DaoJogador.numJogador-1; j++) 
					DaoJogador.listaJogador[j] = DaoJogador.listaJogador[j + 1];
				DaoJogador.listaJogador[numJogador-1] = null;
				DaoJogador.numJogador--;
				// Salvo o novo estado do array 
				Dao.salvar();
				return;
			}
		}
		// Se cheguei aqui, é porque o objeto não fazia 
		// parte do array; logo não há exclusão a ser feita
		throw new ModelException("Solicitação de Exclusão de um objeto que não foi salvo anteriormente");
	}
		
	/**
	 * Retorna todas as Jogador criadas
	 */
	public static Jogador[] consultarJogador() {
		Jogador[] copia = new Jogador[DaoJogador.numJogador];
		for(int i = 0; i < DaoJogador.numJogador; i++)
			copia[i] = DaoJogador.listaJogador[i];
		return copia;
	}
}
