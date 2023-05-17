package com.itson.desechostoxicospersistencia.validators;

import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

public class GeneralMethods {

    public List<Vehiculo> generacionDeIdParaVehiculos(EmpresaTransportista empresa) {
        try {

            for (Vehiculo vehiculo : empresa.getVehiculos()) {
                vehiculo.setId(new ObjectId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al generarles ID's a los vehiculos");
            return null;
        }

        return empresa.getVehiculos();
    }

}
