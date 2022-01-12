package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.ToKhaiYTe;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToKhaiYTeController {
    @ModelAttribute("toKhaiYTe")
    public ToKhaiYTe toKhaiYTe() {
        return new ToKhaiYTe();
    }

    @RequestMapping("/")
    public String create(@ModelAttribute("toKhaiYTe") ToKhaiYTe toKhaiYTe, Model model) {
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        List<Integer>namSinhList=new ArrayList<>();
        for (int i = 1900; i <=2004 ; i++) {
            namSinhList.add(i);
        }
        model.addAttribute("namSinhList", namSinhList);
        List<String>gioiTinhList=new ArrayList<>();
        gioiTinhList.add("Nam");
        gioiTinhList.add("Nữ");
        model.addAttribute("gioiTinhList", gioiTinhList);
        List<String>quocTichList=new ArrayList<>();
        quocTichList.add("Việt Nam");
        model.addAttribute("quocTichList", quocTichList);
        List<String>phuongTienList=new ArrayList<>();
        quocTichList.add("Tàu bay");
        quocTichList.add("Tàu thuyền");
        quocTichList.add("Ô tô");
        quocTichList.add("Khác");
        model.addAttribute("phuongTienList", phuongTienList);
        List<String>thanhPhoList=new ArrayList<>();
        quocTichList.add("Đà nẵng");
        model.addAttribute("thanhPhoList", thanhPhoList);
        List<String>huyenList=new ArrayList<>();
        quocTichList.add("Hòa Vang");
        model.addAttribute("huyenList", huyenList);
        List<String>xaList=new ArrayList<>();
        quocTichList.add("Hòa Tiến");
        model.addAttribute("xaList", xaList);
        List<String>trieuChungList=new ArrayList<>();
        quocTichList.add("Sốt");
        quocTichList.add("Ho");
        quocTichList.add("Khó thở");
        quocTichList.add("Đau họng");
        model.addAttribute("trieuChungList", trieuChungList);
        return "index";
    }
}
