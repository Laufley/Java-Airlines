public class CrewMember extends Human {

    private RankType rank;

    public CrewMember(String name, RankType rank){
        super(name);
        this.rank = rank;
    }

    public RankType getRank(){
        return this.rank;
    }

    public String RelayMessage() {
        String Stringify = this.getRank().toString();
        return "Welcome to Java Airlines, I'm" + " "+ this.getName() + "," + "your" + " " + Stringify;
    }
}
