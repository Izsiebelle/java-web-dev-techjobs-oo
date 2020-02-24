package org.launchcode.techjobs_oo;

import java.util.Objects;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  Job)) return false;
        Job that = (Job) o;
        return id == that.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //ToString method
    @Override
    public String toString() {
        //construct ArrayList of Getters in order to choose correct option depending on what information is available
        List<Object> options = new ArrayList<>();
        options.add(getId());
        options.add(getName());
        options.add(getEmployer());
        options.add(getLocation());
        options.add(getPositionType());
        options.add(getCoreCompetency());
        int count = 0;

        //Construct object variables to represent getters in String output
        //Iterate through options to verify information, IF blank return:
        if (name.isBlank()&&employer.toString().isBlank()&&location.toString().isBlank()&&positionType.toString().isBlank()&&coreCompetency.toString().isBlank()) {
            return "OOPS! This job does not seem to exist.";
        }else{
            for (Object option:options) {
                if (option.toString().isEmpty()) {
                    options.set(count, "Data not available");
                }
                count++;
            }

        }
        return "ID: " + options.get(0) + "\n" +
                "Name: " + options.get(1) + "\n" +
                "employer: "+ options.get(2) + "\n" +
                "Location: "+ options.get(3) + "\n" +
                "positionType: "+ options.get(4) + "\n" +
                "coreCompetency: "+ options.get(5) + "\n";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
