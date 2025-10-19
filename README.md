# E-Commerce Application

A full-stack e-commerce web application built with Spring Boot, providing a comprehensive online shopping experience.

## 🚀 Features

- User Authentication & Authorization
- Product Management (CRUD operations)
- Shopping Cart functionality
- Order Management
- User Profile Management
- Admin Dashboard
- RESTful API architecture

## 🛠️ Technologies Used

- **Backend:** Spring Boot, Spring MVC, Spring Data JPA
- **Database:** MySQL/PostgreSQL
- **Build Tool:** Maven
- **Java Version:** 17+
- **Architecture:** MVC Pattern with layered architecture

## 📁 Project Structure
```
e-commerce/
├── src/main/java/com/project/e_commerce/
│   ├── controller/     # REST Controllers
│   ├── service/        # Business Logic Layer
│   ├── repository/     # Data Access Layer
│   ├── model/          # Entity Classes
│   └── config/         # Configuration Classes
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

## ⚙️ Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL/PostgreSQL database
- IDE (Eclipse/IntelliJ IDEA/VS Code)

## 🔧 Installation & Setup

1. **Clone the repository**
```bash
   git clone https://github.com/Sibaram-patra/java-ecommerce-app.git
   cd java-ecommerce-app
```

2. **Configure Database**
   
   Update `src/main/resources/application.properties`:
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
```

3. **Build the project**
```bash
   mvn clean install
```

4. **Run the application**
```bash
   mvn spring-boot:run
```

5. **Access the application**
   
   Open your browser and navigate to: `http://localhost:8080`

## 📋 API Endpoints

### User Management
- `POST /api/users/register` - Register new user
- `POST /api/users/login` - User login
- `GET /api/users/{id}` - Get user details

### Product Management
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product (Admin)
- `PUT /api/products/{id}` - Update product (Admin)
- `DELETE /api/products/{id}` - Delete product (Admin)

### Cart Management
- `GET /api/cart` - Get user cart
- `POST /api/cart/items` - Add item to cart
- `DELETE /api/cart/items/{id}` - Remove item from cart

### Order Management
- `POST /api/orders` - Place new order
- `GET /api/orders` - Get user orders
- `GET /api/orders/{id}` - Get order details

## 🎯 Future Enhancements

- Payment Gateway Integration
- Email Notifications
- Product Search & Filtering
- Product Reviews & Ratings
- Wishlist functionality
- Order Tracking
- Discount & Coupon System

## 👨‍💻 Author

**Sibaram Patra**

- GitHub: [@Sibaram-patra](https://github.com/Sibaram-patra)
- LinkedIn: [Add your LinkedIn URL]

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the issues page.

---

⭐ **Star this repository if you found it helpful!**