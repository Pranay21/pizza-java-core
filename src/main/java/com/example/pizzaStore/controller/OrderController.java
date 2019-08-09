package com.example.pizzaStore.controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pizzaStore.dao.Orders;
import com.example.pizzaStore.modal.PizzaOrders;
import com.example.pizzaStore.util.SortByDate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pizza")
public class OrderController {
	@Autowired
	private Orders dao;
	String line;
	@PostMapping("/addOrders")
	public String bookTicket(@RequestBody PizzaOrders tickets) {
		dao.save(tickets);
		return "successfully ordered";
	}

	@GetMapping("/getOrders")
	public List<PizzaOrders> getTickets() {
		return (List<PizzaOrders>) dao.findAll();
	}
	@GetMapping("/save")
	public String saveTicketInfo() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/OrderList.txt"));
			File file = new File("C:\\Users\\prbhat\\Desktop\\pizza\\file.txt");
			FileOutputStream fos = new FileOutputStream(file);
			 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			List<PizzaOrders> list = new ArrayList<PizzaOrders>();
			
			while((line=br.readLine())!=null) {
				String formatedString = line.trim().replaceAll(" +", " ");
				String[] data = formatedString.split(" ");
				PizzaOrders t = new PizzaOrders();
				t.setItem(data[0]);
				t.setDate(data[1]);
				list.add(t);
				dao.save(t);
				
			}
			Collections.sort(list, new SortByDate());
			for(int i=0; i<list.size(); i++) {
				bw.write(list.get(i).getItem()+" "+ list.get(i).getDate());
				bw.newLine();	
			}
			bw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block 	
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "The data has been successfully saved";
	}


}