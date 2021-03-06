package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.dto.ContractDetailDto;
import vn.codegym.model.contract_detail.ContractDetail;
import vn.codegym.service.contract_detail.IAttachService;
import vn.codegym.service.contract_detail.IContractDetailService;
import vn.codegym.service.contract_detail.IContractService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
   private IContractService contractService;
    @Autowired
   private IAttachService attachService;


    @GetMapping("/create")
    public String showCreate(Model model, Pageable pageable) {
        model.addAttribute("attachServices", attachService.findAll());
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model, Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("attachServices", attachService.findAll());
            model.addAttribute("contracts", contractService.findAll(pageable));
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "contract_detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.add(contractDetail);
        return "redirect:/";
    }
}