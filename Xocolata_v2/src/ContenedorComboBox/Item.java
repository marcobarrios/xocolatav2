/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ContenedorComboBox;

/**
 *
 * @author Equipo
 */
public class Item {
    
    private String id;
    private String dato;

    public Item(String id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }
    
    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return this.dato; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
