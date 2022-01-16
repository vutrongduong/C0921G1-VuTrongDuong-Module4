package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Song;
import vn.codegym.service.SongService;

import java.util.List;


@Controller
@RequestMapping("songs")
public class SongController {
    @Autowired
    private SongService songService;

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
    public String updateCustomer(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        long id=0;
        for (Song song:songService.findAll()) {
            id=song.getId();
        }
        id=id+1;
        return new ModelAndView("songs/create", "song", new Song(id));
    }

    @PostMapping("create")
    public String create(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }
}
