# REST API Pagination

## Versions Info
* Java 17
* Spring 2.7.4

## Offset Pagination

1) Fetching records of products with default pageSize of 5.

`http://localhost:2650/example/offset/products`

2) Fetching records of products with default pageSize of 5 starting with page 0.

`http://localhost:2650/example/offset/products?page=0`
`http://localhost:2650/example/offset/products?page=1`
`http://localhost:2650/example/offset/products?page=2`

3) Fetching records with a limit greater then MAX_PAGE_SIZE =10. Since the limit is greater than 10 the API will limit to 10 records only.

`http://localhost:2650/example/offset/products?page=0&limit=25`
`http://localhost:2650/example/offset/products?page=1&limit=25`

4) Fetching records with a limit less then MAX_PAGE_SIZE =10

`http://localhost:2650/example/offset/products?page=0&limit=7`
`http://localhost:2650/example/offset/products?page=1&limit=7`

## Cursor Pagination Example:

### Key Points:

- Cursor: The afterId parameter acts as the cursor, indicating the starting point for the next page.
- Repository Method: The findByProductIdGreaterThanOrderByProductId method fetches products with IDs greater than the cursor, ensuring ordered results.
- Pageable: The Pageable object is used for pagination, but the page number is always 0 as we're using the cursor for navigation.
- Controller: The controller handles requests with optional afterId and pageSize parameters.

### Usage:
1. Fetching records of products with default pageSize of 5.

`http://localhost:2650/example/cursor/products?afterId=0`
`http://localhost:2650/example/cursor/products?afterId=5`
`http://localhost:2650/example/cursor/products?afterId=10`


2. Fetching records with a pageSize greater then MAX_PAGE_SIZE =10. Since the pageSize is greater than 10 the API will limit to 10 records only.

`http://localhost:2650/example/cursor/products?afterId=0&pageSize=25`
`http://localhost:2650/example/cursor/products?afterId=10&pageSize=25`


3. Fetching records with a pageSize less then MAX_PAGE_SIZE =10

`http://localhost:2650/example/cursor/products?afterId=0&pageSize=3`
`http://localhost:2650/example/cursor/products?afterId=3&pageSize=3`
`http://localhost:2650/example/cursor/products?afterId=6&pageSize=3`
`http://localhost:2650/example/cursor/products?afterId=9&pageSize=3`


## KeySet Pagination

Key Points:

- Keyset: The createdAt attribute serves as the unique, ordered key for pagination.
- Repository Method: The findByCreatedAtGreaterThanOrderByCreatedAt method fetches products with creation times greater than the key, ensuring ordered results.
- Pageable: The Pageable object is used for pagination, but the page number is always 0 as we're using keyset for navigation.
- Controller: The controller handles requests with optional afterKey and pageSize parameters.

Usage:

- To fetch the first page: GET /products?pageSize=10
- To fetch subsequent pages: GET /products?afterKey=1661540812345&pageSize=10 (where 1661540812345 is the last createdAt value from the previous page)


`http://localhost:2650/example/keyset/products?afterKey=0`
`http://localhost:2650/example/keyset/products?afterKey=1661465600`
`http://localhost:2650/example/keyset/products?afterKey=1661372800`
`http://localhost:2650/example/keyset/products?afterKey=1661558400`

`http://localhost:2650/example/keyset/products?afterKey=0&pageSize=4`
