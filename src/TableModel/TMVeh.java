/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Vehiculo;
import modelo.Tipo;

/**
 *
 * @author sebba
 */
public class TMVeh extends AbstractTableModel {

    private final ArrayList<Vehiculo> listaDeVehiculos;
    private final ArrayList<Tipo> listaTipos;

    public TMVeh(ArrayList<Vehiculo> listaVehiculo, ArrayList<Tipo> listaTipos) {
        this.listaDeVehiculos = listaVehiculo;
        this.listaTipos = listaTipos;
    }

    @Override
    public int getRowCount() {
        return listaDeVehiculos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehiculo vehiculo = listaDeVehiculos.get(rowIndex);
        Tipo tipo = vehiculo.buscarTipoPorId(listaTipos);

        switch (columnIndex) {
            case 0 ->
                vehiculo.getId();
            case 1 ->
                vehiculo.getMarca();
            case 2 ->
                vehiculo.getModelo();
            case 3 ->
                vehiculo.getPrecio();
            case 4 ->
                tipo.getTipo();
            default ->
                "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "ID";
            case 1 ->
                "Marca";
            case 2 ->
                "Modelo";
            case 3 ->
                "Precio";
            case 4 ->
                "Tipo";
            default ->
                "";
        };
    }

    public void clear() {
        listaDeVehiculos.clear();
        fireTableDataChanged();
    }
}
