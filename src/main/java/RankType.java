public enum RankType {
    CAPTAIN("captain"),
    FIRST_OFFICER("first officer"),
    LEAD_ATTENDANT("lead attendant"),
    FLIGHT_ATTENDANT("flight attendant");

    private final String rank;

    RankType(String rank){
        this.rank = rank;
    }
}
