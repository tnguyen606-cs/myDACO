import java.util.Scanner;  // Import the Scanner class

/*
A Main class where to create/add a bump plane
*/

public class Main{
    public static void main(String []args)
    {
          Personnel p1 = new Personnel("John Dove");
          Personnel p2 = new Personnel("Jay Park");
          Personnel p3 = new Personnel("Patrick");
          Personnel p4 = new Personnel("Tom");
        
          Cargo c1 = new Cargo("Load 1");
          Cargo c2 = new Cargo("Load 2");
          Cargo c3 = new Cargo("Load 3");
          Cargo c4 = new Cargo("Load 4");
        
          Manifest m1 = new Manifest();
          m1.addPersonnel(p1);
          m1.addPersonnel(p2);
          m1.addPersonnel(p3);
          m1.addPersonnel(p4);
          m1.addCargo(c1);
          m1.addCargo(c2);
          m1.addCargo(c3);
          m1.addCargo(c4);
        
          // GETTING A LIST OF PERSONNELS AND CARGOS IN M1
          m1.getListofPersonnels();
          m1.getListofCargos();

          boolean running = true;
          while(running) {
              // INPUT A PERSONNEL/CARGO FROM M1
              Scanner myObj = new Scanner(System.in);
//           System.out.println("Enter the index: ");
//           int idx = myObj.nextInt();
//           System.out.println("Index is: " + idx);
              System.out.println("Enter the NAME: ");
              String name = myObj.nextLine();
              System.out.println("NAME is: " + name);



              // ADDING/REMOVING A PERSONNEL/CARGO FROM M1
              char firstChar = name.charAt(0);
              if (firstChar == 'L') { // add to cargo
                  Cargo c5 = new Cargo(name);
                  m1.addCargo(c5);
                  //m1.getListofCargos();
              } else {
                  Personnel p5 = new Personnel(name);
                  m1.addPersonnel(p5);
                  //m1.getListofPersonnels();
              }
              System.out.println("UPDATED MANIFEST: ");
              m1.getListofPersonnels();
              m1.getListofCargos();

              System.out.println("Enter y to add new entry, n to exit");
              String cont = myObj.nextLine();

              if(cont.equals("n")){
                  running = false;
              }
          }

                   
      
    }
}
