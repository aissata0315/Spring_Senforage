package sn.simplon.senforage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sn.simplon.senforage.dao.IVillage;
import sn.simplon.senforage.entities.Village;

import java.util.List;

@Controller
public class VillageController {

    @Autowired
    private IVillage villagedao;

    @RequestMapping(value="Village/liste")
    public ModelAndView liste(){

        List<Village> villages = villagedao.findAll();
        return new ModelAndView("village/liste", "liste_villages", villages);



    }
}
