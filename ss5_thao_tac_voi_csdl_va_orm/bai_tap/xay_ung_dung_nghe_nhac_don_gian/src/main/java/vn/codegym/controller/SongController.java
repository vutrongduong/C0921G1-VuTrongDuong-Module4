package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

import java.util.List;

@Controller
@RequestMapping("songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("songs/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("songs/info");
        Song song = songService.findOne(id);
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping
    public String update(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("songs/create", "song", new Song());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute("song") Song song) {
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("songs/create");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("mess", "New song created sucessfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.remove(id);
        return "redirect:/songs";
    }
}
