# E-Commerce Application

A full-stack e-commerce web application built with Spring Boot and Thymeleaf, providing a comprehensive online shopping experience with role-based access control.

---

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Project Structure](#project-structure)
4. [Database Schema](#database-schema)
5. [Prerequisites](#prerequisites)
6. [Installation & Setup](#installation--setup)
7. [Default Credentials](#default-credentials)
8. [Application Routes](#application-routes)
9. [Security Features](#security-features)
10. [UI Features](#ui-features)
11. [Configuration](#configuration)
12. [Testing Guide](#testing-guide)
13. [Application Flow](#application-flow)
14. [Future Enhancements](#future-enhancements)
15. [Known Issues](#known-issues)
16. [Troubleshooting](#troubleshooting)
17. [Contributing](#contributing)
18. [License](#license)
19. [Author](#author)

---

## 🚀 Features

### User Features
- ✅ User Registration & Authentication
- ✅ Browse Products Catalog
- ✅ Shopping Cart Management
- ✅ Order Placement & History
- ✅ Responsive Design (Mobile & Desktop)
- ✅ Role-based Dashboard Redirects

### Admin Features
- ✅ Admin Dashboard with Statistics
- ✅ Product Management (Add, Edit, Delete)
- ✅ Order Management (View All Orders)
- ✅ User Management (View & Edit Users)
- ✅ Role-based Access Control
- ✅ Real-time Statistics Display

---

## 🛠️ Technologies Used

- **Backend Framework:** Spring Boot 3.5.4
- **Security:** Spring Security with BCrypt Password Encoding
- **Template Engine:** Thymeleaf
- **Database:** H2 (In-Memory Database)
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Maven
- **Java Version:** 21
- **Architecture:** MVC Pattern with Layered Architecture

---

## 📁 Project Structure
```
e-commerce/
├── src/
│   ├── main/
│   │   ├── java/com/project/e_commerce/
│   │   │   ├── bootstrap/
│   │   │   │   └── DataInitializer.java          # Initial data setup
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java           # Spring Security configuration
│   │   │   │   └── CustomAuthenticationSuccessHandler.java
│   │   │   ├── controller/
│   │   │   │   ├── AdminController.java          # Admin operations
│   │   │   │   ├── AuthController.java           # Login/Register
│   │   │   │   ├── CartItemController.java       # Cart management
│   │   │   │   ├── HomeController.java           # Home page
│   │   │   │   ├── OrderController.java          # Order operations
│   │   │   │   ├── ProductController.java        # Product CRUD
│   │   │   │   └── UserController.java           # User management
│   │   │   ├── model/
│   │   │   │   ├── User.java                     # User entity
│   │   │   │   ├── Product.java                  # Product entity
│   │   │   │   ├── Order.java                    # Order entity
│   │   │   │   └── CartItem.java                 # Cart item entity
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── ProductRepository.java
│   │   │   │   ├── OrderRepository.java
│   │   │   │   └── CartItemRepository.java
│   │   │   ├── service/
│   │   │   │   ├── UserService.java              # User service interface
│   │   │   │   ├── ProductService.java           # Product service interface
│   │   │   │   ├── OrderService.java             # Order service interface
│   │   │   │   ├── CartItemService.java          # Cart service interface
│   │   │   │   └── impl/
│   │   │   │       ├── UserServiceImpl.java
│   │   │   │       ├── ProductServiceImpl.java
│   │   │   │       ├── OrderServiceImpl.java
│   │   │   │       └── CartItemServiceImpl.java
│   │   │   └── ECommerceApplication.java         # Main application
│   │   └── resources/
│   │       ├── templates/                         # Thymeleaf templates
│   │       │   ├── home.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   ├── products.html
│   │       │   ├── product-form.html
│   │       │   ├── cart.html
│   │       │   ├── orders.html
│   │       │   ├── admin-dashboard.html
│   │       │   ├── admin-products.html
│   │       │   ├── admin-orders.html
│   │       │   ├── admin-users.html
│   │       │   └── user-form.html
│   │       └── application.properties
│   └── test/
└── pom.xml
```

---

## 🗄️ Database Schema

### Entity Relationship Diagram
```
┌─────────────┐         ┌─────────────┐         ┌─────────────┐
│    USERS    │────────>│   ORDERS    │────────>│  CART_ITEMS │
└─────────────┘   1:N   └─────────────┘   1:N   └─────────────┘
      │                                                  │
      │                                                  │
      │                                                  │ N:1
      │ 1:N                                              │
      │                                                  ▼
      └───────────────────────────────────────>┌─────────────┐
                                                │  PRODUCTS   │
                                                └─────────────┘
```

### Tables

**USERS**
```sql
- id (BIGINT, PK, AUTO_INCREMENT)
- username (VARCHAR(255), UNIQUE, NOT NULL)
- email (VARCHAR(255), UNIQUE, NOT NULL)
- password (VARCHAR(255), NOT NULL) -- BCrypt hashed
- role (VARCHAR(255), NOT NULL)     -- ROLE_USER or ROLE_ADMIN
```

**PRODUCTS**
```sql
- id (BIGINT, PK, AUTO_INCREMENT)
- name (VARCHAR(255), NOT NULL)
- description (VARCHAR(1000))
- price (DOUBLE, NOT NULL)
- stock (INT, NOT NULL)
- imageUrl (VARCHAR(1000))
```

**ORDERS**
```sql
- id (BIGINT, PK, AUTO_INCREMENT)
- user_id (BIGINT, FK → users.id, NOT NULL)
- orderDate (TIMESTAMP)
- status (VARCHAR(255))
```

**CART_ITEMS**
```sql
- id (BIGINT, PK, AUTO_INCREMENT)
- user_id (BIGINT, FK → users.id, NOT NULL)
- product_id (BIGINT, FK → products.id, NOT NULL)
- quantity (INT, NOT NULL)
- order_id (BIGINT, FK → orders.id, NULLABLE)
```

---

## ⚙️ Prerequisites

- **Java:** Version 21 or higher
- **Maven:** Version 3.6 or higher
- **IDE:**  Eclipse 
- **Browser:** Modern web browser (Chrome, Firefox, Edge)
- **Memory:** Minimum 2GB RAM
- **Disk Space:** 500MB free space

---

## 🔧 Installation & Setup

### Step 1: Clone the Repository
```bash
git clone https://github.com/Sibaram-patra/java-ecommerce-app.git
cd java-ecommerce-app
```

### Step 2: Database Configuration

The application uses **H2 in-memory database** by default. Configuration is in `src/main/resources/application.properties`:
```properties
#########################################
# APPLICATION & SERVER CONFIGURATION
#########################################
spring.application.name=e-commerce
server.port=8080

#########################################
# H2 DATABASE CONFIGURATION
#########################################
spring.datasource.url=jdbc:h2:mem:ecommerce_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

#########################################
# JPA / HIBERNATE CONFIGURATION
#########################################
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#########################################
# THYMELEAF CONFIGURATION
#########################################
spring.thymeleaf.cache=false
```

### Step 3: Build the Project
```bash
mvn clean install
```

### Step 4: Run the Application
```bash
mvn spring-boot:run
```

### Step 5: Access the Application

- **Main Application:** http://localhost:8080
- **H2 Console:** http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:ecommerce_db`
  - Username: `sa`
  - Password: `password`

### Step 6: Verify Installation

1. Open browser and go to http://localhost:8080
2. You should see the home page with product catalog
3. Click "Login" to access the login page
4. Use default credentials (see below)

---

## 👤 Default Credentials

The application creates default users automatically on startup via `DataInitializer`:

### Admin Account
```
Username: admin
Password: admin123
Role: ROLE_ADMIN
Access: Full admin dashboard and all features
```

### Test User Account
```
Username: user
Password: user123
Role: ROLE_USER
Access: Shopping features only (no admin access)
```

---

## 🌐 Application Routes

### Public Routes (No Authentication Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page (redirects to /home) |
| GET | `/home` | Product catalog home page |
| GET | `/login` | Login page |
| POST | `/login` | Process login credentials |
| GET | `/register` | User registration form |
| POST | `/register` | Process registration |
| GET | `/products` | View all products |
| GET | `/logout` | Logout user |

### User Routes (Authentication Required - ROLE_USER or ROLE_ADMIN)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/cart` | View shopping cart |
| POST | `/cart/add` | Add product to cart<br>Params: `productId`, `quantity` |
| GET | `/orders` | View user's order history |
| POST | `/orders/place` | Place order from cart items |

### Admin Routes (ROLE_ADMIN Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/dashboard` | Admin dashboard with statistics |
| GET | `/admin/products` | List all products (admin view) |
| GET | `/admin/products/new` | Create new product form |
| POST | `/admin/products` | Save product (create/update) |
| GET | `/admin/products/edit/{id}` | Edit existing product |
| POST | `/admin/products/delete/{id}` | Delete product |
| GET | `/admin/orders` | View all system orders |
| GET | `/admin/users` | List all users |
| GET | `/users/{id}/edit` | Edit user form |
| POST | `/users` | Save user changes |

---

## 🔐 Security Features

### Authentication & Authorization
- **Password Encryption:** BCrypt hashing algorithm
- **Role-Based Access Control:** Two roles (ADMIN, USER)
- **Custom Success Handler:** Redirects based on user role
  - Admin → `/admin/dashboard`
  - User → `/home`
- **Session Management:** Server-side session storage
- **Form-Based Login:** Traditional username/password authentication

### Security Configuration Highlights
```java
// From SecurityConfig.java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/", "/home", "/login", "/register").permitAll()
    .requestMatchers("/admin/**").hasRole("ADMIN")
    .requestMatchers("/products").permitAll()
    .anyRequest().authenticated()
)
```

### Protected Resources
- All admin routes require ROLE_ADMIN
- Cart and order operations require authentication
- Static resources (CSS, JS, images) are publicly accessible
- CSRF protection is currently disabled (for development)

---

## 🎨 UI Features

### Responsive Design
- **Mobile-First Approach:** Optimized for mobile devices
- **Breakpoint:** 768px for tablet/desktop view
- **Mobile View:** Card-based layout
- **Desktop View:** Table-based layout

### Design Elements
- Clean and intuitive interface
- Color-coded status badges (Pending/Completed)
- Success/error message notifications
- Consistent styling across all pages
- Easy navigation with breadcrumbs

### Page-Specific Features

**Home Page:**
- Product grid display
- Responsive columns (1-4 based on screen size)
- Add to cart buttons

**Admin Dashboard:**
- Statistics cards showing:
  - Total Products
  - Total Orders
  - Total Users
- Quick navigation to management pages

**Product Management:**
- Product listing with edit/delete options
- Form validation
- Image URL support
- Stock management

**Cart Page:**
- Item listing with quantities
- Subtotal calculations
- Continue shopping link
- Place order button

---

## ⚙️ Configuration

### Application Properties
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:h2:mem:ecommerce_db
spring.datasource.username=sa
spring.datasource.password=password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Thymeleaf Configuration
spring.thymeleaf.cache=false

# H2 Console
spring.h2.console.enabled=true
```

### Changing Database

To switch to MySQL/PostgreSQL:

1. Add dependency in `pom.xml`:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## 🧪 Testing Guide

### Manual Browser Testing

#### As Regular User:

1. **Registration Flow:**
   - Go to http://localhost:8080/register
   - Fill form (username, email, password)
   - Submit → Should redirect to login page

2. **Login Flow:**
   - Go to http://localhost:8080/login
   - Enter credentials: `user` / `user123`
   - Submit → Should redirect to `/home`

3. **Shopping Flow:**
   - Browse products on home page
   - Click "Add to Cart" on any product
   - Go to http://localhost:8080/cart
   - Click "Place Order"
   - Go to http://localhost:8080/orders to view order

4. **Logout:**
   - Click logout link
   - Should redirect to login page

#### As Admin:

1. **Login as Admin:**
   - Go to http://localhost:8080/login
   - Enter: `admin` / `admin123`
   - Should redirect to `/admin/dashboard`

2. **Product Management:**
   - From dashboard, click "Manage Products"
   - Click "+ Add New Product"
   - Fill form:
     - Name: Test Laptop
     - Description: High performance laptop
     - Price: 999.99
     - Stock: 50
   - Submit → Product created

3. **Edit Product:**
   - Click "Edit" on any product
   - Modify details
   - Save → Product updated

4. **Delete Product:**
   - Click "Delete" on any product
   - Confirm → Product deleted

5. **View Orders:**
   - Click "Manage Orders"
   - See all system orders

6. **Manage Users:**
   - Click "Manage Users"
   - Click "Edit" on any user
   - Change role between ROLE_USER and ROLE_ADMIN
   - Save

### Testing Checklist

- [ ] User registration works
- [ ] User login works
- [ ] Admin login redirects to dashboard
- [ ] User login redirects to home
- [ ] Products display correctly
- [ ] Add to cart functionality works
- [ ] Cart displays items
- [ ] Place order creates order
- [ ] Order history shows orders
- [ ] Admin can add products
- [ ] Admin can edit products
- [ ] Admin can delete products
- [ ] Admin can view all orders
- [ ] Admin can manage users
- [ ] Logout functionality works
- [ ] Role-based access control works
- [ ] Responsive design works on mobile

---

## 📊 Application Flow

### 1. Application Startup Flow
```
Spring Boot Starts
    ↓
Database Initializes (H2)
    ↓
DataInitializer.init() Runs (@PostConstruct)
    ↓
Creates Admin User (admin/admin123/ROLE_ADMIN)
    ↓
Creates Test User (user/user123/ROLE_USER)
    ↓
Application Ready on Port 8080
```

### 2. Authentication Flow
```
User Accesses Protected Route
    ↓
Spring Security Checks Authentication
    ↓
If Not Authenticated → Redirect to /login
    ↓
User Submits Credentials (POST /login)
    ↓
CustomUserDetailsService Loads User from DB
    ↓
Password Verified (BCrypt)
    ↓
If Valid → CustomAuthenticationSuccessHandler
    ↓
    ├── ROLE_ADMIN → /admin/dashboard
    └── ROLE_USER → /home
```

### 3. Shopping Flow (User)
```
Browse Products (/home or /products)
    ↓
Click "Add to Cart"
    ↓
POST /cart/add (productId, quantity)
    ↓
CartItem Created in Database
    ↓
View Cart (/cart)
    ↓
Click "Place Order"
    ↓
POST /orders/place
    ↓
Order Created with Status="PENDING"
    ↓
Cart Items Linked to Order
    ↓
Redirect to /orders (Order History)
```

### 4. Product Management Flow (Admin)
```
Admin Login → Dashboard
    ↓
Click "Manage Products"
    ↓
GET /admin/products (List View)
    ↓
Click "+ Add New Product"
    ↓
GET /admin/products/new (Form)
    ↓
Fill Form & Submit
    ↓
POST /admin/products
    ↓
Product Saved to Database
    ↓
Redirect to /admin/products?success
```

---

## 🎯 Future Enhancements

### High Priority
- [ ] **Order Total Calculation** - Add totalAmount field to Order entity
- [ ] **Stock Validation** - Prevent ordering when stock is insufficient
- [ ] **CSRF Protection** - Enable CSRF tokens for production security
- [ ] **Input Validation** - Add @Valid annotations and error handling

### Medium Priority
- [ ] **Product Search** - Search by name or description
- [ ] **Product Categories** - Organize products into categories
- [ ] **Pagination** - Paginate product and order lists
- [ ] **User Profile** - Allow users to edit their profile
- [ ] **Order Status Updates** - Admin can update order status (Shipped, Delivered)

### Low Priority
- [ ] **Email Notifications** - Send order confirmation emails
- [ ] **Payment Integration** - Stripe or PayPal integration
- [ ] **Product Reviews** - User reviews and ratings
- [ ] **Wishlist** - Save products for later
- [ ] **Order Tracking** - Track order delivery status
- [ ] **Discount Coupons** - Apply discount codes
- [ ] **Product Images Upload** - Upload images instead of URLs
- [ ] **Advanced Search** - Filter by price, category, etc.

### Technical Improvements
- [ ] **REST API** - Build separate API for mobile apps
- [ ] **Unit Tests** - Add comprehensive test coverage
- [ ] **Integration Tests** - Test complete user flows
- [ ] **Logging** - Implement proper logging framework
- [ ] **Database Migration** - Move to PostgreSQL/MySQL
- [ ] **Docker Support** - Containerize the application
- [ ] **CI/CD Pipeline** - Automated testing and deployment

---

## 🐛 Known Issues

1. **CSRF Protection Disabled**
   - Status: Disabled for development ease
   - Impact: Security vulnerability in production
   - Solution: Enable CSRF and add tokens to forms

2. **No Order Total Calculation**
   - Status: totalAmount field not implemented
   - Impact: Cannot display order total
   - Solution: Add totalAmount field and calculation logic

3. **No Stock Validation**
   - Status: Can order more than available stock
   - Impact: May result in negative stock
   - Solution: Add validation in OrderService

4. **Image URL Length Limit**
   - Status: Limited to 1000 characters
   - Impact: Very long URLs may be truncated
   - Solution: Increase limit or implement image upload

5. **Session-Based Authentication**
   - Status: Uses server-side sessions
   - Impact: Not suitable for distributed systems
   - Solution: Consider JWT tokens for stateless auth

6. **In-Memory Database**
   - Status: Data lost on restart
   - Impact: Not suitable for production
   - Solution: Migrate to persistent database

---

## 🔧 Troubleshooting

### Port Already in Use
```
Error: Port 8080 is already in use
Solution: Change port in application.properties
    server.port=8081
```

### Database Connection Error
```
Error: Cannot connect to H2 database
Solution: Check H2 console settings match application.properties
```

### Login Fails with Correct Credentials
```
Error: Login fails even with correct password
Solution: 
1. Check if DataInitializer ran successfully
2. Verify passwords are BCrypt encoded
3. Check console logs for authentication errors
```

### 403 Forbidden on Admin Routes
```
Error: Access denied when accessing /admin/dashboard
Solution:
1. Verify user has ROLE_ADMIN (not just "ADMIN")
2. Check SecurityConfig role configuration
3. Verify CustomUserDetailsService uses authorities() not roles()
```

### WhiteLabel Error Page
```
Error: Generic error page appears
Solution:
1. Check console logs for stack trace
2. Verify template names match controller return values
3. Check entity field names match Thymeleaf expressions
```

### Product Image Not Displaying
```
Error: Image URL too long or broken
Solution:
1. Use shorter URLs
2. Verify URL is valid and accessible
3. Check imageUrl field length (max 1000 chars)
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

### How to Contribute

1. **Fork the repository**
2. **Create a feature branch**
```bash
   git checkout -b feature/amazing-feature
```
3. **Commit your changes**
```bash
   git commit -m 'Add some amazing feature'
```
4. **Push to the branch**
```bash
   git push origin feature/amazing-feature
```
5. **Open a Pull Request**

### Contribution Guidelines

- Write clear, commented code
- Follow existing code style
- Add tests for new features
- Update documentation
- Test thoroughly before submitting

### Reporting Issues

When reporting issues, please include:
- Detailed description
- Steps to reproduce
- Expected vs actual behavior
- Screenshots (if applicable)
- Console error logs
- System information (OS, Java version)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
```
MIT License

Copyright (c) 2025 Sibaram Patra

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 👨‍💻 Author

**Sibaram Patra**

- GitHub: [@Sibaram-patra](https://github.com/Sibaram-patra)
- Email: [your-email@example.com](mailto:your-email@example.com)
- LinkedIn: [Your LinkedIn Profile](https://linkedin.com/in/your-profile)

---

## 🙏 Acknowledgments

- **Spring Boot Team** - For the excellent framework
- **Spring Security** - For robust security features
- **Thymeleaf** - For server-side template engine
- **H2 Database** - For easy development database
- **Maven** - For dependency management
- **Stack Overflow Community** - For troubleshooting help

---

## 📚 Additional Resources

### Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Reference](https://spring.io/projects/spring-security)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [H2 Database Documentation](https://www.h2database.com/html/main.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

### Tutorials
- [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- [Building a Web Application](https://spring.io/guides/gs/serving-web-content/)
- [Securing a Web Application](https://spring.io/guides/gs/securing-web/)

---

## 📞 Support

If you encounter any issues or have questions:

1. **Check Documentation** - Review this README thoroughly
2. **Check Issues** - Look through existing GitHub issues
3. **Create Issue** - Open a new issue with details
4. **Email** - Contact author directly

---

## ⭐ Show Your Support

If you found this project helpful, please consider:
- Giving it a ⭐️ on GitHub
- Sharing it with others
- Contributing improvements
- Reporting bugs

---

**Happy Coding! 🚀**

---

*Last Updated: October 2025*
*Version: 1.0.0*
