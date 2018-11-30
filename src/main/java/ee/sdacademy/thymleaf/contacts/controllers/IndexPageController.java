package ee.sdacademy.thymleaf.contacts.controllers;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ee.sdacademy.thymleaf.contacts.domain.Contact;
import ee.sdacademy.thymleaf.contacts.services.ContactService;

@Controller
public class IndexPageController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "index";
    }

    @GetMapping("/view")
    public String viewContact(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.get(id));
        model.addAttribute("phones", contactService.findPhoneNumbers(id));
        return "view";
    }

    @GetMapping("/createContact")
    public String createContactPage(Model model) {
        model.addAttribute("newContact", true);
        Contact o = new Contact();
        model.addAttribute("contact", o);
        return "createEditContact";
    }

    @GetMapping("/editContact/{id}")
    public String editContactPage(@PathVariable ("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.get(id));
        return "editContact";
    }

    // updating a Contact
    @PostMapping("/editContact/{id}")
    public String editContactPage(
            @PathVariable("id") Integer id,
            // has to be valid by our contraints
            @Valid Contact contact,
            // BindingResult, holds the errors if they exist, defined by our annotations
            BindingResult bindingResult,
            Model model) {

        // custom BindingResult exception (not very reusable)
        if (!id.equals(contact.getId())) {
            ObjectError objectError = new ObjectError("id", "You trying to hack me?!!!");
            bindingResult.addError(objectError);

        }
            model.addAttribute("contact", contact);
            return "editContact";
    }

    @PostMapping("/createContact")
    public String createContact(@Valid @ModelAttribute Contact contact, BindingResult bindingResult, Model model) {
        model.addAttribute("newContact", true);
        if (bindingResult.hasErrors()) {
            return "createEditContact";
        }
        Contact createContact = contactService.save(contact);
        return "redirect:/view?id=" + createContact.getId();

    }


}
