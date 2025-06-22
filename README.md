# 🚖 UBER – Backend

A scalable **Uber-like ride-booking platform** backend built with **Spring Boot**, enabling real-time ride matching, secure authentication, OTP-verified rides, wallet/cash payments, and driver/rider rating. Integrated with **PostgreSQL + PostGIS** for spatial queries and **OSRM API** for accurate fare calculation.

---

## 🔧 Tech Stack

- **Java + Spring Boot** – REST APIs, Security, Mail
- **PostgreSQL + PostGIS** – Spatial database for geolocation
- **JWT** – Secure token-based authentication
- **JUnit + Mockito + TestContainers** – Unit & integration testing
- **SMTP (Gmail)** – For email notifications
- **OSRM API** – Distance & duration-based fare calculation

---

## ✅ Key Features

### 👤 Authentication & Roles

- **JWT-based signup/login**
- Role-based access for **Riders** and **Drivers**
- Driver onboarding with **vehicle registration**

### 📍 Ride Booking & Management

- Request, track, cancel rides (by Rider)
- Accept, start (with OTP), end rides (by Driver)
- Real-time state transitions of rides

### 📊 Modular Strategy Patterns

- **Driver Matching Strategy**:  
  - Proximity-based (default)  
  - High-rating-based (for premium riders)

- **Fare Calculation Strategy**:  
  - Base pricing using distance  
  - **Surge pricing** applied during 6 PM–9 PM

- **Payment Strategy**:  
  - Supports **Wallet** and **Cash** payments  
  - Wallet top-up and deduction managed via `WalletService`

### 💸 Wallet & Payment System

- Rider’s wallet is debited, Driver’s is credited
- **Platform commission** handled automatically
- Fallback support for cash payments
- **TransactionMethod enum** tracks purpose of funds

### ⭐ Rating System

- Post-ride feedback system
- Rating updated using weighted average
- Applies to both **Rider and Driver profiles**

### 🔐 OTP-Based Ride Start

- Secure ride start via OTP verification sent to Rider
- Driver must submit correct OTP to begin trip

### ✉️ Email Notifications

- Account creation, ride status updates via **SMTP**
- Configured using **Spring Mail + Gmail SMTP**

### 📦 Testing Support

- **TestContainers** for dynamic PostgreSQL setup
- **JUnit + Mockito** for robust unit testing
- Isolated tests with realistic data

---

## 🗺️ Spatial Intelligence

- Geospatial location support via **PostGIS**
- Nearest driver lookup based on Rider's coordinates
- **GeometryUtil** used for Point creation from latitude & longitude

---
## 📁 Project Structure

```text
src/
├── controllers/
├── dto/
├── entities/
├── enums/
├── repositories/
├── security/
├── services/
├── strategies/
├── utils/
└── UberAppApplication.java
```

---

## 🚀 Running the Application

### 🔧 Prerequisites

```text
- Java 17+
- Maven
- PostgreSQL (with PostGIS extension)
```

### ⚙️ Steps to Run

```bash
# 1. Clone the repository
git clone https://github.com/your-username/ride-booking-platform.git
cd ride-booking-platform
```

```bash
# 2. Configure application.properties
# ✅ Set your PostgreSQL credentials
# ✅ Add Gmail SMTP config
# ✅ Set JWT secret key
```

```bash
# 3. Run the application
./mvnw spring-boot:run
```

```text
Access APIs via Postman or Swagger (if enabled)
```

---

## 📬 Sample API Endpoints

| Method | Endpoint                        | Description                      |
|--------|----------------------------------|----------------------------------|
| POST   | /auth/signup                    | Register new Rider/Driver        |
| POST   | /auth/login                     | Login & receive JWT tokens       |
| POST   | /ride/request                   | Rider requests a ride            |
| POST   | /ride/start/{rideId}?otp=1234   | Driver starts ride (with OTP)    |
| POST   | /ride/end/{rideId}              | Driver ends the ride             |
| POST   | /rate/rider / /rate/driver      | Submit rating after ride         |

---

## 📦 Testing

```text
- UberAppApplicationTests.java        -> Email service functionality
- AuthServiceImplTest.java           -> Unit test for AuthService
- AuthControllerTest.java            -> Integration tests for signup & onboarding
- TestContainers                     -> PostgreSQL + PostGIS for isolated DB testing
```

---

## 🌟 Features

```text
- JWT-based login for Rider and Driver roles
- Onboarding new drivers with vehicle details
- Ride request creation and status updates
- OTP-based ride start verification
- Wallet and cash payment options
- Driver/Rider rating system
- Spatial queries for nearest drivers (PostGIS)
- Modular strategy patterns for:
  • Payment handling
  • Driver matching (proximity & rating based)
  • Ride fare calculation (default & surge-based)
- Email notifications using Spring Mail (SMTP)
```

---

## 📅 Future Enhancements

```text
- Live ride tracking with WebSockets
- Admin dashboard for ride/activity monitoring
- SMS alerts integration (e.g., Twilio)
- Convert to microservices for scalability
```

---
