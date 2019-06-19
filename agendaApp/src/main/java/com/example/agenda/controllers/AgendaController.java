package com.example.agenda.controllers;


import com.example.agenda.models.Contato;
import com.example.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AgendaController {
    //injecao dependencias
    @Autowired
    private ContatoRepository contatoRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formContato(){
        return "formContato";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formContato(@Valid Contato contato, BindingResult result, RedirectAttributes attributes){
        //verificacao de erros
        if(result.hasErrors()){
            attributes.addFlashAttribute("error","Verifique os campos!");// flash
            return "redirect:/add";
        }

        contatoRepository.save(contato); //salvando o contato no banco de dados
        attributes.addFlashAttribute("success","Contato Adicionado!");// flash - mensagem de feedback
        return "redirect:/add";
    }

    @RequestMapping("/contatos")
    public ModelAndView listaContatos(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Contato> contatos = contatoRepository.findAll();
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView editar(@PathVariable("id") long id){
        Contato contato = contatoRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("formEditar");
        modelAndView.addObject("contato", contato);

        return modelAndView;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String editarPost(@PathVariable("id") long id, @Valid Contato contato,  BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique os campos!");
            return "redirect:/{id}";
        }
        contatoRepository.save(contato);//salvando o contato editado no banco de dados
        attributes.addFlashAttribute("success", "Contato editado!");
        return "redirect:/{id}";
    }

    @RequestMapping("/deletar")
    public String deletarContato(long id){
        Contato contato = contatoRepository.findById(id);
        contatoRepository.delete(contato);
        return "redirect:/contatos";
    }
}
