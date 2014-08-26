package modelo;
// Generated 14/07/2013 21:23:33 by Hibernate Tools 3.2.1.GA


import gui.MonitoresTabela;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Monitor generated by hbm2java
 */
@Entity
@Table(name="MONITOR"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Monitor  implements java.io.Serializable {


     private int id;
     private String marca;
     private int preco;
     private Boolean novo;

    public Monitor() {
    }

	
    public Monitor(int id, String marca, int preco) {
        this.id = id;
        this.marca = marca;
        this.preco = preco;
    }
    public Monitor(int id, String marca, int preco, Boolean novo) {
       this.id = id;
       this.marca = marca;
       this.preco = preco;
       this.novo = novo;
    }
   
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="MARCA", nullable=false, length=100)
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Column(name="PRECO", nullable=false)
    public int getPreco() {
        return this.preco;
    }
    
    public void setPreco(int preco) {
        this.preco = preco;
    }
    
    @Column(name="NOVO")
    public Boolean getNovo() {
        return this.novo;
    }
    
    public void setNovo(Boolean novo) {
        this.novo = novo;
    }
        public String[] toArray() {
        String[] monitorArray = new String[3];
        monitorArray[MonitoresTabela.INDICE_MARCA] = this.getMarca();
        monitorArray[MonitoresTabela.INDICE_PRECO] = String.valueOf(this.getPreco());
        monitorArray[MonitoresTabela.INDICE_NOVO] = this.getNovo().toString();
        return monitorArray;
    }



}

