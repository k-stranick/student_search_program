package dtcc.itn261;

public enum ProgramOfStudy {
    SELECTION,
    ALL,
    BAS,
    OAT,
    BSE,
    AET,
    EET,
    RES;

    @Override
    public String toString() {
        return switch (this) {
            case SELECTION -> "Please Select Program of study";
            case ALL -> "All";
            case BAS -> "Bachelor of Applied Science";
            case OAT -> "Office Administration";
            case BSE -> "Bachelor of Science in Elementary Education";
            case AET -> "Architectural Engineering";
            case EET -> "Electronics Engineering Technology";
            case RES -> "Research";
        };
    }
}
