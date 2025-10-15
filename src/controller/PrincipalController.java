package controller;

import entities.InformationCentre;
import ihm.PrincipalUI;
import services.ServiceCentreRadialogie;

public class PrincipalController {
    public static void InitController() {
        // get centre info from the reposetory
        InformationCentre info= ServiceCentreRadialogie.readInfo();
        // pass the info to the main UI
        PrincipalUI.initUI(info);
    }
}
