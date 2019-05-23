package controle.VO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemPedido {
    
    private int codigoItemPedido;
    private int quantidade;
    private Item item;

    public ItemPedido() {
    }

    public ItemPedido(int codigoItemPedido, int quantidade, Item item) {
        this.codigoItemPedido = codigoItemPedido;
        this.quantidade = quantidade;
        this.item = item;
    }

    public int getCodigoItemPedido() {
        return codigoItemPedido;
    }

    public void setCodigoItemPedido(int codigoItemPedido) {
        this.codigoItemPedido = codigoItemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "codigoItemPedido=" + codigoItemPedido + ", quantidade=" + quantidade + ", item=" + item + '}';
    }

   
    
}
