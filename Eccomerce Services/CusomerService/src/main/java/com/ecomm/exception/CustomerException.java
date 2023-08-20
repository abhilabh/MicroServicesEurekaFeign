package com.ecomm.exception;

public class CustomerException {
	public static  class CustomerIdNotFound extends RuntimeException{
		public CustomerIdNotFound(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class CustomerIdAlreadyExist extends RuntimeException{
		public CustomerIdAlreadyExist(String message) {
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
