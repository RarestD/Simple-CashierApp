
# 🧾 Simple Cashier CLI App

A simple CLI-based cashier application built with Java.  
This project was created as part of my learning journey to understand Java fundamentals, OOP, and modular code design.

---

## 📦 Features

✅ Add products to cart  
✅ View cart contents  
✅ Remove items from cart  
✅ Checkout and generate receipt file  
✅ Simple text-based menu navigation  
✅ Configuration via `application.properties`  

---

## 🖥️ Example Usage

```
===== Cashier Rare's Store App  =====
==== MENU ====
1. Show all products
2. Add product to cart
3. Check cart
4. Check out
5. Add Product
6. Remove Product
x. Exit
> Select an option : 1
=================================================
All products
1. Indomie - Rp 3,500.00
2. Teh Botol - Rp 4,000.00
3. Sabun Mandi - Rp 2,500.00
```

---

## 🚀 Getting Started

### 📋 Prerequisites
- Java JDK 8 or higher
- Terminal / Command Prompt
- (Optional) IntelliJ IDEA for better experience

### 📥 Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/RarestD/Simple-CashierApp.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Simple-CashierApp
   ```
3. Compile the Java files:
   ```bash
   javac -d out src/main/Main.java src/main/entity/*.java src/main/repositories/*.java src/main/services/*.java src/main/util/*.java src/main/view/*.java
   ```
4. Run the application:
   ```bash
   java -cp out main.Main
   ```

---

## 🛠️ Built With
- [Java](https://www.oracle.com/java/) - Programming Language
- [Builder Pattern](https://refactoring.guru/design-patterns/builder) - For receipt creation
- [Properties File](https://docs.oracle.com/javase/tutorial/essential/environment/properties.html) - For configuration

---

## 🚧 Future Improvements
- 🔑 User authentication (Admin / Cashier roles)
- 💾 Database support (SQLite/MySQL) instead of file-based receipts
- 📊 Export sales report in CSV/PDF format
- 🧪 Unit tests with JUnit
- 🎨 Improve menu navigation with input validation

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙋‍♂️ Author

👤 **RarestD**  
- GitHub: [@RarestD](https://github.com/RarestD)
