/**
 * This class stores information about the Cargos in the database
 */
public class Cargo {
    private String name;
    private int cargoPlane;

    /**
     * A constructor holds the name of a Cargo and the plane where cargo is located.
     *
     * @param name           value of Cargo number
     * @param dacoPlane      value of a certain aircraft of the cargo
     */
    public Cargo(String name) {
        this.name = name;
        this.cargoPlane = cargoPlane;
    }

    /**
     * Getter method for the name of Cargo.
     *
     * @return the name value of the current Cargo
     */
    public String getCargoName() {
        return this.name;
    }

    /**
     * Getter method for aircraft of cargo
     *
     * @return value of a certain aircraft
     */
    public int getCargoPlane() {
        return this.cargoPlane;
    }

    /*
    * This method checks if whether it is a same assigned CArgo
    */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Personnel) {
            Cargo otherCar = (Cargo) o;
            return this.name.equals(otherCar.getCargoName())
                    && this.cargoPlane == otherCar.getCargoPlane();
        }
        return false;
    }

}
