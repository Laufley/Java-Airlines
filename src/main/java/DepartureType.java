public enum DepartureType {

    GLA("Glasgow International Airport"),
    EDI("Edinburgh Airport"),
    BCN("Barcelona–El Prat Airport"),
    MAD("Madrid–Barajas Airport");


    private final String pointOfDeparture;

    DepartureType(String pointOfDeparture){
        this.pointOfDeparture = pointOfDeparture;
    }
}
