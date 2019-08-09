package com.example.pizzaStore.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PizzaOrders implements Comparable< PizzaOrders > {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String item;
	private String date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	
    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }
 
    @Override
    public int compareTo(PizzaOrders o) {
        return this.getDate().compareTo(o.getDate());
    }
}