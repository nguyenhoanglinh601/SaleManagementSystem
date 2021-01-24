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
public class ListStaff {
    List<Staff> list = new ArrayList<>();

    public ListStaff() {
    }
    public ListStaff(List<Staff> list) {
        this.list=list;
    }

    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }
}
