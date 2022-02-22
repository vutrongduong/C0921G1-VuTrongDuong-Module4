package vn.codegym.dto;

import vn.codegym.model.contract_detail.AttachService;
import vn.codegym.model.contract_detail.Contract;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDetailDto {
    private Long id;
    @NotNull(message = "PLease select contract")
    private Contract contract;
    @NotNull(message = "PLease select attach service")
    private AttachService attachService;
    @NotEmpty(message = "PLease input total money")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Quantity must be a positive integer")
    private String quantity;

    public ContractDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
