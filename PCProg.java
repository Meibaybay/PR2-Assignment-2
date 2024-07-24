package a2_2201040174;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import utils.NotPossibleException;

public class PCProg {
    private static final Object YES = "Y";
    private Set<PC> objs;

    public PCProg() {
        objs = new Set<>();
    }
    public void createObjects() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write the model name: ");
        String model = sc.nextLine();

        System.out.print("Write the year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Write the manufacturer: ");
        String manufacturer = sc.nextLine();

        Set<String> comps = new Set<String>();

        PC pc = PCFactory.getInstance().createPC(model, year, manufacturer, comps);
        System.out.println("Add your component (Press Enter again to stop)");
        while (true) {
            System.out.print("Add a component: ");
            String comp = sc.nextLine();
            if(comp.trim().equals("")) {
                break;
            }
            if(comps.contains(comp)) {
                System.out.println("This component is already in here!");
                continue;
            }
            pc.addComp(comp);
        }

        if (!getObjects().contains(pc)) {
            this.objs.insert(pc);
            System.out.println(pc);
            System.out.println("Do you want to add another PC? [Y/N]");
            String toAdd = sc.nextLine().toUpperCase();

            if (toAdd.equals(YES)) {
                createObjects();
            }
        } else {
            System.out.println("This PC is already here!");
        }
    }


    public Set<PC> getObjects() {
        return objs;
    }
    public String displayReport() {
        if (!objs.isEmpty()) {
            Vector<PC> pcs = objs.getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[0]));
        } else {
            return null;
        }
    }

    public void saveReport(String report) {
        String fileName = "pcs.txt";
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PCProg prog = new PCProg();
        try {
            prog.createObjects();
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                System.out.println("Save report to file? [Y/N]");
                String toSave = sc.nextLine();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    System.out.println("Report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        System.out.println("~END~");
    }
}
