package com.bookstore.api.service.impl;

import com.bookstore.api.exception.BookNotFoundException;
import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.dto.ChangeQuantityInCartRequest;
import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.entity.Cart;
import com.bookstore.api.model.entity.CartItem;
import com.bookstore.api.model.entity.User;
import com.bookstore.api.model.mapper.CartItemMapper;
import com.bookstore.api.repository.BookRepository;
import com.bookstore.api.repository.CartItemRepository;
import com.bookstore.api.repository.CartRepository;
import com.bookstore.api.repository.UserRepository;
import com.bookstore.api.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public List<CartItemDTO> getCartItems(String username) {
        User user = userRepository.findUserByUsername(username);
        Optional<Cart> cart = cartRepository.findByUser(user);
        if (cart.isEmpty()){
            createEmptyCartByUsername(username);
            return new ArrayList<>();
        }
        return CartItemMapper.toDtoList(cartItemRepository.findByCart(cart.get()));
    }

    @Override
    public CartItemDTO addBookToCart(AddBookToCartRequest request) {
        Optional<Book> book = bookRepository.findById(request.getBookId());
        if (book.isEmpty()){
            throw new BookNotFoundException(request.getBookId());
        }
        Cart cart = getCartByUsername(request.getUsername())
                .orElseGet(() -> createEmptyCartByUsername(request.getUsername()));

        Optional<CartItem> foundItem = cartItemRepository.findByCartAndBook(cart, book.get());
        if (foundItem.isPresent()){
            CartItem itemToModify = foundItem.get();
            itemToModify.setQuantity(itemToModify.getQuantity() + request.getQuantity());
            itemToModify = cartItemRepository.save(itemToModify);
            return CartItemMapper.toDto(itemToModify);
        } else {
            CartItem newItem = new CartItem();
            newItem.setBook(book.get());
            newItem.setCart(cart);
            newItem.setQuantity(request.getQuantity());
            newItem = cartItemRepository.save(newItem);
            return CartItemMapper.toDto(newItem);
        }
    }

    @Override
    public void removeBookFromCart(Long bookId, String username){
        Optional<CartItem> cartItem = getCartItemByBookIdAndUsername(bookId, username);
        cartItem.ifPresent(cartItemRepository::delete);
    }

    @Override
    public void changeQuantityInCart(ChangeQuantityInCartRequest request) {
        Optional<CartItem> optionalCartItem = getCartItemByBookIdAndUsername(request.getBookId(), request.getUsername());
        if (optionalCartItem.isPresent()){
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(request.getQuantity());
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public Optional<Cart> getCartByUsername(String username){
        User user = userRepository.findUserByUsername(username);
        return cartRepository.findByUser(user);
    }

    @Override
    public void emptyCart(String username){
        Optional<Cart> cart = getCartByUsername(username);
        cart.ifPresent(cartItemRepository::deleteByCart);
    }

    private Optional<CartItem> getCartItemByBookIdAndUsername(Long bookId, String username){
        Optional<Cart> cart = getCartByUsername(username);
        if (cart.isEmpty()){
            return Optional.empty();
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        return cartItemRepository.findByCartAndBook(cart.get(), book);
    }

    private Cart createEmptyCartByUsername(String username){
        User user = userRepository.findUserByUsername(username);
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
