package vn.codegym.model.contract_detail;

import vn.codegym.model.contract_detail.AttachService;
import vn.codegym.model.contract_detail.Contract;

import javax.persistence.*;


@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name ="contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name ="attach_service_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;

    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Long id, Contract contract, AttachService attachService, Integer quantity) {
        this.id = id;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
