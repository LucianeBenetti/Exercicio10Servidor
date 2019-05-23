package controle.VO;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class PedidoCompra {

    private int codigoPedido;
    private ItemPedido[] itensDePedido;
    private Date dataPedido;

    public PedidoCompra() {
    }

    public PedidoCompra(int codigoPedido, ItemPedido[] itensDePedido, Date dataPedido) {
        this.codigoPedido = codigoPedido;
        this.itensDePedido = itensDePedido;
        this.dataPedido = dataPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public ItemPedido[] getItensDePedido() {
        return itensDePedido;
    }

    public void setItensDePedido(ItemPedido[] itensDePedido) {
        this.itensDePedido = itensDePedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "PedidoCompra{" + "codigoPedido=" + codigoPedido + ", itensDePedido=" + itensDePedido + ", dataPedido=" + dataPedido + '}';
    }

    
}
