package controller;

import entities.InformationCentre;
import ihm.ModifierCentreInformationUI;
import services.ServiceCentreRadialogie;

public class ControllerCentreRadialogie {
    public static void initController() {
        InformationCentre informationCentre=ModifierCentreInformationUI.InitUI();
        ServiceCentreRadialogie serviceCentreRadialogie=new ServiceCentreRadialogie();
        serviceCentreRadialogie.saveInformation(informationCentre);
    }
    public static void returnResultController(boolean test){
//*************
        ModifierCentreInformationUI.returnResultUI(test);
    }
}
