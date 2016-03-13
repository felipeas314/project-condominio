package br.com.condominio.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.condominio.models.Morador;
import br.com.condominio.daos.MoradorDao;

@Controller
@RequestMapping("/morador")
@Transactional
public class MoradorController {

	   @Autowired
	   private MoradorDao moradorDao;

	   @RequestMapping("/form")
	   public ModelAndView form(Morador morador)
	   {
	      ModelAndView modelAndView = new ModelAndView("morador/form-add");
	      return modelAndView;

	   }

	   @RequestMapping(method = RequestMethod.POST)
	   public ModelAndView save(@Valid Morador morador, BindingResult bindingResult)
	   {
	      if (bindingResult.hasErrors())
	      {
	         return form(morador);
	      }
	      moradorDao.save(morador);
	      return new ModelAndView("redirect:/morador");
	   }

	   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	   public ModelAndView load(@PathVariable("id") Integer id)
	   {
	      ModelAndView modelAndView = new ModelAndView("morador/form-update");
	      modelAndView.addObject("morador", moradorDao.findById(id));
	      return modelAndView;
	   }

	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
	   {
	      ModelAndView modelAndView = new ModelAndView("morador/list");
	      modelAndView.addObject("paginatedList", moradorDao.paginated(page, 10));
	      return modelAndView;
	   }

	   //just because get is easier here. Be my guest if you want to change.
	   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	   public String remove(@PathVariable("id") Integer id)
	   {
	      Morador morador = moradorDao.findById(id);
	      moradorDao.remove(morador);
	      return "redirect:/morador";
	   }

	   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
	   public ModelAndView update(@PathVariable("id") Integer id, @Valid Morador morador, BindingResult bindingResult)
	   {
	      morador.setId(id);
	      if (bindingResult.hasErrors())
	      {
	         return new ModelAndView("morador/form-update");
	      }
	      moradorDao.update(morador);
	      return new ModelAndView("redirect:/morador");
	   }
}
