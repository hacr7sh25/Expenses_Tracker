# Expense Tracker

## Overview
This is a simple Expense Tracker application built using Java Swing. It allows users to add expenses, categorize them, view expenses in a table, and save/load expenses from a file.

## Features
- Add expenses with amount, category, and date
- View all expenses in a table format
- Save expenses to a file for persistence
- Load previously saved expenses when the application starts

## Installation
### Prerequisites:
- Install Java Development Kit (JDK) (Version 8 or later)
- Install an IDE (such as IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

### Steps to Run:
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/expense-tracker.git
   ```
2. Navigate to the project folder and open it in an IDE.
3. Compile and run the `ExpenseTracker.java` file.

## Usage
1. Enter the amount, category, and date in the provided fields.
2. Click **Add Expense** to add it to the table.
3. Click **Save Expenses** to save all records to a file.
4. The application automatically loads previously saved expenses on startup.

## File Handling
- The expenses are stored in a file named `expenses.txt`.
- Each expense is saved in the format: `Amount,Category,Date`.
- The application loads this file at startup if it exists.

## Technologies Used
- Java Swing (GUI)
- File Handling (BufferedReader & BufferedWriter)

## Future Enhancements
- Add expense filtering by category or date.
- Implement a monthly expense summary.
- Integrate with a database for better data management.

## Contributing
Feel free to contribute by submitting issues or pull requests!

## License
This project is licensed under the MIT License.

