package controle.VO;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

    private int codigoItem;
    private String descricao;
    private String detalhes;
    private String nome;
    private double valor;

    public Item(int codigoItem, String descricao, String detalhes, String nome, double valor) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.detalhes = detalhes;
        this.nome = nome;
        this.valor = valor;
    }

    public Item() {
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item{" + "codigoItem=" + codigoItem + ", descricao=" + descricao + ", detalhes=" + detalhes + ", nome=" + nome + ", valor=" + valor + '}';
    }
    
   
}