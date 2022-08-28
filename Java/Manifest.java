import java.util.LinkedList;

/**
 * This class stores information about the Manifest in the database
 */
public class Manifest {
    private LinkedList<Personnel> personnels;
    private LinkedList<Cargo> cargos;
    

    /**
     * A constructor holds the particular personnels and cargos in the manifest of each aircraft.
     */
    public Manifest() {        
        personnels = new LinkedList<>();
        cargos = new LinkedList<>();
    }

    /*
     * @param personnel         value of a Personnel assigned to that aircraft
    */
    public void addPersonnel(Personnel personnel) {
        this.personnels.add(personnel);
    }
    
    /*
     * @param cargo             value of a Cargo assigned to that aircraft
    */
    public void addCargo(Cargo cargo) {
        this.cargos.add(cargo);
    }
    
    /*
     * @param index
     * @param personnel         value of a Personnel assigned to that aircraft
    */
    public void updatePersonnels(int index, Personnel p) {
        this.personnels.set(index, p);
    }
    
    /*
     * @param index
     * @param cargo             value of a Cargo assigned to that aircraft
    */
    public void updateCargos(int index, Cargo c) {
        this.cargos.set(index, c);
    }
    
    /*
     * Delete a personnel from @param index
    */
    public Personnel deletePersonnels(int index) {
        return this.personnels.remove(index);
    }
    
    /*
     * Delete a cargo from @param index
    */
    public Cargo deleteCargo(int index) {
        return this.cargos.remove(index);
    }
    
    /**
     * Getter method for a list of the Personnel.
     *
     * @return the  value of the current Personnels
     */
    public void getListofPersonnels() {
         System.out.println("Personnels: ");  
         for(Personnel p: this.personnels) {
            System.out.print(p.getDacoName());
            System.out.print(", ");
         }
        System.out.println();
    }

    /**
     * Getter method for a list of Cargos.
     *
     * @return the value of the current Cargos
     */
    public void getListofCargos() {      
        System.out.println("Cargos: "); 
        for(Cargo c: this.cargos) {
            System.out.print(c.getCargoName());
            System.out.print(", ");
         }
        System.out.println();
    }  

}
