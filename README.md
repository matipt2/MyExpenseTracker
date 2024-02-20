# Expense Tracker Application

Expense Tracker is a simple web application designed to help users track their expenses. It allows users to add, delete, and view their expenses, as well as filter them based on minimum and maximum values. Additionally, it provides statistics on the expenses, including the lowest, highest, and average costs.

## Features

- **Add Expense**: Users can add new expenses by providing a description and price.
- **Delete Expense**: Users can delete existing expenses from the list.
- **View Expenses**: Users can view all their expenses in a tabular format.
- **Filter by Minimum**: Users can filter expenses to see the ones with the lowest prices.
- **Filter by Maximum**: Users can filter expenses to see the ones with the highest prices.
- **Save to CSV**: Users can save their expenses to a CSV file for further analysis.
- **Statistics**: Users can view statistics on their expenses, including the lowest, highest, and average costs, presented in a bar chart.

## Technologies Used

- **Java**: The backend of the application is developed using Java.
- **Spring Boot**: Spring Boot is used for building the web application.
- **Thymeleaf**: Thymeleaf is used as the template engine for server-side processing.
- **MySQL**: MySQL is used as the database to store expense data.
- **Apache Commons CSV**: Apache Commons CSV is used to handle CSV file operations.
- **Chart.js**: Chart.js is used to create interactive charts for expense statistics.

## Getting Started

To run the Expense Tracker application locally, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd ExpenseTracker`
3. Build the project: `./mvnw clean package`
4. Run the application: `java -jar target/ExpenseTracker-0.0.1-SNAPSHOT.jar`
5. Access the application in your web browser at `http://localhost:8080`

## Usage

1. **Adding Expense**: Click on the "Add New Expense" section, enter the description and price of the expense, then click "Add".
2. **Deleting Expense**: Each expense in the list has a "Delete" button. Click on it to delete the corresponding expense.
3. **Filtering Expenses**: Use the "Filter by Minimum" and "Filter by Maximum" buttons to filter expenses based on their prices.
4. **Saving to CSV**: Click on the "Save to CSV" button to save all expenses to a CSV file.
5. **Viewing Statistics**: Click on the "Statistics" button to view statistics on expenses, including lowest, highest, and average costs.

## Contributors

This project was developed by Mateusz Ptasik. Feel free to contribute by submitting bug reports, feature requests, or pull requests.

## License

This project is licensed under the [MIT License](LICENSE).

