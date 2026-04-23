🎯 Phase 1: Basics (Start HERE)

👉 Goal: Understand how APIs talk to your DB

✅ Endpoints (only 2–3)
1️⃣ Get Categories
GET /api/categories

👉 SQL:

SELECT * FROM categories;
2️⃣ Add Player (basic POST)
POST /api/players

Body:

{
"name": "Alice",
"roomId": 1
}

👉 SQL:

INSERT INTO players (name, room_id) VALUES (?, ?);
3️⃣ Get Players
GET /api/players/{roomId}

👉 SQL:

SELECT * FROM players WHERE room_id = ?;
🧠 What You Learn in Phase 1

✔ GET vs POST
✔ Request body handling
✔ Path variables
✔ DB connection
✔ Testing with Postman

🚀 Phase 2: Intermediate (Game Basics)

👉 Goal: Connect game data

Add 2–3 more endpoints
4️⃣ Get Questions
GET /api/questions
5️⃣ Create Game Room
POST /api/game/create
6️⃣ Get Game Board
GET /api/game/{roomId}/board
🧠 What You Learn

✔ Joins in SQL
✔ Multiple tables
✔ Game structure

🔥 Phase 3: Game Logic

👉 Now things get interesting

7️⃣ Select Question
POST /api/game/{roomId}/question/{questionId}
8️⃣ Submit Answer
POST /api/game/{roomId}/answer
9️⃣ Get Scores
GET /api/game/{roomId}/players
🧠 What You Learn

✔ Update queries
✔ Business logic
✔ Score handling

⚡ Phase 4: Advanced (Optional)
WebSockets (real-time)
Authentication
UI integration
🎯 Final Endpoint Count (Beginner Friendly)
Phase	Endpoints
Basic	2–3
Intermediate	3
Advanced Game	3
Total	6–9 endpoints
🪜 How You Should Learn (Important)

👉 Follow this exact order:

✔ GET /categories
✔ POST /players
✔ GET /players
✔ GET /questions
✔ POST /game/create
✔ GET /board
✔ Add game logic

