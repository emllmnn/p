package br.com.prog2.rh.persistencia;

public interface HospedagemDAO {
	public String inserir(Hospedagem hos);
	public String alterar(Hospedagem hos);
	public String excluir(Hospedagem hos);
	public List<Hospedagem> listarTodos();
	public List<Hospedagem> pesquisarPorCliente(String codigo);

}
