package bean;

import dao.EnderecoDAO;
import dao.PessoaDAO;
import model.Endereco;
import model.Pessoa;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaBean {

    @EJB
    private PessoaDAO pessoaDAO;
    @EJB
    private EnderecoDAO enderecoDAO;

    private Pessoa novaPessoa = new Pessoa();
    private Endereco novoEndereco = new Endereco();
    private List<Pessoa> pessoas;

    public void salvarPessoa() {
        novoEndereco.setPessoa(novaPessoa);

        pessoaDAO.salvar(novaPessoa);
        enderecoDAO.salvar(novoEndereco);

        novaPessoa = new Pessoa(); 
        novoEndereco = new Endereco(); 
        listarPessoas(); 
    }

    public void listarPessoas() {
        pessoas = pessoaDAO.listarTodos();
    }

	public Endereco getNovoEndereco() {
		return novoEndereco;
	}

	public void setNovoEndereco(Endereco novoEndereco) {
		this.novoEndereco = novoEndereco;
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Pessoa getNovaPessoa() {
		return novaPessoa;
	}

	public void setNovaPessoa(Pessoa novaPessoa) {
		this.novaPessoa = novaPessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}