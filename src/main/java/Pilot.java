public class Pilot extends Human{

    private String licenseNumber;
    private RankType rank;

    public Pilot(String name, RankType rank, String licenseNumber){
        super(name);
        this.rank = rank;
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public String flyAirplane(){
        return "I can fly the airplane";
    }

}
