package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.GiaoDichDto;
import vn.codegym.model.GiaoDich;
import vn.codegym.model.KhachHang;
import vn.codegym.model.LoaiDichVu;
import vn.codegym.service.IGiaoDichService;
import vn.codegym.service.IKhachHangService;
import vn.codegym.service.ILoaiDichVuService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("giaoDich")
public class GiaoDichController {
    @Autowired
    private IGiaoDichService giaoDichService;
    @Autowired
    private IKhachHangService khachHangService;
    @Autowired
    private ILoaiDichVuService loaiDichVuService;


    @GetMapping("")
    public String list(@RequestParam(defaultValue = "") String loaiDichVuID,
                       @RequestParam(defaultValue = "") String tenKhachHang,
                       Model model) {
        List<GiaoDich> giaoDichs = giaoDichService.search(loaiDichVuID, tenKhachHang);
        model.addAttribute("giaoDichs", giaoDichs);
        List<LoaiDichVu> loaiDichVus = loaiDichVuService.findAll();
        model.addAttribute("loaiDichVus", loaiDichVus);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        GiaoDichDto giaoDichDto = new GiaoDichDto();
        model.addAttribute("giaoDichDto", giaoDichDto);
        List<KhachHang> khachHangs = khachHangService.findAll();
        List<LoaiDichVu> loaiDichVus = loaiDichVuService.findAll();
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("loaiDichVus", loaiDichVus);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid GiaoDichDto giaoDichDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("giaoDichDto", giaoDichDto);
            List<KhachHang> khachHangs = khachHangService.findAll();
            List<LoaiDichVu> loaiDichVus = loaiDichVuService.findAll();
            model.addAttribute("khachHangs", khachHangs);
            model.addAttribute("loaiDichVus", loaiDichVus);
            return "create";
        }
        GiaoDich giaoDich = new GiaoDich();
        BeanUtils.copyProperties(giaoDichDto, giaoDich);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công giao dịch với khách hàng " + giaoDich.getKhachHang().getName());
        giaoDichService.save(giaoDich);
        return "redirect:/giaoDich";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("giaoDich", giaoDichService.findById(id).get());
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable String id, Model model) {
        model.addAttribute("giaoDich", giaoDichService.findById(id).get());
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messDelete", "Xóa thành công giao dịch : " + giaoDichService.findById(id).get().getGiaoDichId());
        giaoDichService.delete(id);
        return "redirect:/giaoDich";
    }
}
