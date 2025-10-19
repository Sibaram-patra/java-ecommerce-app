package com.project.e_commerce.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="orders")
public class Order {
     
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	private LocalDateTime orderDate;
	
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<CartItem> item;
	
	 public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public User getUser() { return user; }
	    public void setUser(User user) { this.user = user; }

	    public LocalDateTime getOrderDate() { return orderDate; }
	    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public List<CartItem> getItems() { return item; }
	    public void setItems(List<CartItem> items) { this.item = items; }

}
