package com.amqp;

import lombok.Data;


/**
 * RabbitMQ
 */
@Data
public class Car {

	private String carName;

	private String brand;

	public Car() {
	}

	public Car(String carName, String brand) {
		this.carName = carName;
		this.brand = brand;
	}
}
