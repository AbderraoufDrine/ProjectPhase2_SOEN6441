package com.example.assignment3.Database;

import com.example.assignment3.models.RentalUnit;

import java.util.ArrayList;

/**
 * This is the mocked database of the rental units
 * in the system
 */

public class RentalUnitRepository {
    private ArrayList<RentalUnit> rentalUnitList = new ArrayList<>();

    /**
     * @return the if a unit has been
     * saved in the database
     */
    public boolean save(RentalUnit obj){

        return rentalUnitList.add(obj);
    }

    /**
     * @return the if a unit has been
     * deleted from the database
     */
    public boolean delete(RentalUnit obj){
        return rentalUnitList.remove(obj);
    }
    public RentalUnit get(int id) {
        RentalUnit obj = null;
        for (RentalUnit r : rentalUnitList)
            if (r.getId() == id)
                obj =  r;
        return obj;
    }

    /**
     * @return the unit stored
     * in the database who matches
     * the given ID
     */
    public RentalUnit getUnit(int Id){
        RentalUnit unit = null;
        for(RentalUnit r: rentalUnitList)
            if(r.getId() == Id)
                unit = r;
        return unit;
    }

    /**
     * @return all the units stored
     * in the database
     */
    public ArrayList<RentalUnit> getAll(){
        return rentalUnitList;
    }

    /**
     * @return all the rented units
     * stored in the database
     */
    public ArrayList<RentalUnit>  getAllRented(){
        ArrayList<RentalUnit> filteredList = new ArrayList<>();
        for(RentalUnit r: rentalUnitList)
            if(r.isRented())
                filteredList.add(r);

        return filteredList;
    }

    /**
     * @return all the vacant units
     * stored in the database
     */
    public ArrayList<RentalUnit>  getAllVacant(){
        ArrayList<RentalUnit> filteredList = new ArrayList<>();
        for(RentalUnit r: rentalUnitList)
            if(!r.isRented())
                filteredList.add(r);

        return filteredList;
    }

    /**
     * @return if a unit becomes
     * rented or vacant
     */
    public boolean update(int Id, boolean type){
        boolean flag = false;
        for(RentalUnit u: rentalUnitList)
            if(u.getId() == Id) {
                u.setRented(type);
                flag = true;
            }
        return flag;
    }

}
