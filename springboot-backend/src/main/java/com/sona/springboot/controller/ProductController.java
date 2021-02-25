package com.sona.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sona.springboot.exception.ResourceNotFoundException;
import com.sona.springboot.model.Product;
import com.sona.springboot.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 *  get all products
	 * @return
	 */
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}		
	
	/**
	 *  create product rest api
	 * @param product
	 * @return
	 */
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	/**
	 *  get product by id rest api
	 * @param prod_id
	 * @return
	 */
	@GetMapping("/products/{prod_id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long prod_id) {
		Product product = productRepository.findById(prod_id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + prod_id));
		return ResponseEntity.ok(product);
	}
	
	/**
	 *  update employee rest api
	 * @param prod_id
	 * @param productDetails
	 * @return
	 */
	
	@PutMapping("/products/{prod_id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long prod_id, @RequestBody Product productDetails){
		Product product = productRepository.findById(prod_id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + prod_id));
		
		product.setProdName(productDetails.getProdName());
		product.setProdBrand(productDetails.getProdBrand());
		product.setProdPrice(productDetails.getProdPrice());
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	/**
	 * delete product rest api
	 * @param prod_id
	 * @return
	 */
	@DeleteMapping("/products/{prod_id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long prod_id){
		Product product = productRepository.findById(prod_id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + prod_id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
