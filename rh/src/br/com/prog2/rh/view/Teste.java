package br.com.prog2.rh.view;
import java.sql.Connection;
import br.com.prog2.rh.persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if(con != null){
		System.out.println("OK");
		ConnectionFactory.close(con);
		
		Cliente cli = new Cliente();
		ClienteController controller = new ClienteController();
		cli.setCodCli("11111111111");
		cli.setNomeCli("João Amaral");
		cli.setRgCli("66667777");
		cli.setEnderecoCli("rua 10, casa 5, quadra j");
		cli.setBairroCli("veredas");
		cli.setCidadeCli("Brazlândia");
		cli.setEstadoCli("DF");
		cli.setCepCli("99999999");
		cli.setNascimentoCli(LocalDate.of(1999, 10, 10));
		System.out.println(controller.inserir(cli));
		
		Cliente cli = new Cliente();
		ClienteController controller = new ClienteController();
		cli.setCodCli("21112112112");
		cli.setNomeCli("Carlos Nunes");
		cli.setRgCli("56127174");
		cli.setEnderecoCli("rua 19, casa 1, quadra d");
		cli.setBairroCli("abcd");
		cli.setCidadeCli("Samambaia");
		cli.setEstadoCli("DF");
		cli.setCepCli("888888888");
		cli.setNascimentoCli(LocalDate.of(1990, 05, 05));
		System.out.println(controller.alterar(cli));
		
		Cliente cli = new Cliente();
		ClienteController controller = new ClienteController();
		cli.setCodCli("11111111111");
		System.out.println(controller.excluir(cli));
		
		ClienteController controller = new ClienteController();
		List<Cliente> lista = controller .listarTodos();
		if(lista != null){
		for(Cliente e : lista){
		System.out.println("Código: "+e.getCodCli());
		System.out.println("Nome: "+e.getNomeCli());
		System.out.println("RG: "+e.getRgCli());
		System.out.println("Endereço: "+e.getEnderecoCli());
		System.out.println("Bairro: "+e.getBairroCli());
		System.out.println("Cidade: "+e.getCidadeCli());
		System.out.println("Estado: "+e.getEstadoCli());
		System.out.println("CEP: "+e.getCepCli());
		System.out.println("Data de nascimento: "+e.getNascimentoCli());
		}
		}
		
		ClienteController controller = new ClienteController();
		Cliente cli = new Cliente();
		cli = controller.pesquisarPorCodCli("11111111111");
		if (cli != null) {
		System.out.println("Código: "+cli.getCodCli());
		System.out.println("Nome: "+cli.getNomeCli());
		System.out.println("RG: "+cli.getRgCli());
		System.out.println("Endereço: "+cli.getEnderecoCli());
		System.out.println("Bairro: "+cli.getBairroCli());
		System.out.println("Cidade: "+cli.getCidadeCli());
		System.out.println("Estado: "+cli.getEstadoCli());
		System.out.println("CEP: "+cli.getCepCli());
		System.out.println("Data de nascimento: "+cli.getNascimentoCli());
		}
		
		Hospedagem hos = new Hospedagem();
		HospedagemController dc = new HospedagemController();
		hos.setCodCli("11111111111");
		hos.setNome("João Amaral");
		hos.setNascimento(LocalDate.of(1999, 10, 10));
		System.out.println(dc.inserir(hos));
		
		Hospedagem hos = new Hospedagem();
		HospedagemController dc = new HospedagemController();
		hos.setCodCli("1111111111");
		hos.setNome("João Amaral");
		hos.setDataNascimento(LocalDate.of(1999, 10, 10));
		System.out.println(dc.alterar(hos));
		
		Hospedagem hos = new Hospedagem();
		HospedagemController dc = new HospedagemController();
		hos.setCodCliente("11111111111");
		hos.setNome("João Amaral");
		System.out.println(dc.excluir(hos));
		
		List<Hospedagem> lista = new ArrayList<>();
		HospedagemController dc = new HospedagemController();
		lista = dc.listarTodos();
		if (lista != null){
		for(Hospedagem d : lista){
		System.out.println("Cliente: "+d.getCodCliente());System.out.println("Nome: "+d.getNome());
		
		List<Hospedagem> lista = new ArrayList<>();
		HospedagemController dc = new HospedagemController();
		lista = dc.pesquisarPorCliente("11111111111");
		if (lista != null){
		for(Hospedagem d : lista){
		System.out.println("Cliente: "+d.getCodCliente());System.out.println("Nome: "+d.getNome());
		}
		}
		}
		}
		}
	}
}
