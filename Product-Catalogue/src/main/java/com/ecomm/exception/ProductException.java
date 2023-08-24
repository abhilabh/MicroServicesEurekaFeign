package com.ecomm.exception;

public class ProductException {
	public static  class ProductIdNotFound extends RuntimeException{
		public ProductIdNotFound(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class ProductIdAlreadyExist extends RuntimeException{
		public ProductIdAlreadyExist(String message) {
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
