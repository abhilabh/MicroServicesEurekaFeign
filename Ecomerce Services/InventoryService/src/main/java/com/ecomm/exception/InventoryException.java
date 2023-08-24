package com.ecomm.exception;

public class InventoryException {
	public static  class InventoryIdNotFound extends RuntimeException{
		public InventoryIdNotFound(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
	}
	
	public static  class InventoryIdAlreadyExist extends RuntimeException{
		public InventoryIdAlreadyExist(String message) {
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
