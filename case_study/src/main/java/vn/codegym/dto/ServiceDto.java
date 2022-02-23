package vn.codegym.dto;

import vn.codegym.model.service.RentType;
import vn.codegym.model.service.ServiceType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private String serviceId;
    @NotEmpty(message = "PLease input name")
    private String serviceName;
    @NotEmpty(message = "PLease input area")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Area must be a positive integer")
    private String serviceArea;
    @NotEmpty(message = "PLease input cost")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Cost must be a positive integer")
    private String serviceCost;
    @NotEmpty(message = "PLease input max people")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Number of floors must be a positive integer")
    private String serviceMaxPeople;
    @NotNull(message = "Please select rent type")
    private RentType rentType;
    @NotNull(message = "Please select service type")
    private ServiceType serviceType;
    @NotEmpty(message = "PLease input standard room")
    private String standardRoom;
    @NotEmpty(message = "PLease input description other convenience")
    private String descriptionOtherConvenience;
    @NotEmpty(message = "PLease input pool area")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Pool area must be a positive integer")
    private String poolArea;
    @NotEmpty(message = "PLease input number of floors")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Number of floors must be a positive integer")
    private String numberOfFloors;
    private Integer status;

    public ServiceDto() {
    }

    public ServiceDto(String serviceId, @NotEmpty(message = "PLease input name") String serviceName, @NotEmpty(message = "PLease input area") @Pattern(regexp = "^([1-9])([0-9].*)$", message = "Area must be a positive integer") String serviceArea, @NotEmpty(message = "PLease input cost") @Pattern(regexp = "^([1-9])([0-9].*)$", message = "Cost must be a positive integer") String serviceCost, @NotEmpty(message = "PLease input max people") @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Number of floors must be a positive integer") String serviceMaxPeople, @NotNull(message = "Please select rent type") RentType rentType, @NotNull(message = "Please select service type") ServiceType serviceType, @NotEmpty(message = "PLease input standard room") String standardRoom, @NotEmpty(message = "PLease input description other convenience") String descriptionOtherConvenience, @NotEmpty(message = "PLease input pool area") @Pattern(regexp = "^([1-9])([0-9].*)$", message = "Pool area must be a positive integer") String poolArea, @NotEmpty(message = "PLease input number of floors") @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Number of floors must be a positive integer") String numberOfFloors, Integer status) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.status = status;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
