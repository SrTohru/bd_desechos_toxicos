package com.itson.dominio;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class Traslado {

    private ObjectId id;
    private ObjectId productorId;
    private Date fecha;
    private List<RegistroTraslado> residuos;
    private List<EmpresaTransportista> EmpresaTransportista;

    public Traslado() {
    }

    public Traslado(ObjectId productorId, Date fecha, List<RegistroTraslado> residuos, List<EmpresaTransportista> EmpresaTransportista) {
        this.productorId = productorId;
        this.fecha = fecha;
        this.residuos = residuos;
        this.EmpresaTransportista = EmpresaTransportista;
    }

    public Traslado(ObjectId id, ObjectId productorId, Date fecha, List<RegistroTraslado> residuos, List<EmpresaTransportista> EmpresaTransportista) {
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

    public List<RegistroTraslado> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<RegistroTraslado> residuos) {
        this.residuos = residuos;
    }

    public List<EmpresaTransportista> getEmpresaTransportista() {
        return EmpresaTransportista;
    }

    public void setEmpresaTransportista(List<EmpresaTransportista> EmpresaTransportista) {
        this.EmpresaTransportista = EmpresaTransportista;
    }
    
    
}
