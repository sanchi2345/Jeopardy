# 🗄️ Database Design – Jeopardy Game

This document describes the database structure for the Jeopardy Multiplayer Quiz Game.

---

## ⚠️ Initial Approach (Single Table)

### Table: `jeopardy_questions`

| Column Name      | Data Type        | Description |
|-----------------|----------------|-------------|
| id              | SERIAL (PK)     | Unique question ID |
| category        | VARCHAR(50)     | Question category |
| question        | TEXT            | Question text |
| answer          | TEXT            | Correct answer |
| amount          | INT             | Points (100, 200, etc.) |
| is_visited      | BOOLEAN         | Whether question is already used |

---

## 📚 Categories Used

- Sports
- Movies
- DishName (Food)
- Technology
- History

---

## ❌ Limitations of Single Table

- Hard to manage multiplayer sessions
- No user tracking
- No game state separation
- Cannot scale for multiple rooms
- `is_visited` will conflict between players/games

---

## ✅ Recommended Database Design (Normalized)

### 1. Table: `categories`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | Category ID |
| name       | VARCHAR  | Category name |

---

### 2. Table: `questions`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | Question ID |
| category_id| INT (FK) | Reference to category |
| question   | TEXT     | Question text |
| answer     | TEXT     | Correct answer |
| amount     | INT      | Points |

---

### 3. Table: `game_rooms`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | Room ID |
| status     | VARCHAR  | active / completed |
| created_at | TIMESTAMP| Room creation time |

---

### 4. Table: `players`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | Player ID |
| name       | VARCHAR  | Player name |
| room_id    | INT (FK) | Game room |

---

### 5. Table: `scores`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | Score ID |
| player_id  | INT (FK) | Player |
| room_id    | INT (FK) | Game room |
| score      | INT      | Total score |

---

### 6. Table: `game_questions` (IMPORTANT)

Tracks which questions are used in a game.

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id         | SERIAL   | ID |
| room_id    | INT (FK) | Game room |
| question_id| INT (FK) | Question |
| is_visited | BOOLEAN  | Used or not |

---

## 🎯 Why This Design is Better

- Supports multiple players
- Supports multiple game rooms
- No data conflicts
- Scalable & production-ready
- Clean separation of logic

---

## 🧠 Final Recommendation

Start simple if needed, but **quickly move to normalized design** for multiplayer support.