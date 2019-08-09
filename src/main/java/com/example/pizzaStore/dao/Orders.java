package com.example.pizzaStore.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pizzaStore.modal.PizzaOrders;

public interface Orders extends CrudRepository<PizzaOrders, Integer>{


}