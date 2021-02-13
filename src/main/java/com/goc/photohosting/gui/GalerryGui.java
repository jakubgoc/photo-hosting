package com.goc.photohosting.gui;

import com.goc.photohosting.ImageUploader;
import com.goc.photohosting.model.Image;
import com.goc.photohosting.repo.ImageRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("gallery")
public class GalerryGui extends VerticalLayout {

    private ImageRepo imageRepo;

    @Autowired
    public GalerryGui(ImageRepo imageRepo) {
        this.imageRepo=imageRepo;

        List<Image> images = imageRepo.findAll();

        images.stream().forEach(element -> {
            com.vaadin.flow.component.html.Image image =
                new com.vaadin.flow.component.html.Image(element.getImageAdress(), "brak");
            add(image);
        });
    }
}
