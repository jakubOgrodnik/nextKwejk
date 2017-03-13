package pl.kuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kuba.dao.GifDao;
import pl.kuba.model.Gif;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifDao gifDao;

//    @GetMapping("/add/gif")
//    public String add(ModelMap modelMap){
//        modelMap.addAttribute("gif", new Gif());
//        return "add/newgif";
//    }
//    @PostMapping("/create")
//    public String create(@ModelAttribute Gif gif){
//        gifDao.save(gif);
//        return "redirect:success";
//    }
    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/")
    public String listGifs(@ModelAttribute Gif gif, ModelMap modelMap){
        List<Gif> gifs = gifDao.getAll();
        modelMap.addAttribute("gifs", gifs);
        return "home";
    }
    @PostMapping("/gif/{name}")
    public String gifDetails(@ModelAttribute Gif gif, ModelMap modelMap) {
        List<Gif> gifs = gifDao.findByName(gif.getName());
        modelMap.addAttribute("gifs",gifs);
        return "gif-details";
    }
    @GetMapping("/gif/{name}")
    public String gifGetDetails(@ModelAttribute Gif gif, ModelMap modelMap) {
        List<Gif> gifs = gifDao.findByName(gif.getName());
        modelMap.addAttribute("gifs", gifs);
        return "gif-details";
    }
    @GetMapping("/favorites")
    public String showFavorites (@ModelAttribute Gif gif, ModelMap modelMap){
        List<Gif> gifs = gifDao.getFavorites();
        modelMap.addAttribute("gifs", gifs);
        return "favorites";
    }
}
