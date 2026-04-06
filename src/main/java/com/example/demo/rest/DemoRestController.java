package com.example.demo.rest;


import com.example.demo.dao.OrderHistoryRequest;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class DemoRestController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    private JsonMapper jsonMapper;

    public DemoRestController(UserService userService, ProductService productService, JsonMapper jsonMapper, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.jsonMapper = jsonMapper;
        this.orderService = orderService;
    }

    @PostMapping("/users/register")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return userService.createUser(newUser);
    }

    @PatchMapping("/users/{userId}/preferences")
    public UserEntity patchUser(@PathVariable int userId,
                                @RequestBody Map<String, Object> patchPayload) {

        UserEntity user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Id cannot be modified");
        }

        UserEntity patchedUser = jsonMapper.updateValue(user, patchPayload);

        return userService.update(patchedUser);
    }


    @PatchMapping("/users/{userId}")
    public UserEntity softDeleteUser(@PathVariable int userId,
                                     @RequestBody Map<String, Object> patchPayload) {

        UserEntity user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        Object statusValue = patchPayload.get("status");

        if (statusValue == null) {
            throw new RuntimeException("status is required");
        }

        user.setStatus(statusValue.toString());

        return userService.update(user);
    }

    @GetMapping("/users/active")
    public List<UserEntity> findAllActiveUsers() {
        return userService.findAllActiveUsers();
    }

    @GetMapping("/users")
    public List<UserEntity> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/products")
    public List<ProductEntity> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public ProductEntity getById(@PathVariable int productId){
       return productService.findById(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductEntity update(@RequestBody ProductEntity newProduct, @PathVariable int productId) {
        ProductEntity existingProduct = productService.findById(productId);

        if (existingProduct == null) {
            throw new RuntimeException("Product not found: " + productId);
        }

        existingProduct.setName(newProduct.getName());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setStock(newProduct.getStock());

        return productService.update(existingProduct);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/orders/history")
    public List<OrderEntity> getOrderHistory(@RequestBody OrderHistoryRequest request) {
        if (request.getUserId() == null || request.getUserId().isBlank()) {
            throw new RuntimeException("user_id is required");
        }

        LocalDate startDate = request.getStartDate() != null ? LocalDate.parse(request.getStartDate()) : null;
        LocalDate endDate = request.getEndDate() != null ? LocalDate.parse(request.getEndDate()) : null;

        return orderService.findOrderHistory(
                request.getUserId(),
                startDate,
                endDate,
                request.getStatus()
        );
    }

}