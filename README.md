# Test task to Oril

## Functional
1 The application receives the latest (every 15 seconds) data on currency pairs on  [CEX.IO](https://cex.io/), saves this data in the database and log output to the console 

2 Handles REST requests:
  - GET /cryptocurrencies/minprice?name=[currency_name] - return record with the lowest price of selected cryptocurrency.
  - GET /cryptocurrencies/maxprice?name=[currency_name] - return record with the highest price of selected cryptocurrency [currency_name] possible values: BTC, ETH or XRP. If some other value is provided then appropriate error message should be thrown
  - GET /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - return a selected page with selected number of elements and default sorting should be by price from lowest to highest. For example, if page=0&size=10, then you should return first 10 elements from database, sorted by price from lowest to highest. [page_number] and [page_size] request parameters should be optional, so if they are missing then you should set them default values page=0, size=10.

3 Generate a CSV report:
- GET /cryptocurrencies/csv Report contain the following fields: Cryptocurrency Name, Min Price, Max Price.

## Technologies:
  - Maven
  - Java 8+
  - String Boot, Spring Data
  - PostgreSQL
  - log4j
  - SuperCSV


