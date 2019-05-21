
package controle.VO;

public class Pessoa {
    
    private String nome;
    private String sobreNome;

    public Pessoa(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome: " + nome + ", sobreNome: " + sobreNome + '}';
    }
        
    
}
