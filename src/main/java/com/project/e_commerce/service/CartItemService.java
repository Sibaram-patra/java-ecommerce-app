package com.project.e_commerce.service;

import com.project.e_commerce.model.CartItem;
import java.util.List;

public interface CartItemService {
         CartItem addToCart(Long userId,Long productId,int quantity);
         List<CartItem> getCart(Long userId);
         CartItem updateQuantity(Long cartItemId,int quantity);
         void removeItem(Long cartItemId);
         void clearCart(Long userId);
}
