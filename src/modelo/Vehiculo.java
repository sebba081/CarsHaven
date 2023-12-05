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
public class Vehiculo {

    private int id;
    private String marca;
    private String modelo;
    private int precio;
    private int tipo_id_fk;

    public Vehiculo() {
    }

    public Vehiculo(int id, String marca, String modelo, int precio, int tipo_id_fk) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.tipo_id_fk = tipo_id_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipo_id_fk() {
        return tipo_id_fk;
    }

    public void setTipo_id_fk(int tipo_id_fk) {
        this.tipo_id_fk = tipo_id_fk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.marca);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + this.precio;
        hash = 97 * hash + this.tipo_id_fk;
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
        final Vehiculo other = (Vehiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (this.tipo_id_fk != other.tipo_id_fk) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", tipo_id_fk=" + tipo_id_fk + '}';
    }

}
