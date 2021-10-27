package de.faktorzehn.training.linkki;

import org.linkki.framework.ui.application.ApplicationLayout;
import org.springframework.stereotype.Component;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(Lumo.class)
@CssImport("./styles/training-style.css")
@Component
@UIScope
public class TrainingApplicationLayout extends ApplicationLayout {

    private static final long serialVersionUID = 1L;

    public TrainingApplicationLayout() {
        super(new TrainingApplicationConfig());
    }
}
