/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sebba
 */
public class Usuario extends Persona{

    String contreseña;
    String tipoUsuario;

    public String getContreseña() {
        return contreseña;
    }

    public void setContreseña(String contreseña) {
        this.contreseña = contreseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String contreseña, String tipoUsuario) {
        this.contreseña = contreseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }
    
}
