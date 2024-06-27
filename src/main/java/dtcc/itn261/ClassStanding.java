package dtcc.itn261;
// enumerstion with all class standings
public enum ClassStanding {
    SELECTION,
    ALL,
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR;

    @Override
    public String toString() {
        return switch (this) {
            case SELECTION -> "Please Select Class Standing";
            case ALL -> "All Class Standings";
            case FRESHMAN -> "Freshman";
            case SOPHOMORE -> "Sophomore";
            case JUNIOR -> "Junior";
            case SENIOR -> "Senior";
        };
    }
}