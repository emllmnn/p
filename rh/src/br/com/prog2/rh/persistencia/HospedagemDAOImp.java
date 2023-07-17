package br.com.prog2.rh.persistencia;

public class HospedagemDAOImp implements HospedagemDAO {
	@Override
	public String inserir(Hospedagem hos) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagem(codCliente,"
		+ "nome,dataNascimento) "
		+ "values (?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst =con.prepareStatement(sql.toString());
		pst.setString(1, hos.getCodCliente());
		pst.setString(2, hos.getNome());
		pst.setObject(3, hos.getDataNascimento());
		int res = pst.executeUpdate();
		if (res > 0) {
		return "Inserido com sucesso.";
		} else {
		return "Erro ao inserir.";
		}
		} catch (SQLException e) {
		return e.getMessage();
		} finally {
		ConnectionFactory.close(con);
		}
		public String alterar(Hospedagem hos) {
			StringBuilder sql = new StringBuilder();
			sql.append("update hospedagem set nomeCliente=?," +"dataNascimento=? where nome=? " + "and codCliente=?");
			Connection con = ConnectionFactory.getConnection();
			try {
				PreparedStatement pst =con.prepareStatement(sql.toString());
				pst.setString(1, hos.getNomeCliente());
				pst.setObject(2, hos.getDataNascimento());
				pst.setString(3, hos.getNome());
				pst.setString(4, hos.getCodCliente());
				int res = pst.executeUpdate();
				if (res > 0) {
				return "Alterado com sucesso.";
				} else {
				return "Erro ao alterar.";
				}
				} catch (SQLException e) {
				return e.getMessage();
				} finally {
				ConnectionFactory.close(con);
				}
			}
			}
			@Override
			public String excluir(Hospedagem hos) {
				@Override
				public String excluir(Hospedagem hos) {
				StringBuilder sql = new StringBuilder();
				sql.append("delete from hospedagem where nome=? " +
				"and codCli=?");
				Connection con = ConnectionFactory.getConnection();
				try {
				PreparedStatement pst = con.prepareStatement(sql.toString());pst.setString(1, hos.getNome());
				pst.setString(2, hos.getCodCliente());
				int res = pst.executeUpdate();
				if (res > 0) {
				return "Excluído com sucesso.";
				} else {
				return "Erro ao excluir.";
				}
				} catch (SQLException e) {
				return e.getMessage();
				} finally {
				ConnectionFactory.close(con);
				}
			}
			@Override
			public List<Hospedagem> listarTodos() {
				StringBuilder sql = new StringBuilder();
				sql.append("select * from hospedagem order by nome");
				Connection con = ConnectionFactory.getConnection();
				List<Hospedagem> lista = new ArrayList<>();
				try {
				PreparedStatement pst =con.prepareStatement(sql.toString());
				ResultSet rs = pst.executeQuery();
				if (rs != null) {
				while (rs.next()) {
				Hospedagem hos = new Hospedagem();
				hos.setCodCliente(rs.getString(1));
				hos.setNome(rs.getString(2));
				hos.setDataNascimento(rs.getObject(4,LocalDate.class));
				lista.add(hos);
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
			@Override
			public List<Hospedagem> pesquisarPorCliente(String codCliente) {
				StringBuilder sql = new StringBuilder();
				sql.append("select * from hospedagem where codcliente = ? orderby nome");
				Connection con = ConnectionFactory.getConnection();
				List<Hospedagem> lista = new ArrayList<>();
				try {
				PreparedStatement pst =con.prepareStatement(sql.toString());
				pst.setString(1, codCliente);
				ResultSet rs = pst.executeQuery();
				if (rs != null) {
				while (rs.next()) {
				Hospedagem hos = new Hospedagem();
				hos.setCodCliente(rs.getString(1));
				hos.setNome(rs.getString(2));
				hos.setDataNascimento(rs.getObject(3,LocalDate.class));
				lista.add(hos);
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
}
