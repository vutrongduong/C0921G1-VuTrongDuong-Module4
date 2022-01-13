package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.ToKhaiYTe;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToKhaiYTeController {

    @GetMapping("/")
    public String createForm(Model model) {
        ToKhaiYTe toKhaiYTe = new ToKhaiYTe();
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        List<Integer> namSinhList = new ArrayList<>();
        for (int i = 2004; i >= 1900; i--) {
            namSinhList.add(i);
        }
        model.addAttribute("namSinhList", namSinhList);
        List<String> gioiTinhList = new ArrayList<>();
        gioiTinhList.add("Nam");
        gioiTinhList.add("Nữ");
        model.addAttribute("gioiTinhList", gioiTinhList);

        List<String> quocTichList = new ArrayList<>();
        quocTichList.add("Việt Nam");
        quocTichList.add("Japan");
        model.addAttribute("quocTichList", quocTichList);

        List<String> phuongTienList = new ArrayList<>();
        phuongTienList.add("Tàu bay");
        phuongTienList.add("Tàu thuyền");
        phuongTienList.add("Ô tô");
        phuongTienList.add("Khác");
        model.addAttribute("phuongTienList", phuongTienList);

        List<String> thanhPhoList = new ArrayList<>();
        thanhPhoList.add("Đà nẵng");
        model.addAttribute("thanhPhoList", thanhPhoList);

        List<String> huyenList = new ArrayList<>();
        huyenList.add("Hòa Vang");
        model.addAttribute("huyenList", huyenList);

        List<String> xaList = new ArrayList<>();
        xaList.add("Hòa Tiến");
        model.addAttribute("xaList", xaList);

        return "index";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("toKhaiYTe") ToKhaiYTe toKhaiYTe, Model model) {
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        List<Integer> namSinhList = new ArrayList<>();
        for (int i = 2004; i >= 1900; i--) {
            namSinhList.add(i);
        }
        model.addAttribute("namSinhList", namSinhList);

        List<String> gioiTinhList = new ArrayList<>();
        gioiTinhList.add("Nam");
        gioiTinhList.add("Nữ");
        model.addAttribute("gioiTinhList", gioiTinhList);

        List<String> quocTichList = new ArrayList<>();
        quocTichList.add("Việt Nam");
        quocTichList.add("Japan");
        model.addAttribute("quocTichList", quocTichList);

        List<String> phuongTienList = new ArrayList<>();
        phuongTienList.add("Tàu bay");
        phuongTienList.add("Tàu thuyền");
        phuongTienList.add("Ô tô");
        phuongTienList.add("Khác");
        model.addAttribute("phuongTienList", phuongTienList);

        List<String> thanhPhoList = new ArrayList<>();
        thanhPhoList.add("Đà nẵng");
        model.addAttribute("thanhPhoList", thanhPhoList);

        List<String> huyenList = new ArrayList<>();
        huyenList.add("Hòa Vang");
        model.addAttribute("huyenList", huyenList);

        List<String> xaList = new ArrayList<>();
        xaList.add("Hòa Tiến");
        model.addAttribute("xaList", xaList);

        model.addAttribute("mess", " Thông tin của bạn đã được lưu vào hệ thống !!! ");
        model.addAttribute("mess2", " Bạn có thể cập nhập bằng cách thay đổi thông tin bên dưới và ấn gửi tờ khai ");
        return "index";
    }
}
