# Blogging App
## JSON Entities
### User

    {
	    "id" :  212,
	    "name" : "brate Johns",
	    "email" : "brate@mail.com",
	    "password" :  "xxxxxxxxx",
	    "authtoken" : "ewrwrwqrwqewqrwqfehrejhrb",
	    "bio" : "Prime User",
	    "image" : "https://images.com/image1.png",
    }

### Article

    {
	    "id" : 323,
		"title" : "Sample title",
		"slug" : "how-to-do-exercise"
		"subtitle" : "sample subtitile",
		"body" : "This is the sample body",
		"createdAt" :"2023-02-02 09:22:45"
	}

### Comments

    {
    	"id" :  212,
		"title" : "Sample title",
		"body" :  "Sample body...",
		"createdAt" :"2023-02-02 09:22:45"
	}

## API Endpoints

### `POST /users`
create a new users

### `POST /users/login`

### `GET /profiles`

### `GET /profiles/{username}`

### `GET /articles` 📄
get all articles
available filters
- `/articles?tag=stocks`
- `/articles?author=brate`
- `/articles?page=3&size=10`

### `GET /articles/{article-slug}`

### `POST /articles`
create a new article

### `POST /articles`🔐
create a new article

### `PATCH /articles/{article-slug}`🔐👤
edit and article

### `GET /article/{article-slug}/comments`📄
get all comments of and article

### `POST /article/{article-slug}/comments`🔐

### `DELETE /articles/{article-slug}/comments/{comment-id}`🔐👤
