package controle;

import java.util.List;

public interface DAO<T> {

	boolean inserir(T objeto) throws Exception;
	boolean alterar(int id, T objeto) throws Exception; // boolean alterar(T
	T excluir(int id) throws Exception; // boolean excluir(T objeto); //(int id)
	T buscar(int id) throws Exception;
	T buscar(String info) throws Exception;
	List<T> listar() throws Exception;
	List<T> listarDezPrimeiros() throws Exception;
}
