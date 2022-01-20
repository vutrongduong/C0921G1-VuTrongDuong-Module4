package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.SongDto;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView listSong() {
        return new ModelAndView("list", "songList", songService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.add(song);
        model.addAttribute("mess", "Thêm mới thành công ");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        return new ModelAndView("edit", "songDto", songDto);
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("songDto", songDto);
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.add(song);
        model.addAttribute("mess", "Chỉnh sửa thành công ");
        return "edit";
    }
}
