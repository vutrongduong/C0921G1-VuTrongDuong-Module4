package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.service.IAttachService;
import vn.codegym.service.IContractDetailService;
import vn.codegym.service.IContractService;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachService attachService;


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("attachServices", attachService.findAll());
        model.addAttribute("contracts",contractService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ContractDetail contractDetail) {
        contractDetailService.add(contractDetail);
        return "redirect:/employee";
    }
}
