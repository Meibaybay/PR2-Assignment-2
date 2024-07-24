package a2_2201040174;

import utils.NotPossibleException;

public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;

    public PC (String model, int year, String manufacturer, Set<String> comps) {
        if (validateModel(model)) {
            this.model = model;
        } else {
            throw new NotPossibleException("Invalid!");
        }
        if (validateYear(year)) {
            this.year = year;
        } else {
            throw new NotPossibleException("Invalid!");
        }
        if (validateManufacturer(manufacturer)) {
            this.manufacturer = manufacturer;
        } else {
            throw new NotPossibleException("Invalid!");
        }
        this.comps =  comps;
    }
    public boolean validateModel(String model) {
        return !model.isEmpty() && model.length() <= 20;
    }
    public boolean validateYear(int year) {
        return year >=1984;
    }
    public boolean validateManufacturer (String manufacturer) {
        return !manufacturer.isEmpty() && manufacturer.length() <= 15;
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public void addComp(String comp) {
        this.comps.insert(comp);
    }
    public Set<String> getComps(){
        return comps;
    }
    public void setComps(Set<String> comps){
        this.comps = comps;
    }

    public String toString() {

        return "PC <"+ model +", " + year +", " + manufacturer+ ", " +comps.toString() +">";
    }

    public boolean equals(Object object ) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PC otherPC = (PC) object;
        return year == otherPC.getYear() && model.equals(otherPC.model) && manufacturer.equals(otherPC.manufacturer) && comps.equals(otherPC.comps);
    }

}
