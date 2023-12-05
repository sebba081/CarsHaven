/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author antho
 */
public class Tipos {

    private int id_tipo;
    private String tipo;

    public Tipos() {
    }

    public Tipos(int id_tipo, String tipo) {
        this.id_tipo = id_tipo;
        this.tipo = tipo;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id_tipo;
        hash = 37 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tipos other = (Tipos) obj;
        if (this.id_tipo != other.id_tipo) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }

    @Override
    public String toString() {
        return "Tipos{" + "id_tipo=" + id_tipo + ", tipo=" + tipo + '}';
    }

}
