package sn.simplon.senforage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.simplon.senforage.dao.IClient;
import sn.simplon.senforage.dao.IVillage;
import sn.simplon.senforage.entities.Client;
import sn.simplon.senforage.entities.Village;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private IClient clientdao;
    @Autowired
    private IVillage villagedao;

    @RequestMapping(value="Client/liste")
    public String  liste(ModelMap model){

        List<Client> clients = clientdao.findAll();
        List<Village> villages = villagedao.findAll();
        model.put("liste_clients", clients);
        model.put("liste_villages", villages);
        return "client/client";
    }

    @RequestMapping(value="Client/add", method = RequestMethod.POST)
    public String add(String nom, String telephone, int village){
        ModelAndView modelAndView = new ModelAndView();
        Client client = new Client();

        client.setNom(nom);
        client.setTelephone(telephone);
        Village village1 = new Village();
        village1 = villagedao.getOne(village);
        client.setVillage(village1);


        try {
            clientdao.save(client);
            clientdao.flush();

        }catch (Exception e){

        }

        return "redirect:/Client/liste";

    }
}


