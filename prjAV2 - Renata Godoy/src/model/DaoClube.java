package model;

public class DaoClube extends Dao {
	//
	// Constantes
	//
	final public static int TAM_INICIAL = 10;
	final public static int FATOR_CRESCIMENTO = 5;

	//
	// Atributos
	//
	private static Clube[] listaClube;
	private static int numClube;

	//
	// Métodos
	//
	public static void inicializar(Clube[] array) {
		DaoClube.listaClube = array;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				break;
			DaoClube.numClube++;
		}
	}

	/**
	 * Informa quantos objetos estão persistidos
	 */
	public static int getNumClube() {
		return DaoClube.numClube;
	}

	/**
	 * Faz a persistência do novo objeto
	 */
	public void incluir(Clube t) {
		// Se o array que armazena os objetos não foi criado,
		// então crio o array
		if (DaoClube.listaClube == null) {
			DaoClube.listaClube = new Clube[TAM_INICIAL];
			DaoClube.numClube = 0;
		}
		// Se o array criado já esgotou sua capacidade, então
		// criamos um novo maior e copiamos os objetos do antigo
		// para o novo (o antigo irá para Garbage Collection)
		if (DaoClube.listaClube.length == DaoClube.numClube) {
			int novoTamanho = DaoClube.listaClube.length + FATOR_CRESCIMENTO;
			Clube[] novoArray = new Clube[novoTamanho];
			for (int i = 0; i < DaoClube.numClube; i++)
				novoArray[i] = DaoClube.listaClube[i];
			DaoClube.listaClube = novoArray;
		}
		// Incluindo o novo objeto no array
		DaoClube.listaClube[DaoClube.numClube] = t;
		DaoClube.numClube++;
		// Salvando o objeto
		Dao.salvar();
	}

	/**
	 * Promove a alteração do objeto no DaoClube
	 */
	public void alterar(Clube p) throws ModelException {
		// Se o array que armazena os objetos não foi criado,
		// então lanço uma exceção indicando erro
		if (DaoClube.listaClube == null)
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		// Verificando se o objeto já fazia parte do array
		// Gerenciado pelo Dao
		for (int i = 0; i < DaoClube.numClube; i++) {
			// Se encontrei o objeto a ser alterado no array
			if (DaoClube.listaClube[i] == p) {
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
	 * Promove a exclusão de um objeto no DaoClube
	 */
	public void excluir(Clube p) throws ModelException {
		// Se o array que armazena os objetos não foi criado,
		// então lanço uma exceção indicando erro.
		if (DaoClube.listaClube == null)
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		// Verificando se o objeto já fazia parte do array
		// Gerenciado pelo Dao
		for (int i = 0; i < DaoClube.numClube; i++) {
			// Se encontrei o objeto a ser alterado no array
			if (DaoClube.listaClube[i] == p) {
				// Trago todos os objetos à frente da posição 'i'
				// uma posição para trás, apagando assim o objeto e
				// não deixando um buraco no array
				for (int j = i; j < DaoClube.numClube - 1; j++)
					DaoClube.listaClube[j] = DaoClube.listaClube[j + 1];
				DaoClube.listaClube[numClube - 1] = null;
				DaoClube.numClube--;
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
	 * Retorna todas as Clube criadas
	 */
	public static Clube[] consultarClube() {
		Clube[] copia = new Clube[DaoClube.numClube];
		for (int i = 0; i < DaoClube.numClube; i++)
			copia[i] = DaoClube.listaClube[i];
		return copia;
	}
}
