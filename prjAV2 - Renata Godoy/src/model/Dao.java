package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

abstract public class Dao {
	//
	// Bloco Static é um código que será executado no momento que 
	// uma classe for carregada pela Máquina Virtual Java na execução
	// de um programa.
	//
	// No caso dessa classe (Dao), ela será carregada quando uma
	// de suas especializações for carregada.
	//
	// Este bloco static cuidará de recuperar todos os arrays de 
	// objetos que forem salvos no método salvar() e repassá-los
	// aos respectivos Dao's filhos.
	static {
		System.out.println("Classe Dao Carregada!!!");
		try {
			FileInputStream fis = new FileInputStream("objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Para cada especialização de Dao que você criar, 
			// inclua duas instruções, seguindo o padrão abaixo:
			Clube[] clube = (Clube[])ois.readObject();
			DaoClube.inicializar(clube);

			Jogador[] Jogador = (Jogador[])ois.readObject();
			DaoJogador.inicializar(Jogador);

			
			ois.close();			
		} catch (FileNotFoundException e) {
			System.out.println("Não foi localizado o arquivo de persistência");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void salvar() {
		try {
			FileOutputStream fos = new FileOutputStream("objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// Para cada especialização de Dao que você criar, 
			// inclua uma linha abaixo. Não esqueça de colocar
			// 'implements Serializable' para nas classes model.
			Clube[] listaclube = DaoClube.consultarClube(); 
			oos.writeObject(listaclube);
			
			Jogador[] listaJogador = DaoJogador.consultarJogador(); 
			oos.writeObject(listaJogador);
			

			// Salva o arquivo de serialização
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
