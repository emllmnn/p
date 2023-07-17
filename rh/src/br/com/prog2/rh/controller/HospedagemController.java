package br.com.prog2.rh.controller;

public class HospedagemController {
	public String inserir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(hos);
		}
		public String alterar(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(hos);
		}
		public String excluir(Hospedagem hos) {
			HospedagemDAOImp dao = new HospedagemDAOImp();
			return dao.excluir(hos);
			}
			public List<Hospedagem> listarTodos() {
			HospedagemDAOImp dao = new HospedagemDAOImp();
			return dao.listarTodos();
			}
			public List<Hospedagem> pesquisarPorCliente(String codigo) {
			HospedagemDAOImp dao = new HospedagemDAOImp();
			return dao.pesquisarPorCliente(codigo);
			}
}
