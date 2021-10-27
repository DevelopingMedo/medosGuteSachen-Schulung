/*******************************************************************************
 * Copyright (c) Faktor Zehn GmbH - www.faktorzehn.de
 *
 * All Rights Reserved - Alle Rechte vorbehalten.
 ******************************************************************************/

package de.faktorzehn.training.linkki;

import java.time.Year;

import org.linkki.framework.ui.application.ApplicationInfo;

public class TrainingApplicationInfo implements ApplicationInfo {

    public static final String APPLICATION_NAME = "Training Sample Application";

    @Override
    public String getApplicationName() {
        return APPLICATION_NAME;
    }

    @Override
    public String getApplicationVersion() {
        return "1.0";
    }

    @Override
    public String getApplicationDescription() {
        return "Faktor Zehn linkki Training Sample Application";
    }

    @Override
    public String getCopyright() {
        return "© Faktor Zehn " + Year.now();
    }
}
