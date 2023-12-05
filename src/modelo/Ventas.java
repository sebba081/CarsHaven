/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author antho
 */
public class Ventas {

    private int id_ventas;
    private int id_persona;
    private int id_vehiculo;
    private int cantidad;
    private LocalDate fecha_venta;

    public Ventas() {
    }

    public Ventas(int id_ventas, int id_persona, int id_vehiculo, int cantidad, LocalDate fecha_venta) {
        this.id_ventas = id_ventas;
        this.id_persona = id_persona;
        this.id_vehiculo = id_vehiculo;
        this.cantidad = cantidad;
        this.fecha_venta = fecha_venta;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_ventas;
        hash = 79 * hash + this.id_persona;
        hash = 79 * hash + this.id_vehiculo;
        hash = 79 * hash + this.cantidad;
        hash = 79 * hash + Objects.hashCode(this.fecha_venta);
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
        final Ventas other = (Ventas) obj;
        if (this.id_ventas != other.id_ventas) {
            return false;
        }
        if (this.id_persona != other.id_persona) {
            return false;
        }
        if (this.id_vehiculo != other.id_vehiculo) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return Objects.equals(this.fecha_venta, other.fecha_venta);
    }

    @Override
    public String toString() {
        return "Ventas{" + "id_ventas=" + id_ventas + ", id_persona=" + id_persona + ", id_vehiculo=" + id_vehiculo + ", cantidad=" + cantidad + ", fecha_venta=" + fecha_venta + '}';
    }

}
