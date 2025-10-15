package services;

import controller.ControllerCentreRadialogie;
import entities.InformationCentre;
import reposetory.ReposetoryCentreRadialogie;

public class ServiceCentreRadialogie {
    public void saveInformation(InformationCentre informationCentre) {
        boolean test;
        test=ReposetoryCentreRadialogie.saveInformationJSON(informationCentre);
        ControllerCentreRadialogie.returnResultController(test);
    }
    public static InformationCentre readInfo() {
        return ReposetoryCentreRadialogie.readInformationJSON();
    }
}
