/**
 * This class stores information about the personnels in the database
 */
public class Personnel {
    private String name;
    private int dacoPlane;

    /**
     * A constructor holds the name of a personnel and the username/password/current_plane/current_service personnel.
     *
     * @param name           value of Personnel name
     * @param dacoPlane      value of a certain aircraft where the personnel is assigned
     */
    public Personnel(String name) {
        this.name = name;
        this.dacoPlane = dacoPlane;
    }

    /**
     * Getter method for the name of Personnel.
     *
     * @return the name value of the current Personnel
     */
    public String getDacoName() {
        return this.name;
    }

    /**
     * Getter method for value of a certain aircraft where the personnel is assigned
     *
     * @return value of a certain aircraft
     */
    public int getDacoPlane() {
        return this.dacoPlane;
    }

    /*
    * This method checks if whether it is a same assigned Personnel
    */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Personnel) {
            Personnel otherPer = (Personnel) o;
            return this.name.equals(otherPer.getDacoName())
                    && this.dacoPlane == otherPer.getDacoPlane();
        }
        return false;
    }

}
