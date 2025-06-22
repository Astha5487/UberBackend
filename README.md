A backend implementation of an Uber-like ride booking system, simulating real-time ride requests, intelligent driver assignment, OTP verification, rating updates, and secure wallet/cash payments. Built using Spring Boot with PostgreSQL and PostGIS for geospatial support.

🔧 Tech Stack
Backend: Spring Boot (Spring Security, Spring Data JPA, Spring Mail)

Database: PostgreSQL with PostGIS extension (for spatial queries)

Auth: JWT-based authentication & Role-based access (Driver, Rider)

Testing: JUnit, Mockito, TestContainers (Dynamic PostgreSQL setup)

APIs Used: OSRM API (for travel distance & duration calculations)

✅ Features
🧑‍🚀 User Authentication & Roles
Signup & login with JWT tokens

Roles: RIDER, DRIVER, ADMIN

Onboarding flow for driver with vehicle info

📍 Ride Management
Riders can request rides by specifying pickup & drop-off locations

Drivers can accept, cancel, start (with OTP), or end rides

OTP verification before ride start

📊 Driver Matching Strategies
Proximity-based matching (nearest drivers)

Rating-based matching (top-rated drivers nearby)

Modular strategy pattern makes it easy to switch strategies

💰 Payment System
Supports Wallet-based and Cash payments

Platform commission logic built-in

Rider wallet deducted; driver wallet credited

Transaction logs maintained

🧾 Ride Fare Calculation
Fare based on distance using OSRM API

Surge pricing applied during peak hours (6 PM to 9 PM)

⭐ Rating System
Riders can rate drivers & vice versa post-ride

Rating is updated using running average formula

📬 Email Notifications
Account creation, ride confirmation, and other events trigger SMTP-based emails

🧪 Testing
Integration testing setup using TestContainers for PostgreSQL

Unit testing with JUnit & Mockito

📂 Project Structure
bash
Copy
Edit
src
├── controllers          # API endpoints
├── dto                 # Data Transfer Objects
├── entities            # Database entities
├── enums               # Enum types (e.g. roles, payment status)
├── repositories        # Spring Data JPA Repositories
├── services            # Business logic layer
├── strategies          # Fare, driver matching, payment strategy patterns
├── utils               # Helper utilities (e.g., GeometryUtil)
└── security            # JWT token and auth config
