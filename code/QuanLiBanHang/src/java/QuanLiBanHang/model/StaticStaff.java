/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanv
 */
public class StaticStaff extends Staff{
    List<Staff> list = new ArrayList<>();

    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }

    public StaticStaff(int idStaff, String name, String numberPhone, String address, String username, String password, boolean access) {
        super(idStaff, name, numberPhone, address, username, password, access);
    }

    public StaticStaff() {
    }
    
}
