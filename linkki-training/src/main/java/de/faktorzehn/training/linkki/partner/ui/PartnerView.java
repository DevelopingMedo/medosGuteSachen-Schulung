package de.faktorzehn.training.linkki.partner.ui;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.faktorzehn.training.linkki.TrainingApplicationInfo;
import de.faktorzehn.training.linkki.TrainingApplicationLayout;
import de.faktorzehn.training.linkki.partner.PartnerRepository;

@PageTitle(TrainingApplicationInfo.APPLICATION_NAME)
@Route(value = PartnerView.ROUTE, layout = TrainingApplicationLayout.class)
public class PartnerView extends VerticalLayout {

    public static final String ROUTE = "";

    private static final long serialVersionUID = 1L;

    public PartnerView() {
        setSizeFull();
        PartnerPage personenPage = new PartnerPage(PartnerRepository.get());
        personenPage.init();
        add(personenPage);
    }

}