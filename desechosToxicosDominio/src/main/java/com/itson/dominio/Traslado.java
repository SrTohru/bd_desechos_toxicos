package com.itson.dominio;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class Traslado {

    private ObjectId id;
    private ObjectId productorId;
    private Date fecha;
    private List<Residuos> residuos;
    private List<EmpresaTransportista> EmpresaTransportista;
    private float kilos;
    private float litros;

    public Traslado() {
    }

    public Traslado(ObjectId productorId, Date fecha, List<Residuos> residuos, List<EmpresaTransportista> EmpresaTransportista) {
        this.productorId = productorId;
        this.fecha = fecha;
        this.residuos = residuos;
        this.EmpresaTransportista = EmpresaTransportista;
    }

    public Traslado(ObjectId productorId, Date fecha, List<Residuos> residuos) {
        this.productorId = productorId;
        this.fecha = fecha;
        this.residuos = residuos;
    }
    
      public Traslado(ObjectId productorId, Date fecha, List<Residuos> residuos, float kilos, float litros) {
        this.productorId = productorId;
        this.fecha = fecha;
        this.residuos = residuos;
        this.litros = litros;
        this.kilos = kilos;
    }
    
    
    public Traslado(ObjectId id, ObjectId productorId, Date fecha, List<Residuos> residuos, List<EmpresaTransportista> EmpresaTransportista) {
        this.id = id;
        this.productorId = productorId;
        this.fecha = fecha;
        this.residuos = residuos;
        this.EmpresaTransportista = EmpresaTransportista;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public float getKilos() {
        return kilos;
    }

    public void setKilos(float kilos) {
        this.kilos = kilos;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    
    
    public ObjectId getProductorId() {
        return productorId;
    }

    public void setProductorId(ObjectId productorId) {
        this.productorId = productorId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Residuos> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<Residuos> residuos) {
        this.residuos = residuos;
    }

    public List<EmpresaTransportista> getEmpresaTransportista() {
        return EmpresaTransportista;
    }

    public void setEmpresaTransportista(List<EmpresaTransportista> EmpresaTransportista) {
        this.EmpresaTransportista = EmpresaTransportista;
    }
    
    
}
