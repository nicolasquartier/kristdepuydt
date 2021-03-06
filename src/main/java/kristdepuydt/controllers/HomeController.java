package kristdepuydt.controllers;

import kristdepuydt.domain.ImageHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/home", method = GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        final String mainFolder = "./src/main/webapp/static/img/beelden";
        final String mainFolderShort = "../../static/img/beelden";

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        List<ImageHolder> thumbnails = new ArrayList<>();
        File folderBeelden = new File(mainFolder);
        if (folderBeelden.list() != null) {
            for (String urlFolderSpecificBeeld : folderBeelden.list()) {
                File folderSpecificBeeld = new File(mainFolder + "/" + urlFolderSpecificBeeld);
                if (folderSpecificBeeld.isDirectory()) {
                    List<String> extraBeelden = new ArrayList<>();
                    for (int i = 0; i < folderSpecificBeeld.list().length; i++) {
                        if (i == 0) continue;
                        extraBeelden.add(mainFolderShort + "/" + urlFolderSpecificBeeld + "/" + folderSpecificBeeld.list()[i]);
                    }
                    thumbnails.add(new ImageHolder(mainFolderShort + "/" + urlFolderSpecificBeeld + "/" + folderSpecificBeeld.list()[0], urlFolderSpecificBeeld, extraBeelden));
                }
            }
        }

        model.addAttribute("thumbnails", thumbnails);

        return "index";
    }

    @RequestMapping(value = {"/local"}, method = RequestMethod.GET)
    public String localIndex(Model model) {

        final String mainFolder = "img\\beelden";
        final String mainFolderShort = "img\\beelden";

        Path currentRelativePath = Paths.get("");
        String currentRelativePathAsString = currentRelativePath.toAbsolutePath().toString() + "\\..\\";

        List<ImageHolder> thumbnails = new ArrayList<>();
        File folderBeelden = new File(currentRelativePathAsString + mainFolder);
        if (folderBeelden.list() != null) {
            for (String urlFolderSpecificBeeld : folderBeelden.list()) {
                File folderSpecificBeeld = new File(currentRelativePathAsString + mainFolder + "\\" + urlFolderSpecificBeeld);
                if (folderSpecificBeeld.isDirectory()) {
                    List<String> extraBeelden = new ArrayList<>();
                    for (int i = 0; i < folderSpecificBeeld.list().length; i++) {
                        if (i == 0) continue;
                        extraBeelden.add(mainFolderShort + "\\" + urlFolderSpecificBeeld + "\\" + folderSpecificBeeld.list()[i]);
                    }
                    thumbnails.add(new ImageHolder(mainFolderShort + "\\" + urlFolderSpecificBeeld + "\\" + folderSpecificBeeld.list()[0], urlFolderSpecificBeeld, extraBeelden));
                }
            }
        }

        model.addAttribute("thumbnails", thumbnails);

        return "index";
    }
}
