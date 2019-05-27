package controle.VO;
    
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
    
    private int codigoUsuario;
    private String codigoSeguranca;
    private Date dataValidade;
    private String login;
    private int numeroCartao;
    private String senha;
    private PedidoCompra [] pedidosDeCompra;

    public Usuario() {
    }

    public Usuario(int codigoUsuario, String codigoSeguranca, Date dataValidade, String login, int numeroCartao, String senha, PedidoCompra[] pedidosDeCompra) {
        this.codigoUsuario = codigoUsuario;
        this.codigoSeguranca = codigoSeguranca;
        this.dataValidade = dataValidade;
        this.login = login;
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.pedidosDeCompra = pedidosDeCompra;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PedidoCompra[] getPedidosDeCompra() {
        return pedidosDeCompra;
    }

    public void setPedidosDeCompra(PedidoCompra[] pedidosDeCompra) {
        this.pedidosDeCompra = pedidosDeCompra;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", codigoSeguranca=" + codigoSeguranca + ", dataValidade=" + dataValidade + ", login=" + login + ", numeroCartao=" + numeroCartao + ", senha=" + senha + ", pedidosDeCompra=" + pedidosDeCompra + '}';
    }

   
}
