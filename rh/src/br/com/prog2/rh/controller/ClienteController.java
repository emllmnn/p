package br.com.prog2.rh.controller;
import java.util.List;
import br.com.prog2.rh.model.Cliente;
import br.com.prog2.rh.persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente cli){
		/*ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(cli);*/
		String sql = "insert into cliente(codCliente,nomeCliente,rgCliente,enderecoCliente,bairroCliente,"
				+ "cidadeCliente,estadoCliente,cepCliente,nascimentoCliente)values (?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cli.getCodCli());
		pst.setString(2, cli.getNomeCli());
		pst.setString(3, cli.getRgCli());
		pst.setString(4, cli.getEnderecoCli());
		pst.setString(5, cli.getBairroCli());
		pst.setString(6, cli.getCidadeCli());
		pst.setString(7, cli.getEstadoCli());
		pst.setString(8, cli.getCepCli());
		pst.setString(9, cli.getNascimentoCli());
		int res = pst.executeUpdate();
		if(res > 0){
			return "Inserido com sucesso.";
		}else{
			return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
			}
		}
		public String alterar(Cliente cli) {
		/*ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(cli);*/
			String sql = "update cliente set nomeCliente=?,rgCliente=?,enderecoCliente=?,bairroCliente=?,cidadeCliente=?,"
				+ "estadoCliente=?,cepCliente=?,nascimentoCliente=? wherecodCliente=?";
			Connection con = ConnectionFactory.getConnection();
			try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, cli.getCodCli());
				pst.setString(2, cli.getNomeCli());
				pst.setString(3, cli.getRgCli());
				pst.setString(4, cli.getEnderecoCli());
				pst.setString(5, cli.getBairroCli());
				pst.setString(6, cli.getCidadeCli());
				pst.setString(7, cli.getEstadoCli());
				pst.setString(8, cli.getCepCli());
				pst.setString(9, cli.getNascimentoCli());
				int res = pst.executeUpdate();
				if(res > 0){
					return "Alterado com sucesso.";
				}else{
					return "Erro ao alterar.";
				}
			}catch(SQLException e){
				return e.getMessage();
			}finally {
				ConnectionFactory.close(con);
			}
		}
		public String excluir(Cliente cli){
		/*ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(cli);*/
			String sql = "delete from cleinte where codCliente=?";
			Connection con = ConnectionFactory.getConnection();
			try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, cli.getCodCli());
				int res = pst.executeUpdate();
				if(res > 0){
					return "Excluído com sucesso.";
				}else{
					return "Erro ao excluir.";
				}
				}catch(SQLException e){
					return e.getMessage();
				}finally {
					ConnectionFactory.close(con);
			}
		}
		public List<Cliente> listarTodos(){
		/*ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodos();*/
			String sql = "select * from cliente";
			Connection con = ConnectionFactory.getConnection();
			List<Cliente> lista = new ArrayList<>();
			try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
			while (rs.next()) {
			Cliente cl = new Cliente();
			cl.setString(rs.getCodCli(1));
			cl.setString(rs.getNomeCli(2));
			cl.setString(rs.getRgCli(3));
			cl.setString(rs.getEnderecoCli(4));
			cl.setString(rs.getBairroCli(5));
			cl.setString(rs.getCidadeCli(6));
			cl.setString(rs.getEstadoCli(7));
			cl.setString(rs.getCepCli(8));
			cl.setString(rs.getNascimentoCli(9));
			lista.add(cl);
			}
			return lista;
			} else {
				return null;
			}
			} catch (SQLException e) {
				return null;
			} finally {
				ConnectionFactory.close(con);
			}
			}
			
		}
		public Cliente pesquisarPorCodCli(String codCli){
			/*ClienteDAOImp dao = new ClienteDAOImp();
			return dao.pesquisarPorCodCli(codCli);*/
			String sql = "select * from cliente where codCliente=?";
			Connection con = ConnectionFactory.getConnection();
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, codCliente);
				ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente cl = new Cliente();
				cl.setCodCli(rs.getString(1));
				cl.setNomeCli(rs.getString(2));
				cl.setRgCli(rs.getString(3));
				cl.setEnderecoCli(rs.getString(4));
				cl.setBairroCli(rs.getString(5));
				cl.setCidadeCli(rs.getString(6));
				cl.setEstadoCli(rs.getString(7));
				cl.setCepCli(rs.getString(8));
				cl.setNascimentoCli(rs.getString(9));
				return cl;
			}else {
				return null;
		}
			}catch (SQLException e) {
				return null;
			}finally {
				ConnectionFactory.close(con);
			}
		}

