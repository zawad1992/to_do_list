## API Documentation

### Todo List

- **Request:** GET `/api/v1/todo-list`

  Fetches the list of todos.

- **Response:**

  - Status: 200 OK
  - Headers:
    - `Content-Type: application/json`
    - `Transfer-Encoding: chunked`
    - `Date: Sun, 18 Jun 2023 15:29:12 GMT`
    - `Keep-Alive: timeout=60`
    - `Connection: keep-alive`
  - Body:
    ```json
    [
        {
            "id": 2,
            "title": "Buy groceries",
            "description": "ZAWAD.",
            "status": false
        },
        {
            "id": 3,
            "title": "Buy groceries",
            "description": "Go to the supermarket and buy the necessary items.",
            "status": false
        },
        ...
    ]
    ```

### Todo List by ID

- **Request:** GET `/api/v1/todo-list/1`

  Fetches a specific todo by ID.

- **Response:**

  - Status: 200 OK
  - Headers:
    - `Content-Type: application/json`
    - `Transfer-Encoding: chunked`
    - `Date: Sun, 18 Jun 2023 16:01:03 GMT`
    - `Keep-Alive: timeout=60`
    - `Connection: keep-alive`
  - Body:
    ```json
    {
        "id": 4,
        "title": "Buy groceries",
        "description": "Go to the supermarket and buy the necessary items.",
        "status": false
    }
    ```

### Todo Create

- **Request:** POST `/api/v1/todo-create`

  Creates a new todo.

  - Body:
    ```json
    {
      "title": "Buy groceries",
      "description": "Go to the supermarket and buy the necessary items.",
      "status": false
    }
    ```

- **Response:**

  - Status: 200 OK
  - Headers:
    - `Content-Type: application/json`
    - `Transfer-Encoding: chunked`
    - `Date: Sun, 18 Jun 2023 15:56:18 GMT`
    - `Keep-Alive: timeout=60`
    - `Connection: keep-alive`
  - Body:
    ```json
    {
        "id": 16,
        "title": "Buy groceries",
        "description": "Go to the supermarket and buy the necessary items.",
        "status": false
    }
    ```

### Todo Update

- **Request:** POST `/api/v1/todo-update/1`

  Updates an existing todo by ID.

  - Body:
    ```json
    {
      "title": "Buy groceries",
      "description": "ZAWAD.",
      "status": false
    }
    ```

- **Response:**

  - Status: 200 OK
  - Headers:
    - `Content-Type: text/plain;charset=UTF-8`
    - `Content-Length: 12`
    - `Date: Sun, 18 Jun 2023 15:18:14 GMT`
    - `Keep-Alive: timeout=60`
    - `Connection: keep-alive`
  - Body: `Todo updated`

### Todo Delete

- **Request:** DELETE `/api/v1/todo-delete/2`

  Deletes a todo by ID.

- **Response:**

  - Status: 200 OK
  - Headers:
    - with no response (max_response_length=64).
