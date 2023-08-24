package com.ecomm.exception;

public class OrderException {
	public static  class OrderIdNotFound extends RuntimeException{
		public OrderIdNotFound(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class OrderIdAlreadyExist extends RuntimeException{
		public OrderIdAlreadyExist(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class ProductIdMissing extends RuntimeException{
		public ProductIdMissing(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class ProductQuantityMissing extends RuntimeException{
		public ProductQuantityMissing(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}

}
