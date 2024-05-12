package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.EnderecoDAO;
import model.Endereco;

import java.util.List;

@ManagedBean
@ViewScoped
public class EnderecoBean {

    @EJB
    private EnderecoDAO enderecoDAO;

	private List<Endereco> enderecos;

	public List<Endereco> buscarEnderecosPorPessoa(int idPessoa) {
		return enderecoDAO.buscarPorIdPessoa(idPessoa);
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
