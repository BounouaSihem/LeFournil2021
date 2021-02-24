package fr.fournil.bakery.model.entities;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




public class ProductForm {
	
	
	 @Min(value = 1)
	    private Integer quantity;
	   @NotNull
	    private Long productId;
	   @NotNull
	    private  String formatChoosen;
	   @NotNull
	    private String frequencyCommandeProduct;
		public ProductForm() {
			super();
		}
		public ProductForm(@Min(1) Integer quantity,@NotNull Long productId,@NotNull String formatChoosen,
				@NotEmpty String frequencyCommandeProduct) {
			super();
			this.quantity = quantity;
			this.productId = productId;
			this.formatChoosen = formatChoosen;
			this.frequencyCommandeProduct = frequencyCommandeProduct;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public String getFormatChoosen() {
			return formatChoosen;
		}
		public void setFormatChoosen(String formatChoosen) {
			this.formatChoosen = formatChoosen;
		}
		public String getFrequencyCommandeProduct() {
			return frequencyCommandeProduct;
		}
		public void setFrequencyCommandeProduct(String frequencyCommandeProduct) {
			this.frequencyCommandeProduct = frequencyCommandeProduct;
		}
		
	    
	    

}
