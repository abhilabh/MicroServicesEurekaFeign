package com.ecomm.exception;

public class CartException {
	public static  class CartIdNotFound extends RuntimeException{
		public CartIdNotFound(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class CartIdAlreadyExist extends RuntimeException{
		public CartIdAlreadyExist(String message) {
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
