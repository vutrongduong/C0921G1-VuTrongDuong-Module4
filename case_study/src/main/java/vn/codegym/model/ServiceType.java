package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    List<Service> serviceList;

    public ServiceType(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public ServiceType(int serviceTypeId, String serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
