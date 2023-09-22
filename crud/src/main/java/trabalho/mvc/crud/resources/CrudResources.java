package trabalho.mvc.crud.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import trabalho.mvc.crud.dto.CrudDTO;

@Controller
public class CrudResources {

    public List<CrudDTO> cadastros = new ArrayList<>();

    @PostMapping("CrudPost")
    public String doPost(CrudDTO dto, Model model) {
        cadastros.add(dto);
        return doGet(model);
    }

    @RequestMapping("CrudGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        return "index";
    }

    @GetMapping("/delete/{index}")
    public String deleteRecord(@PathVariable int index) {
        if (index >= 0 && index < cadastros.size()) {
            cadastros.remove(index);
        }
        return "redirect:/CrudGet";
    }

    @GetMapping("/editPost/{index}")
    public String doEdit(int index, CrudDTO dto) {

        cadastros.set(index, dto);
        return "redirect:/CrudGet";
    }

}
